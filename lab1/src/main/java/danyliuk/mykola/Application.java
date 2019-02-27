package danyliuk.mykola;

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
public class Application {

    public static void main(String[] args){
        Polynomial polynomial1 = new Polynomial(new double[]{1.1,2.2});
        Polynomial polynomial2 = new Polynomial(new double[]{3.3,4.4});
        RationalExpression rationalExpression = new RationalExpression(polynomial1,polynomial2);

        invokeAnnotatedMethods(rationalExpression);

        printReflectionInfo(RationalExpression.class);



    }

    private static void invokeAnnotatedMethods(RationalExpression expression){
        List<Method> methods = getMethodsAnnotatedWith(RationalExpression.class,PublicAccess.class);
        for(Method method:methods){
            method.setAccessible(true);
            try {
                Object obj = method.invoke(expression);
                System.out.println("Return from invoke method: " + obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printReflectionInfo(Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            String name = field.getName();
            String type = field.getType().getName();
            int modifierInt = field.getModifiers();
            String modifier = Modifier.toString(modifierInt);
            Annotation[] annotations = clazz.getAnnotations();
            System.out.println("Field name: " + name + " ,type: " + type +
                    " ,modifier: " + modifier + ",annotations: " + Arrays.toString(annotations));
        }
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

}
