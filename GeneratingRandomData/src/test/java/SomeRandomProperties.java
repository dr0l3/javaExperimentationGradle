import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class SomeRandomProperties {

    @Property
    public void alwaysPositive(@From(RandomClassGenerator.class) RandomClass a, @From(RandomClassGenerator.class) RandomClass b) {
        assertTrue((a.getSomething() == null ? 0 : a.getSomething().length()) +
        (b.getSomething() == null ? 0 : b.getSomething().length()) > 1);
    }
}
