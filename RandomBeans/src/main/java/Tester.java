
import java.util.stream.Stream;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static io.github.benas.randombeans.api.EnhancedRandom.randomStreamOf;

public class Tester {
    public static void main(String[] args) {
        SomeRandomClass a = random(SomeRandomClass.class);
        System.out.println(a);
        Stream<SomeRandomClass> strea = randomStreamOf(10, SomeRandomClass.class);

        strea.forEach(System.out::println);
    }
}
