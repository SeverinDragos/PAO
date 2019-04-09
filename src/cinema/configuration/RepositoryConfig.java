package cinema.configuration;

import cinema.domain.repository.CinemaRepository;
import cinema.domain.repository.MovieTheaterRepository;
import cinema.domain.repository.ShowRepository;
import cinema.domain.repository.TicketRepository;

public class RepositoryConfig {
    private final CinemaRepository cinemaRepository = new CinemaRepository();
    private final MovieTheaterRepository movieTheaterRepository = new MovieTheaterRepository();
    private final ShowRepository showRepository = new ShowRepository();
    private final TicketRepository ticketRepository = new TicketRepository();
    private static RepositoryConfig Instance = new RepositoryConfig();

    private RepositoryConfig() {}

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
