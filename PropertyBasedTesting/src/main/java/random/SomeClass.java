package random;

public class SomeClass {
    private int age;
    private String firstName;
    private String secondName;

    public SomeClass(int age, String firstName, String secondName) {
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public SomeClass() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
