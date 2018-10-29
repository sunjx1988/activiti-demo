package demo.activiti.aop;

import demo.activiti.controller.BizException;
import demo.activiti.controller.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: sunjx
 * @Date: 2018/10/29 0029 14:34
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionHandeler {

    //声明要捕获的异常
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Result defultExcepitonHandler(HttpServletRequest request, BizException e) {
        return new Result(e.getCode(), e.getMsg(), null);
    }

}
