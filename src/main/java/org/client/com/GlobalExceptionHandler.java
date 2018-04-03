package org.client.com;

import feign.FeignException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.client.com.util.resultJson.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

/**
 * 全局异常处理
 * LD
 */
@ControllerAdvice
@ResponseBody
@Controller
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 权限不足
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public ResponseResult authorizationException(HttpServletRequest request,
                                                 Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "权限不足");
    }

    /**
     * 权限不足
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseResult UnauthorizedException(HttpServletRequest request,
                                                Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "权限不足");
    }

    /**
     * 未登录
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = UnauthenticatedException.class)
    public ResponseResult UnauthenticatedException(HttpServletRequest request,
                                                   Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "请登录");
    }


    /**
     * 类型强制转换异常
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ClassCastException.class)
    @ResponseBody
    public ResponseResult ClassCastException(HttpServletRequest request,
                                             Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "数据类型错误，请确认");
    }


    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    public ResponseResult ArrayIndexOutOfBoundsException(HttpServletRequest request,
                                                         Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "数据类型错误，请确认");
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    @ResponseBody
    public ResponseResult FileNotFoundException(HttpServletRequest request,
                                                Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());

        return new ResponseResult<>(false, "文件未找到");
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public ResponseResult SQLException(HttpServletRequest request,
                                       Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "数据错误");
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public ResponseResult IOException(HttpServletRequest request,
                                      Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "输入输出错误");
    }

    @ExceptionHandler(value = NoSuchMethodException.class)
    @ResponseBody
    public ResponseResult NoSuchMethodException(HttpServletRequest request,
                                                Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "未找到方法");
    }

    @ExceptionHandler(value = OutOfMemoryError.class)
    @ResponseBody
    public ResponseResult OutOfMemoryError(HttpServletRequest request,
                                           Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "内存超出");
    }

    @ExceptionHandler(value = StackOverflowError.class)
    @ResponseBody
    public ResponseResult StackOverflowError(HttpServletRequest request,
                                             Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "堆栈异常");
    }

    @ExceptionHandler(value = VirtualMachineError.class)
    @ResponseBody
    public ResponseResult VirtualMachineError(HttpServletRequest request,
                                              Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "虚拟机错误");
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResponseResult nullPointerException(HttpServletRequest request,
                                               Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "空指针错误");
    }

    @ExceptionHandler(value = org.xml.sax.SAXException.class)
    @ResponseBody
    public ResponseResult SAXException(HttpServletRequest request,
                                       Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "页面存在多个<!DOCTYPE html>");
    }

    @ExceptionHandler(value = org.xml.sax.SAXParseException.class)
    @ResponseBody
    public ResponseResult SAXParseException(HttpServletRequest request,
                                            Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "class重复");
    }

    @ExceptionHandler(value = FeignException.class)
    @ResponseBody
    public ResponseResult feignException(HttpServletRequest request,
                                         Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "服务链接异常");
    }

    @ExceptionHandler(value = feign.RetryableException.class)
    @ResponseBody
    public ResponseResult retryableException(HttpServletRequest request,
                                             Exception exception) throws Exception {
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        return new ResponseResult<>(false, "服务链接超时");
    }

}
