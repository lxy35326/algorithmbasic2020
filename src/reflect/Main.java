package reflect;

import java.lang.reflect.*;
import java.util.List;

interface UserType {
    public Type returnedClass();
}

abstract class AbstractUserType<T> implements UserType {
    T returnT(T[] val) {
        return null;
    }

    @Override
    public Type returnedClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return parameterizedType.getActualTypeArguments()[0];
    }

    public static Class<?> type2Class(Type type) {
        if (type instanceof Class) {
            return (Class<?>) type;
        } else if (type instanceof GenericArrayType) {
            //having to create an array instance to get the class is kinda nasty
            //but apparently this is a current limitation of java-reflection concerning array classes.
            //E.g.  T[] -> T -> Object.class if <T>   of Number.class if <T extends Number & Comparable>
            return Array.newInstance(type2Class(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else if (type instanceof ParameterizedType) {
            return type2Class(((ParameterizedType) type).getRawType());
        } else if (type instanceof TypeVariable) {
            Type[] bounds = ((TypeVariable<?>) type).getBounds();
            return bounds.length == 0 ? Object.class : type2Class(bounds[0]);
        } else if (type instanceof WildcardType) {
            Type[] bounds = ((WildcardType) type).getUpperBounds();
            return bounds.length == 0 ? Object.class : type2Class(bounds[0]);
        } else {
            throw new UnsupportedOperationException("cannot handle type class: " + type.getClass());
        }
    }
}

public class Main {

    static void testErase() throws Exception {
        AbstractUserType<Integer[]> abstractUserType = new AbstractUserType<Integer[]>() {
        };

        Method returnT = AbstractUserType.class.getDeclaredMethod("returnT", Object[].class);
        Type genericReturnType = returnT.getGenericParameterTypes()[0];
        System.out.println(AbstractUserType.type2Class(genericReturnType));
    }


    static void testConcrete() throws Exception {
        Type type = new AbstractUserType<String[]>() {
        }.returnedClass();
        System.out.println(type instanceof Class);
        ParameterizedType p = (ParameterizedType) type;
        System.out.println(p.getActualTypeArguments());
        System.out.println(p.getRawType());
        System.out.println(p.getOwnerType());

        System.out.println(type instanceof ParameterizedType);

    }

    public static void main(String[] args) throws Exception {
        testConcrete();
    }
}
