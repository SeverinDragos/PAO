package cinema;

import cinema.configuration.RepositoryConfig;
import cinema.domain.entity.Cinema;
import cinema.domain.entity.MovieTheater;
import cinema.domain.entity.Show;
import cinema.domain.repository.CinemaRepository;
import cinema.domain.repository.MovieTheaterRepository;
import cinema.domain.repository.ShowRepository;
import cinema.services.CinemaService;
import cinema.services.ShowService;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        CinemaService cinemaService = new CinemaService();
        ShowService showService = new ShowService();
//        cinemaService.listAllCinemas();
//        cinemaService.listAvailableShows("iulius mall");
//        cinemaService.listAvailableMovies("iulius mall");
//        cinemaService.listAvailablePlays("afi coTROceni");
//        cinemaService.searchForMovie("tHe DePARted");
//        cinemaService.searchForPlay("gaitele");
//        showService.listMoviesWithGenre("drama");
//        showService.listPlaysWithGenre("comedy");
//        showService.list3DMovies();
//        showService.list2DMovies();

//        MovieTheaterRepository movieTheaterRepositoryStatic = RepositoryConfig.getInstance().getMovieTheaterRepository();
//        MovieTheater movieTheater = movieTheaterRepositoryStatic.getMovieTheaterById(8);
//        System.out.println(movieTheater.toString());
//
//        ShowRepository showRepository = RepositoryConfig.getInstance().getShowRepository();
//        Show show = showRepository.getShowById(6);
//        System.out.println(show.toString());

//        CinemaRepository cinemaRepository = RepositoryConfig.getInstance().getCinemaRepository();
//        List<Cinema> cinemas = cinemaRepository.getCinemas();
//        Iterator<Cinema> it = cinemas.iterator();
//        while (it.hasNext()) {
//            Cinema outputCinema = it.next();
//            System.out.println(outputCinema.toString());
//        }
    }
}