package danyliuk.mykola;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Mykola Danyliuk
 */
public class Proxy implements InvocationHandler {

    private Object obj;

    public Proxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("get")){
            return method.invoke(obj,method);
        }
        throw new IllegalAccessException("Not allowed");
    }
}
