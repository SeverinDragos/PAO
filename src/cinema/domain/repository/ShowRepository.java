package cinema.domain.repository;

import cinema.domain.entity.Movie;
import cinema.domain.entity.Play;
import cinema.domain.entity.Show;

public class ShowRepository {
    Show[] shows = new Show[] {
            new Movie("action", "Fast and Furious", 103, "3D", 1),
            new Movie("drama", "Before I met you", 89, "2D", 2),
            new Movie("kids", "Frozen", 109, "3D", 3),
            new Movie("comedy", "Deadpool", 113, "3D", 4),
            new Movie("action", "Aquaman", 136, "3D", 5),
            new Play("comedy", "Take, Ianke si Cadir", 150, "Florin Piersic", 19),
            new Play("comedy", "O scrisoare pierduta", 153, "Horatiu Malaiele", 20),
            new Play("drama", "Hamlet", 169, "Horia Căciulescu", 21),
            new Play("comedy", "Dineu cu prosti", 143, "Ion Haiduc", 22),

            new Movie("romantic", "Set it up", 105, "2D", 6),
            new Movie("romantic", "Jumping the Broom", 112, "2D", 7),
            new Movie("kids", "The Polar Express", 99, "3D", 8),
            new Movie("kids", "Puss in Boots", 92, "3D", 9),
            new Movie("comedy", "Fist Fight", 91, "2D", 10),
            new Movie("action", "How it Ends", 113, "2D", 11),
            new Play("comedy", "Gaitele", 150, "Geo Dobre", 23),
            new Play("comedy", "O noapte furtunoasa", 127, "Grigore Manolescu", 24),
            new Play("comedy", "Visul unei nopti de iarna", 127, "Dorel Visan", 25),

            new Movie("action", "Run All Night", 114, "3D", 12),
            new Movie("kids", "Madagascar", 87, "3D", 13),
            new Movie("comedy", "Get Smart", 109, "2D", 14),
            new Movie("drama", "Dunkirk", 106, "2D",15),
            new Movie("kids", "Megamind", 97, "3D", 16),
            new Movie("action", "The Revenant", 156, "3D", 17),
            new Movie("drama", "The Departed", 151, "2D", 18),
            new Play("romantic", "Steaua fara nume", 148, "Catalina Murgea", 26),
            new Play("drama", "Cantareata Cheala", 126, "Claudiu Istodor", 27)
    };

    public Show[] getShows() {
        return shows;
    }

    public Show getShowById(int id) {
        for (int i = 0; i < shows.length; i++)
            if (shows[i].getId() == id)
                return shows[i];
        return null;
    }
}
