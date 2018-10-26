package demo.activiti.controller;

import lombok.Data;

/**
 * @Auther: sunjx
 * @Date: 2018/10/26 0026 10:47
 * @Description:
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public Result(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(String msg, T data){
        return new Result("0000", msg, data);
    }
}
