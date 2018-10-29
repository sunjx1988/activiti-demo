package demo.activiti.controller;

import lombok.Data;

/**
 * @Auther: sunjx
 * @Date: 2018/10/29 0029 14:36
 * @Description:
 */
@Data
public class BizException extends RuntimeException {

    private String code;

    private String msg;

    private Object data;

    public static final String UNKNOWN_ERROR = "unknown_error";

    public BizException(String code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BizException(String code){
        this.code = code;
    }
}
