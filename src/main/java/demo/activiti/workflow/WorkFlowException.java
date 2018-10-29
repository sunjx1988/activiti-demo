package demo.activiti.workflow;

import demo.activiti.controller.BizException;
import lombok.Data;

/**
 * @Auther: sunjx
 * @Date: 2018/10/29 0029 14:28
 * @Description:
 */
@Data
public class WorkFlowException extends BizException {

    public static final String TASK_FINISHED = "task_finished";

    public WorkFlowException(String code, String msg, Object data){
        super(code, msg, data);
    }

    public WorkFlowException(String code){
        super(code);
    }
}
