package cinema.domain.entity;

public abstract class Show implements Comparable<Show>{
    protected String genre;
    protected String name;
    protected int duration;
    protected int id;

    public Show() {

    }

    public Show(Show ob) {
        this.genre = ob.genre;
        this.name = ob.name;
        this.duration = ob.duration;
        this.id = ob.id;
    }

    public Show(String genre, String name, int duration, int id) {
        this.genre = genre;
        this.name = name;
        this.duration = duration;
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Show{" +
                "genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", id=" + id +
                '}';
    }

    public int compareTo(Show ob) {
        return this.id - ob.id;
    }
}
