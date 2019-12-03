package com.mycls.pojo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;
import com.mycls.dao.UserDao;

@Configuration //通过该注解来表明该类是一个Spring的配置，相当于一个xml文件
@ComponentScan(basePackages = "com.mycls") //配置扫描包，扫描注解
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true)
public class SpringConfig {

	@Value("${jdbc.user}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.driver")
	private String driver;
	
	@Bean // 通过该注解来表明是一个Bean对象，相当于xml中的<bean>，交给spring管理
    public UserDao getUserDAO(){
        return new UserDao(); // 直接new对象做演示
    }

	@Bean(destroyMethod = "close")
    public DataSource dataSource() { //（默认把方法名作为bean的id，所以不用get DataSource）
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        // 数据库驱动
        boneCPDataSource.setDriverClass(driver);
        // 相应驱动的Url
        boneCPDataSource.setJdbcUrl(url);
        // 数据库的用户名
        boneCPDataSource.setUsername(username);
        // 数据库的密码
        boneCPDataSource.setPassword(password);
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数    
        boneCPDataSource.setMinConnectionsPerPartition(5);
        return boneCPDataSource;
}


	
}
