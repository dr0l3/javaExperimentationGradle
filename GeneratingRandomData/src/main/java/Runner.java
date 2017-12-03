import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    private Random random = new Random();

    public static void main(String[] args) throws Exception {
        Runner runner = new Runner();
        long start = System.currentTimeMillis();
        Set<RandomClass> cornerCases = runner.createCornerCases(RandomClass.class);
        long dif = System.currentTimeMillis() - start;
        System.out.println(dif);
        cornerCases.forEach(System.out::println);
    }


    public <T> Set<T> createCornerCases(Class<T> clazz) throws Exception {
        //create list of fields
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        long one = System.currentTimeMillis();
//        System.out.println(one);
        Map<Field,Set<?>> valuesByField = fields.stream()
                .map(field -> Pair.of(field,getCornerCasesForField(field)))
                .collect(Collectors.toMap(Pair::getKey, Pair::getRight));
        long two = System.currentTimeMillis();
        System.out.println("fields for class :"+clazz.toString()+" -> " + (two-one));
        int complexity = valuesByField.entrySet().stream()
                .map(entry -> entry.getValue().size())
                .reduce(0, Math::max);
        Set<T> res = new HashSet<>();
        long three = System.currentTimeMillis();
        for (int i = 0; i < complexity; i++) {
            T inst = clazz.newInstance();
            for (Map.Entry<Field, Set<?>> entry: valuesByField.entrySet()){
                Field field = entry.getKey();
                field.setAccessible(true);
                List<?> values = Arrays.asList(entry.getValue().toArray());
                Object value = values.get((i%values.size()));
                field.set(inst,value);
                field.setAccessible(false);
            }
            res.add(inst);
        }
        long four = System.currentTimeMillis();
        System.out.println("time for class:"+ clazz.toString()+ " ->"+(four-three));
        return res;
    }

    private Set<?> getCornerCasesForField(Field field){
        Class<?> type = field.getType();

        // Note that we must handle the different types here! This is just an
        // example, so this list is not complete! Adapt this to your needs!
        if(type.isEnum()) {
            return new HashSet<>(Arrays.asList(type.getEnumConstants()));
        } else if(type.equals(Integer.TYPE)) {
            return new HashSet<>(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1, -1));
        } else if (type.equals(Integer.class)){
            return new HashSet<>(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1, -1, null));
        } else if(type.equals(Long.TYPE)) {
            return new HashSet<>(Arrays.asList(Long.MAX_VALUE, Long.MIN_VALUE, 0L, 1L, -1L));
        } else if(type.equals(Long.class)) {
            return new HashSet<>(Arrays.asList(Long.MAX_VALUE, Long.MIN_VALUE, 0L, 1L, -1L, null));
        } else if(type.equals(Double.TYPE)) {
            return new HashSet<>(Arrays.asList(Double.MAX_VALUE, Double.MIN_VALUE, 0D, 1D, -1D));
        } else if(type.equals(Double.class)) {
            return new HashSet<>(Arrays.asList(Double.MAX_VALUE, Double.MIN_VALUE, 0D, 1D, -1D, null));
        } else if(type.equals(Float.TYPE)) {
            return new HashSet<>(Arrays.asList(Float.MAX_VALUE, Float.MIN_VALUE, 0F, 1F, -1F));
        } else if(type.equals(Float.class)) {
            return new HashSet<>(Arrays.asList(Float.MAX_VALUE, Float.MIN_VALUE, 0F, 1F, -1F, null));
        } else if (type.equals(Boolean.TYPE)){
            return new HashSet<>(Arrays.asList(false,true));
        } else if (type.equals(Boolean.class)){
            return new HashSet<>(Arrays.asList(false,true, null));
        } else if(type.equals(String.class)) {
            return new HashSet<>(Arrays.asList(java.util.UUID.randomUUID().toString(), "", null));
        }

//        return createCornerCases(type);
        try {
            Set<?> cornerCasesForComplexType = createCornerCases(type);
            cornerCasesForComplexType.add(null);
            return cornerCasesForComplexType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }

    public <T>  T createAndFill(Class<T> clazz) throws Exception {
        T instance = clazz.newInstance();
        for(Field field: clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = getRandomValueForField(field);
            field.set(instance, value);
            field.setAccessible(false);
        }
        return instance;
    }

    private Object getRandomValueForField(Field field) throws Exception {
        Class<?> type = field.getType();

        // Note that we must handle the different types here! This is just an
        // example, so this list is not complete! Adapt this to your needs!
        if(type.isEnum()) {
            Object[] enumValues = type.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        } else if(type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return random.nextInt();
        } else if(type.equals(Long.TYPE) || type.equals(Long.class)) {
            return random.nextLong();
        } else if(type.equals(Double.TYPE) || type.equals(Double.class)) {
            return random.nextDouble();
        } else if(type.equals(Float.TYPE) || type.equals(Float.class)) {
            return random.nextFloat();
        } else if (type.equals(Boolean.TYPE) || type.equals(Boolean.class)){
            return random.nextBoolean();
        } else if(type.equals(String.class)) {
            return java.util.UUID.randomUUID().toString();
        } else if(type.equals(BigInteger.class)){
            return BigInteger.valueOf(random.nextInt());
        }
        return createAndFill(type);
    }
}
