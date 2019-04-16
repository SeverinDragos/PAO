package cinema.configuration;

import cinema.domain.repository.*;

import java.io.FileNotFoundException;

public class RepositoryConfig {
    private final CinemaRepository cinemaRepository = new CinemaRepository();
    private final MovieTheaterRepository movieTheaterRepository = new MovieTheaterRepository();
    private final ShowRepositoryFile showRepository = new ShowRepositoryFile("", "");
    private final TicketRepository ticketRepository = new TicketRepository();
    private static RepositoryConfig Instance = new RepositoryConfig();

    private RepositoryConfig() {}

    public CinemaRepository getCinemaRepository() {
        return cinemaRepository;
    }

    public MovieTheaterRepository getMovieTheaterRepository() {
        return movieTheaterRepository;
    }

    public ShowRepositoryFile getShowRepository() {
        return showRepository;
    }

    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public static RepositoryConfig getInstance() {
        return Instance;
    }

}
