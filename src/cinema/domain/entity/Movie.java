package cinema.domain.entity;

public class Movie extends Show {
    private String type;

    public Movie() {}

    public Movie(Movie ob) {
        super(ob.genre, ob.name, ob.duration, ob.id);
        this.type = ob.type;
    }

    public Movie(String genre, String name, int duration, String type, int id) {
        super(genre, name, duration, id);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}
