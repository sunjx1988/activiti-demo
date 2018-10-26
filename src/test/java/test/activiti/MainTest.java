package test.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @Auther: sunjx
 * @Date: 2018/10/26 0026 11:28
 * @Description:
 */
public class MainTest {

    @Test
    public void createTable() {

        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
                .buildProcessEngine();
        System.out.println(processEngine);
    }

}
