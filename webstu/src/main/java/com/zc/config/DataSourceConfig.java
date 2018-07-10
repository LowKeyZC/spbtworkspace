//package com.zc.config;
//
//import com.xes.cloudlearn.framework.db.DynamicRoutingDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 数据源配置
// *
// * @author zhangyt
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Bean("masterDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "application.db.master")
//    public DataSource masterDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("slaveDataSource")
//    @ConfigurationProperties(prefix = "application.db.slave")
//    public DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("dynamicDataSource")
//    public DataSource dynamicDataSource() {
//        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
//        Map<Object, Object> dataSourceMap = new HashMap<>(2);
//        DataSource master = masterDataSource();
//        DataSource slave = slaveDataSource();
//        dataSourceMap.put("masterDataSource", master);
//        dataSourceMap.put("slaveDataSource", slave);
//
//        dynamicRoutingDataSource.setDefaultTargetDataSource(master);
//        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
//
//        return dynamicRoutingDataSource;
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    @Primary
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dynamicDataSource());
//        try {
//            return bean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Bean
//    @Primary
//    public DataSourceTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dynamicDataSource());
//    }
//
//}
