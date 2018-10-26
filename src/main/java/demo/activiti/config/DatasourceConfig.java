package demo.activiti.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Druid连接池配置
 */
@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource dataSource(Environment env){
        DruidDataSource dataSource = DruidDataSourceBuilder
                .create()
                .build(env,"spring.datasource.druid.");
        return dataSource;
    }

}
