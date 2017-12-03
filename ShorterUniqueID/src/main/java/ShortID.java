import org.apache.commons.lang3.RandomStringUtils;

public class ShortID {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            System.out.println(RandomStringUtils.randomAlphanumeric(8));
        }
    }
}
