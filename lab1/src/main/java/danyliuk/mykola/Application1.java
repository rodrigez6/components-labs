package danyliuk.mykola;

import danyliuk.mykola.model.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mykola Danyliuk
 */
public class Application1 {

    public static void main(String[] args){
        Polynomial polynomial1 = new Polynomial(new int[]{1, 5});
        Polynomial polynomial2 = new Polynomial(new int[]{3, 2});
        RationalExpression rationalExpression = new RationalExpression(polynomial1,polynomial2);

        invokeAnnotatedMethods(rationalExpression);

        printReflectionInfo(RationalExpression.class);

        getAnnotations(RationalExpression.class);

        invokeProxy(rationalExpression);

    }

    public static boolean invokeAnnotatedMethods(RationalExpression expression){
        List<Method> methods = getMethodsAnnotatedWith(RationalExpression.class, PublicAccess.class);
        for(Method method:methods){
            method.setAccessible(true);
            try {
                Object obj = method.invoke(expression);
                System.out.println("Invoked private method: " + obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    static void printReflectionInfo(Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            String name = field.getName();
            String type = field.getType().getName();
            int modifierInt = field.getModifiers();
            String modifier = Modifier.toString(modifierInt);

            System.out.println("Field name: " + name + " ,type: " + type + " ,modifier: " + modifier);
        }
    }

    private static void getAnnotations(final Class<?> type){
        Method[] methods = type.getDeclaredMethods();
        List<Annotation> annotations = new ArrayList<>();
        for(Method method:methods){
            Annotation[] methodAnnotations = method.getAnnotations();
            List<Annotation> methodAnnotationList = Arrays.asList(methodAnnotations);
            annotations.addAll(methodAnnotationList);
        }
        System.out.println("Annotations:" + annotations);
    }

    private static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new ArrayList<>();
        Class<?> klass = type;
        while (klass != Object.class) {
            final List<Method> allMethods = new ArrayList<>(Arrays.asList(klass.getDeclaredMethods()));
            for (final Method method : allMethods) {
                if (method.isAnnotationPresent(annotation)) {
                    methods.add(method);
                }
            }
            klass = klass.getSuperclass();
        }
        return methods;
    }

    static boolean invokeProxy(RationalExpression expression){
        Class clazz = RationalExpression.class;
        IRationalExpression proxyInstance = (IRationalExpression) java.lang.reflect.Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new Proxy(expression));
        try {
            Polynomial polynomial = new Polynomial(new int[]{1});
            proxyInstance.setNumerator(polynomial);
        } catch (Exception e){
            System.out.println("Cause exception: " + e.getCause().getMessage());
            return false;
        }
        return true;
    }

}
