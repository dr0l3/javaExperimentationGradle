public class Pojo {
    private String hello;
    private Integer number;

    public Pojo() {
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojo pojo = (Pojo) o;

        if (hello != null ? !hello.equals(pojo.hello) : pojo.hello != null) return false;
        return number != null ? number.equals(pojo.number) : pojo.number == null;
    }

    @Override
    public int hashCode() {
        int result = hello != null ? hello.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "hello='" + hello + '\'' +
                ", number=" + number +
                '}';
    }
}
