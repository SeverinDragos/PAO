package cinema;

import cinema.configuration.RepositoryConfig;
import cinema.domain.entity.Cinema;
import cinema.domain.entity.MovieTheater;
import cinema.domain.entity.Show;
import cinema.domain.repository.CinemaRepository;
import cinema.domain.repository.ShowRepository;
import cinema.services.CinemaService;
import cinema.services.ShowService;
import cinema.tool.JDBCInitializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Start{

    public static void main(String[] args) {
        JDBCInitializer.initializeDB();
//        CinemaService cinemaService = new CinemaService();
//        ShowService showService = new ShowService();
//        cinemaService.listAllCinemas();
//        cinemaService.listAvailableShows("iulius mall");
//        cinemaService.listAvailableMovies("iulius mall");
//        cinemaService.listAvailablePlays("afi coTROceni");
//        cinemaService.searchForMovie("tHe DePARted");
//        cinemaService.searchForPlay("gaitele");
//        showService.listMoviesWithGenre("action");
//        showService.listPlaysWithGenre("comedy");
//        showService.list3DMovies();
//        showService.list2DMovies()

    }
}