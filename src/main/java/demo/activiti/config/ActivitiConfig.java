package demo.activiti.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Auther: sunjx
 * @Date: 2018/10/26 0026 11:37
 * @Description:
 */
@Configuration
public class ActivitiConfig  extends AbstractProcessEngineAutoConfiguration {

    /**
     * 工作流数据库
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 工作流 引擎对象创建
     */
    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(
            PlatformTransactionManager transactionManager,
            SpringAsyncExecutor springAsyncExecutor) throws IOException {

        return baseSpringProcessEngineConfiguration(
                dataSource,
                transactionManager,
                springAsyncExecutor);
    }
}
