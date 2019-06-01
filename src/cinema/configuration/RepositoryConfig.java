package cinema.configuration;

import cinema.domain.repository.*;

import java.io.FileNotFoundException;

public class RepositoryConfig {
    private CinemaRepository cinemaRepository = null;
    private MovieTheaterRepository movieTheaterRepository = null;
    private ShowRepository showRepository = new ShowRepositoryDB();
    private final TicketRepository ticketRepository = new TicketRepository();
    private static RepositoryConfig Instance = new RepositoryConfig();

    private RepositoryConfig() {
        try {
//            showRepository = new ShowRepositoryFile("MovieFile.csv", "PlayFile.csv");
            movieTheaterRepository = new MovieTheaterRepositoryFile("MovieTheaterFile.csv");
            cinemaRepository = new CinemaRepositoryFile("CinemaFile.csv");
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect file path!");
        }
    }

    public CinemaRepository getCinemaRepository() {
        return cinemaRepository;
    }

    public MovieTheaterRepository getMovieTheaterRepository() {
        return movieTheaterRepository;
    }

    public ShowRepository getShowRepository() {
        return showRepository;
    }

    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public static RepositoryConfig getInstance() {
        return Instance;
    }

}
