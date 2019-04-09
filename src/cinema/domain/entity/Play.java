package cinema.domain.entity;

public class Play extends Show {
    private String leadingActor;

    public Play() {}

    public Play(Play ob) {
        super(ob.genre, ob.name, ob.duration, ob.id);
        this.leadingActor = ob.leadingActor;
    }

    public Play(String genre, String name, int duration, String leadingActor, int id) {
        super(genre, name, duration, id);
        this.leadingActor = leadingActor;
    }

    public String getLeadingActor() {
        return leadingActor;
    }

    public void setLeadingActor(String leadingActor) {
        this.leadingActor = leadingActor;
    }


    @Override
    public String toString() {
        return "Play{" +
                "genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", leadingActor='" + leadingActor + '\'' +
                ", id=" + id +
                '}';
    }
}
