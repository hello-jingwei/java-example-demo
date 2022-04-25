package com.reflect.framework.proxy;

import com.reflect.framework.annotation.FrAnnotation;
import com.reflect.framework.service.EvtService;
import com.reflect.framework.service.EvtServiceImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ProxyHandler implements InvocationHandler {
    private Object target;

    public Object proxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        AnnotatedType annotatedParameterType = method.getAnnotatedParameterTypes()[0];
        Type type = annotatedParameterType.getType();
        for (Method annMethods : FrAnnotation.class.getMethods()) {
            if (annMethods.getReturnType().getTypeName().equals(type.getTypeName())) {
                Annotation[][] annotations = method.getParameterAnnotations();
                for (int i = 0; i < annotations.length; i++) {
                    for (int j = 0; j < annotations[i].length; j++) {
                        if (annotations[i][j] instanceof FrAnnotation) {
                            FrAnnotation frAnnotation = (FrAnnotation) annotations[i][j];
                            for (String name : frAnnotation.name()) {
                                System.out.println(name);
                            }
                            for (Object arg : args) {
                                System.out.println(arg.toString());
                            }

                        }
                    }
                }
            }
        }
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        EvtServiceImpl evtServiceImpl = new EvtServiceImpl();
        EvtService evtService = (EvtService) proxyHandler.proxy(evtServiceImpl);
        evtService.introduce();
    }
}
