package com.ovp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ovp.context.BaseContext;
import com.ovp.dto.PageQueryDTO;
import com.ovp.dto.RankVideoQueryDTO;
import com.ovp.dto.VideoDTO;
import com.ovp.entity.Like;
import com.ovp.entity.Video;
import com.ovp.mapper.LikeMapper;
import com.ovp.mapper.VideoMapper;
import com.ovp.service.VideoService;
import com.ovp.vo.VideoBaseVO;
import com.ovp.vo.VideoDetailVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoMapper videoMapper;
    private final LikeMapper likeMapper;

    @Override
    public Integer getVideoCountById(Long id) {
        return videoMapper.getVideoCountById(id);
    }

    @Override
    public void createVideo(VideoDTO videoDTO) {
        Video video = new Video();
        BeanUtils.copyProperties(videoDTO, video);
        video.setUploadTime(LocalDateTime.now());
        // TODO 默认状态为1，表示视频不需要审核
        video.setStatus(1);
        video.setAreaId(videoDTO.getArea_id());
        video.setVideoUrl(videoDTO.getVideo_url());
        video.setCoverUrl(videoDTO.getCover_url());
        System.out.println("video = " + video);
        videoMapper.insert(video);
    }

    @Override
    public void addVideoViews(Long videoId) {
        Video video = videoMapper.selectById(videoId);
        if (video != null) {
            video.setViewCount(video.getViewCount() + 1);
            videoMapper.updateById(video);
        } else {
            throw new RuntimeException("视频不存在");
        }
    }

    @Override
    public VideoDetailVO getVideoDetailById(Long videoId) {
        Video video = videoMapper.selectById(videoId);
        if (video == null) {
            throw new RuntimeException("视频不存在");
        }
        VideoDetailVO videoDetailVO = new VideoDetailVO();
        BeanUtils.copyProperties(video, videoDetailVO);
        // 这里可以根据当前用户的ID设置是否点赞
        Long currentId = BaseContext.getCurrentId();
        videoDetailVO.setIsLike(checkIfUserLikesVideo(currentId, videoId));
        return videoDetailVO;
    }

    @Override
    public List<VideoBaseVO> pageQuery(PageQueryDTO videoPageQueryDTO) {
        Integer pageNo = videoPageQueryDTO.getPageNo();
        Integer pageSize = videoPageQueryDTO.getPageSize();
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Video::getUploadTime);  // 按上传时间降序排列
        Page<Video> videoPage = videoMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);
        List<Video> videoList = videoPage.getRecords();
        List<VideoBaseVO> videoBaseVOList = BeanUtil.copyToList(videoList, VideoBaseVO.class);
        Long currentId = BaseContext.getCurrentId();
        videoBaseVOList.stream().forEach(videoBaseVO-> videoBaseVO.setIsLike(checkIfUserLikesVideo(currentId, videoBaseVO.getId())));
        return videoBaseVOList;
    }

    @Override
    public List<VideoBaseVO> rankQuery(RankVideoQueryDTO rankVideoQueryDTO) {
        Integer type = rankVideoQueryDTO.getType();
        Long areaId = rankVideoQueryDTO.getAreaId();
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        if (type != null) {
            switch (type) {
                case 1: // 最新发布
                    queryWrapper.orderByDesc(Video::getUploadTime);
                    break;
                case 2: // 最多观看
                    queryWrapper.orderByDesc(Video::getViewCount);
                    break;
                case 3: // 最多点赞
                    queryWrapper.orderByDesc(Video::getLikeCount);
                    break;
                default:
                    throw new IllegalArgumentException("无效的排行榜类型");
            }
        }
        queryWrapper.eq(areaId != null, Video::getAreaId, areaId);
        Page<Video> videoPage = videoMapper.selectPage(
                new Page<>(rankVideoQueryDTO.getPageNo(), rankVideoQueryDTO.getPageSize()),
                queryWrapper
        );
        List<VideoBaseVO> videoBaseVOS = BeanUtil.copyToList(videoPage.getRecords(), VideoBaseVO.class);
        Long currentId = BaseContext.getCurrentId();
        videoBaseVOS.forEach(videoBaseVO -> videoBaseVO.setIsLike(checkIfUserLikesVideo(currentId, videoBaseVO.getId())));
        return videoBaseVOS;
    }

    private Boolean checkIfUserLikesVideo(Long currentId, Long videoId) {
        return likeMapper.selectOne(
                new QueryWrapper<Like>()
                        .eq("user_id", currentId)
                        .eq("video_id", videoId)
        ) != null;
    }
}
