package com.test;

import org.springframework.core.DefaultParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DiscoverMethodName {

    public static void main(String[] args) {
        DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        Method[] methods = Test.class.getMethods();
        for(Method method:methods){

            String [] methoNames = parameterNameDiscoverer.getParameterNames(method);
            System.out.println("methodName:" + Arrays.asList(methoNames));
        }

    }


}
