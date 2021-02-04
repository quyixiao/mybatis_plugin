package com.test;

import com.admin.crawler.entity.TestUser;
import com.admin.crawler.mapper.MyBaseMapper;
import com.admin.crawler.mapper.TestUserMapper;
import com.admin.crawler.processor.CustomerMapperBuilder;
import com.admin.crawler.utils.SqlParseUtils;
import com.admin.crawler.utils.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeTest {

    static class Test2 implements MyBaseMapper<TestUser> {
    }

    public static void main(String[] args) {

        String tableName = "";
        //获取接口定义上的泛型类型
        //一个类可能实现多个接口,每个接口上定义的泛型类型都可取到
        Type[] interfacesTypes = TestUserMapper.class.getGenericInterfaces();
        for (Type t : interfacesTypes) {
            Type[] genericType2 = ((ParameterizedType) t).getActualTypeArguments();
            for (Type t2 : genericType2) {
                System.out.println(t2.getTypeName());
                try {
                    Class c = Class.forName(t2.getTypeName());
                    tableName = SqlParseUtils.getAnnotationValueByTypeName(c, CustomerMapperBuilder.TABLENAME);
                    if (StringUtils.isNotEmpty(tableName)) {
                        break;
                    }
                } catch (Exception e) {
                }
            }
        }
        System.out.println(tableName);
    }
}