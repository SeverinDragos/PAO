package cinema.domain.entity;

public class Adress {
    private String city;
    private String mall;

    public Adress() {}

    public Adress(String city, String mall) {
        this.city = city;
        this.mall = mall;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMall() {
        return mall;
    }

    public void setMall(String mall) {
        this.mall = mall;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "city='" + city + '\'' +
                ", mall='" + mall + '\'' +
                '}';
    }
}
