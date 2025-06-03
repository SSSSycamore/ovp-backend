package com.ovp.service;

import cn.hutool.db.PageResult;
import com.ovp.dto.PageQueryDTO;
import com.ovp.dto.VideoDTO;
import com.ovp.entity.Video;
import com.ovp.vo.VideoBaseVO;
import com.ovp.vo.VideoDetailVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoService {
    Integer getVideoCountById(Long id);

    void createVideo(VideoDTO videoDTO);

    void addVideoViews(Long videoId);

    VideoDetailVO getVideoDetailById(Long videoId);

    List<VideoBaseVO> pageQuery(PageQueryDTO videoPageQueryDTO);
}
