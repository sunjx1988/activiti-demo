package demo.activiti.workflow;

import lombok.Data;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Auther: sunjx
 * @Date: 2018/10/26 0026 17:22
 * @Description: 工作流
 */
@Data
@Component
public class WorkFlowService{

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    /**
     * 创建新流程实例,返回实例ID
     */
    public String newProcess(String key, Map<String, Object> condition){
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, condition);
        return processInstance.getId();
    }

    /**
     * 处理流程实例历史
     */
    public List instanceHistoryByKey(String key, String pid, String uid, int pageNo, int pageSize){
        return historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKey(key)
                .processInstanceId(pid)
                .involvedUser(uid)
                .listPage(pageNo, pageSize);
    }

    /**
     * 实时流程图
     */

    /**
     * 查询当前待办任务列表
     */
    public List<Task> todoListByKey(String key, String uid, int pageNo, int pageSize){
        return taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee(uid)
                .listPage(pageNo, pageSize);
    }

    /**
     * 查询当前待办任务列表
     */
    public List<Task> todoListByPid(String pid, String uid, int pageNo, int pageSize){
        return taskService.createTaskQuery()
                .processInstanceId(pid)
                .taskAssignee(uid)
                .listPage(pageNo, pageSize);
    }

    /**
     * 完成当前任务
     */
    public void finishTask(String tid, String uid, Map<String, Object> condition){
        if(StringUtils.isEmpty(tid)){
            throw new RuntimeException("流程实例ID不能为空");
        }
        Task task = taskService.createTaskQuery().taskId(tid).singleResult();
        task.setAssignee(uid);
        taskService.complete(tid, condition);
    }

}
