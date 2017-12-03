public class RandomClass {
    private boolean yes;
    private String something;
    private SubObject sub;

    public boolean isYes() {
        return yes;
    }

    public String getSomething() {
        return something;
    }

    public SubObject getSub() {
        return sub;
    }

    @Override
    public String toString() {
        return "RandomClass{" +
                "yes=" + yes +
                ", something='" + something + '\'' +
                ", sub=" + sub +
                '}';
    }
}
