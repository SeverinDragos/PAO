package cinema.domain.repository;

import cinema.domain.entity.Movie;
import cinema.domain.entity.Play;
import cinema.domain.entity.Show;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ShowRepositoryStatic implements ShowRepository{
    private Set<Show> shows = new TreeSet<>();

    public ShowRepositoryStatic() {
        shows.add(new Movie("action", "Fast and Furious", 103, "3D", 1));
        shows.add(new Movie("drama", "Before I met you", 89, "2D", 2));
        shows.add(new Movie("kids", "Frozen", 109, "3D", 3));
        shows.add(new Movie("comedy", "Deadpool", 113, "3D", 4));
        shows.add(new Movie("action", "Aquaman", 136, "3D", 5));
        shows.add(new Play("comedy", "Take, Ianke si Cadir", 150, "Florin Piersic", 19));
        shows.add(new Play("comedy", "O scrisoare pierduta", 153, "Horatiu Malaiele", 20));
        shows.add(new Play("drama", "Hamlet", 169, "Horia Căciulescu", 21));
        shows.add(new Play("comedy", "Dineu cu prosti", 143, "Ion Haiduc", 22));

        shows.add(new Movie("romantic", "Set it up", 105, "2D", 6));
        shows.add(new Movie("romantic", "Jumping the Broom", 112, "2D", 7));
        shows.add(new Movie("kids", "The Polar Express", 99, "3D", 8));
        shows.add(new Movie("kids", "Puss in Boots", 92, "3D", 9));
        shows.add(new Movie("comedy", "Fist Fight", 91, "2D", 10));
        shows.add(new Movie("action", "How it Ends", 113, "2D", 11));
        shows.add(new Play("comedy", "Gaitele", 150, "Geo Dobre", 23));
        shows.add(new Play("comedy", "O noapte furtunoasa", 127, "Grigore Manolescu", 24));
        shows.add(new Play("comedy", "Visul unei nopti de iarna", 127, "Dorel Visan", 25));

        shows.add(new Movie("action", "Run All Night", 114, "3D", 12));
        shows.add(new Movie("kids", "Madagascar", 87, "3D", 13));
        shows.add(new Movie("comedy", "Get Smart", 109, "2D", 14));
        shows.add(new Movie("drama", "Dunkirk", 106, "2D",15));
        shows.add(new Movie("kids", "Megamind", 97, "3D", 16));
        shows.add(new Movie("action", "The Revenant", 156, "3D", 17));
        shows.add(new Movie("drama", "The Departed", 151, "2D", 18));
        shows.add(new Play("romantic", "Steaua fara nume", 148, "Catalina Murgea", 26));
        shows.add(new Play("drama", "Cantareata Cheala", 126, "Claudiu Istodor", 27));
    }

    public Set<Show> getShows() {
        return shows;
    }

    public Show getShowById(int id) {
        Iterator<Show> it = shows.iterator();
        while(it.hasNext()) {
            Show temp = it.next();
            if (temp.getId() == id)
                return temp;
        }
        return null;
    }
}
