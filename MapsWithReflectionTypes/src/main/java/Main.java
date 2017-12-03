import com.google.common.collect.Maps;
import org.javatuples.Triplet;

import java.util.Map;

public class Main {
    private static Map<Triplet<Class<?>, String, Class<?>>, String> map = Maps.newConcurrentMap();

    public static void main(String[] args) {
        Triplet<Class<?>, String, Class<?>> t1 = Triplet.with(String.class, "hello", String.class);
        Triplet<Class<?>, String, Class<?>> t2 = Triplet.with(String.class, "hello2", String.class);
        Triplet<Class<?>, String, Class<?>> t3 = Triplet.with(Integer.class, "hello", String.class);
        map.put(t1,"t1");
        map.put(t2,"t2");
        map.put(t3,"t3");
        Triplet<Class<?>, String, Class<?>> t4 = Triplet.with(Integer.class, "hello", String.class);
        System.out.println(map);
        System.out.println(map.get(t4));
        System.out.println(map.get(t3));
    }
}
