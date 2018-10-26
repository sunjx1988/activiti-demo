package demo.activiti.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: sunjx
 * @Date: 2018/10/26 0026 09:49
 * @Description:
 */
@Slf4j
@Controller
public class MainController {

    private static final String INDEX_PAGE = "index";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return INDEX_PAGE;
    }


}
