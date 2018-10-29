package demo.activiti.controller;

import demo.activiti.workflow.WorkFlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: sunjx
 * @Date: 2018/10/26 0026 10:42
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping("workflow")
public class WorkFlowController {

    private static final String DEFIND_PID = "select";

    @Autowired
    private WorkFlowService workFlowService;

    @ResponseBody
    @RequestMapping(value = "start", method = RequestMethod.GET)
    public Result start(){
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("type", true);
        return Result.success("成功",workFlowService.startProcess(DEFIND_PID,condition));
    }

    @ResponseBody
    @RequestMapping(value = "do_task", method = RequestMethod.GET)
    public Result doTask(@RequestParam(value = "pid") String pid,
                         @RequestParam(value = "tid") String tid){
        workFlowService.doTask(pid,tid,null,null);
        return Result.success("成功", null);
    }

    @RequestMapping(value = "flow_img/{pid}", method = RequestMethod.GET)
    public void list(@PathVariable("pid")String pid, HttpServletResponse response) throws IOException {
        workFlowService.getFlowImgByInstanceId(pid, response.getOutputStream());
    }
}
