package com.admin.crawler.processor;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResolverBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private List<String> mappers = new ArrayList<>();


    public ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(!(bean instanceof  MapperFactoryBean) ){
            return bean;
        }
        if (!check(mappers, beanName)) {
            return bean;
        }
        try {
            System.out.println("============================" + beanName);
            mappers.add(beanName);
            Object factoryBean = ac.getBean("&" + beanName);            //获取 Mapper的工厂方法
            if (factoryBean != null && factoryBean instanceof MapperFactoryBean) {
                MapperFactoryBean mapperFactoryBean = (MapperFactoryBean) factoryBean;
                SqlSession sqlSession = mapperFactoryBean.getSqlSession();
                Configuration configuration = sqlSession.getConfiguration();
                CustomerMapperBuilder customerMapperBuilder = new CustomerMapperBuilder(configuration, mapperFactoryBean.getObjectType());
                customerMapperBuilder.parse();
            }
        } catch (BeansException e) {
            e.printStackTrace();
        } finally {
            mappers.add(beanName);
        }
        return bean;
    }

    public synchronized boolean check(List<String> mappers, String beanName) {
        if (mappers.contains(beanName)) {
            return false;
        }
        return true;
    }

}