public class SubObject {
    private int age;
    private String Id;
    private SubSubObject subsub;

    @Override
    public String toString() {
        return "SubObject{" +
                "age=" + age +
                ", Id='" + Id + '\'' +
                ", subsub=" + subsub +
                '}';
    }
}
