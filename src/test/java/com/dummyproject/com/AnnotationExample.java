package com.dummyproject.com;

import com.dummyproject.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

    @Override
    @MethodInfo(author = "Narayan",comments = "Main method",date = "Nov 17 2012",revision = 1)
    public String toString(){
        return "Overridden tostring method";
    }
    @Deprecated
    @MethodInfo(comments = "deprecated method",date = "nov 17 2012")
    public static void oldMethod(){
        System.out.println("old method,don't use it.");
    }
    public static void main(String[] args){
        try{
            for(Method method :AnnotationExample.class.getMethods()){
                if(method.isAnnotationPresent(MethodInfo.class)){
                    try {
                        for ( Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' :" + anno);
                        }
                        MethodInfo methodanno = method.getAnnotation(MethodInfo.class);
                        if(methodanno.revision() == 1){
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    }catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        }catch(SecurityException e){
            e.getStackTrace();
        }
    }
}
