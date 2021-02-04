/*
 *    Copyright (c) 2018-2025, songfayuan All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the 霖梓控股 developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: songfayuan (1414798079@qq.com)
 */

package com.admin.crawler.utils;

import com.admin.crawler.baomidou.SqlParserHandler;
import com.admin.crawler.baomidou.toolkit.PluginUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author songfayuan
 * @date 2018/1/19
 * 数据权限插件，guns
 */
@Slf4j
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})})
public class DataScopeInterceptor extends SqlParserHandler implements Interceptor {


    /**
     * 代替拦截对象的方法内容
     * 责任链对象
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        this.sqlParser(metaObject);
        // 先判断是不是SELECT操作
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

        String mapperdId = getMapperId(mappedStatement);
        Configuration configuration = mappedStatement.getConfiguration();
        log.info(mapperdId + " : " + showSql(configuration,boundSql));
        //如果当前代理的是一个非代理对象，那么它就回调用真实拦截器对象方法，如果不是，它会调度下个插件代理对象的invoke方法。
        Object result = invocation.proceed();
        return result;
    }


    public static String showSql(Configuration configuration, BoundSql boundSql) {
        try {
            Map<String,String> listMap = new HashMap<>();
            Object parameterObject = boundSql.getParameterObject();
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
            if (parameterMappings.size() > 0 && parameterObject != null) {
                TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
                if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                    String value = getParameterValue(parameterObject);
                    if (value.contains("?")) {
                        String key =  getUserPoolOrder("rn");
                        listMap.put(key,value);
                        value = key;
                    }
                    sql = sql.replaceFirst("\\?", value);
                } else {
                    MetaObject metaObject = configuration.newMetaObject(parameterObject);
                    int i = 0;
                    for (ParameterMapping parameterMapping : parameterMappings) {
                        String propertyName = parameterMapping.getProperty();
                        if (metaObject.hasGetter(propertyName)) {
                            Object obj = metaObject.getValue(propertyName);
                            String value = getParameterValue(obj);
                            if (value.contains("?")) {
                                String key =  getUserPoolOrder("rn" + i );
                                listMap.put(key,value);
                                value = key;
                            }
                            sql = sql.replaceFirst("\\?", value);
                        } else if (boundSql.hasAdditionalParameter(propertyName)) {
                            Object obj = boundSql.getAdditionalParameter(propertyName);

                            String value = getParameterValue(obj);
                            if (value.contains("?")) {
                                String key =  getUserPoolOrder("rn" + i );
                                listMap.put(key,value);
                                value = key;
                            }
                            sql = sql.replaceFirst("\\?", value);
                        }
                        i ++;
                    }
                }
            }
            if(!listMap.isEmpty()){
                for (Map.Entry<String, String> m : listMap.entrySet()) {
                    sql = sql.replaceAll(m.getKey(),m.getValue());
                }
            }
            return sql;
        } catch (Exception e) {
            log.error("showSql exception ", e);
        }
        return "";
    }


    public static String getUserPoolOrder(String pre) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyMMddHHmmssSSS");
        StringBuffer sb = new StringBuffer(pre);
        return sb.append(dateformat.format(System.currentTimeMillis()))
                .append((int) (Math.random() * 1000)).toString();
    }



    public static String getMapperId(MappedStatement mappedStatement) {
        try {
            String id =  mappedStatement.getId();
            if(id.contains(".")){
                String ids []= id.split("\\.");
                return ids[ids.length -2  ] +"."+ ids[ids.length -1 ];
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "";
    }





    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(obj) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "''";
            }
        }
        return value;
    }



    /**
     * 生成拦截对象的代理
     *
     * @param target 目标对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            //使用MyBatis提供的Plugin类生成代理对象
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * @param properties mybatis获取插件的属性，我们在MyBatis配置文件里配置的
     */
    @Override
    public void setProperties(Properties properties) {

    }


}
