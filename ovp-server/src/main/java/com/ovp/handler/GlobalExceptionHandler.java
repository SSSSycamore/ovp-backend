package com.ovp.handler;

import com.ovp.constant.MessageConstant;
import com.ovp.result.Result;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
@Hidden
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(Exception ex){
        String msg = ex.getMessage();
        log.error("异常信息：{}", msg);

        // 判断是否是资源找不到的异常（如访问 /webjars/**）
        if (msg != null && (
                msg.contains("No static resource") ||
                msg.contains("No handler found") ||
                msg.contains("Resource not found"))) {
            // 返回 null 表示不处理，交给 Spring Boot 默认机制返回 404
            return null;
        }

        return Result.error(msg != null ? msg : "服务器内部异常");
    }

    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error("异常信息：{}", ex.getMessage());
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")) {
            String[] split = message.split(" ");
            String msg = split[2] + MessageConstant.ALREADY_EXIST;
            return Result.error(msg);
        }else{
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }

    //TODO 前端在获取响应后统一处理异常信息
    @ExceptionHandler
    public Result validationExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errors = new ArrayList<>();
        fieldErrors.stream().forEach(fieldError -> errors.add(fieldError.getDefaultMessage()));
        String errorMessage = String.join(", ", errors);
        log.error("参数校验异常：{}", errorMessage);
        return Result.error(errorMessage);
    }
}
