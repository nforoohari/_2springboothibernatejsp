package ir.digixo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"ir.digixo"})
@EnableTransactionManagement
//@PropertySource("jdbc.properties")
public class Config {
    private static Logger logger = LoggerFactory.getLogger(Config.class);

  /*  @Value( "${jdbc.driverClassName}" )
    String driverClassName;
    @Value( "${jdbc.url}" )
    String url;
    @Value( "${jdbc.username}" )
    String userName;
    @Value( "${jdbc.password}" )
    String password;*/
    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource=new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/nimatest?createDatabaseIfNotExist=true");
        basicDataSource.setUsername("nimauser");
        basicDataSource.setPassword("1234");
        return basicDataSource;
    }


   @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
  {
      LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
      localContainerEntityManagerFactoryBean.setDataSource(dataSource());
      localContainerEntityManagerFactoryBean.setPackagesToScan("ir.digixo.entity");
      localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      localContainerEntityManagerFactoryBean.setJpaProperties(JPAProperties());
      return localContainerEntityManagerFactoryBean;
  }


  public Properties JPAProperties()
  {
      Properties props=new Properties();
      props.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
      props.put("hibernate.show_sql",true);
      props.put("hibernate.hbm2ddl.auto","update");

      props.put("hibernate.format_sql",true);
      props.put("hibernate.use_sql_comments",true);
      props.put("hibernate.max_fetch_depth",3);
      props.put("hibernate.jdbc.fetch_size",50);
      props.put("hibernate.jdbc.batch_size",500);
      return props;
  }

  /*@Bean
  public JpaTransactionManager jpaTransactionManager()
  {
      JpaTransactionManager transactionManager=new JpaTransactionManager();
      jpaTransactionManager().setEntityManagerFactory(entityManagerFactoryBean().getObject());
     // return jpaTransactionManager();
      return transactionManager;
  }*/



    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
        transactionManager.setDataSource(dataSource());
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }


}
