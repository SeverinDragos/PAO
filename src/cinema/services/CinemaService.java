package cinema.services;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import cinema.configuration.RepositoryConfig;
import cinema.domain.entity.*;
import cinema.domain.repository.CinemaRepository;
import cinema.domain.repository.MovieTheaterRepository;
import cinema.domain.repository.ShowRepository;

public class CinemaService {
    private CinemaRepository cinemaRepository = RepositoryConfig.getInstance().getCinemaRepository();
    private MovieTheaterRepository movieTheaterRepository = RepositoryConfig.getInstance().getMovieTheaterRepository();
    private ShowRepository showRepository = RepositoryConfig.getInstance().getShowRepository();

    public void listAllCinemas() {
        Cinema[] cinemas = cinemaRepository.getCinemas();
        for (int i = 0; i < cinemas.length; i++)
            System.out.println(cinemas[i].getAdress().getCity() + " " + cinemas[i].getAdress().getMall());
    }

    private Iterator<Show> getShowsOfCinema(Cinema cinema) {
        LinkedList<Show> showLinkedList = new LinkedList<Show>();
        int[] movieTheatersId = cinema.getMovieTheatersId();
        for (int i = 0; i < movieTheatersId.length; i++) {
            MovieTheater movieTheater = movieTheaterRepository.getMovieTheaterById(movieTheatersId[i]);
            if (movieTheater == null) {
                System.out.println("Sample data incorrect");
                return null;
            }
            int[] showsId = movieTheater.getShowsId();
            for (int mti = 0; mti < showsId.length; mti++) {
                Show show = showRepository.getShowById(showsId[mti]);
                if (show == null) {
                    System.out.println("Sample data incorrect: " + movieTheater.getId() + " " + showsId[mti]);
                    return null;
                }
                else
                    showLinkedList.add(show);
            }
        }
        return showLinkedList.iterator();
    }

    public void listAvailableShows(String mall) {
        Cinema cinema = cinemaRepository.getCinemaByMall(mall);
        if (cinema == null) {
            System.out.println("Acest mall nu exista");
            return;
        }
        boolean showsExist = false;
        Iterator<Show> showIterator = getShowsOfCinema(cinema);
        if (showIterator == null)
            return;
        while(showIterator.hasNext()) {
            System.out.println(showIterator.next().toString());
            showsExist = true;
        }
        if (showsExist == false)
            System.out.println("Acest mall nu are show-uri");
    }

    public void listAvailableMovies(String mall) {
        Cinema cinema = cinemaRepository.getCinemaByMall(mall);
        if (cinema == null) {
            System.out.println("Acest mall nu exista");
            return;
        }
        boolean moviesExist = false;
        Iterator<Show> showIterator = getShowsOfCinema(cinema);
        if (showIterator == null)
            return;
        while(showIterator.hasNext()) {
            Show show = showIterator.next();
            if (show instanceof Movie) {
                System.out.println(show.toString());
                moviesExist = true;
            }
        }
        if (moviesExist == false)
            System.out.println("Acest mall nu are filme");
    }

    public void listAvailablePlays(String mall) {
        Cinema cinema = cinemaRepository.getCinemaByMall(mall);
        if (cinema == null) {
            System.out.println("Acest mall nu exista");
            return;
        }
        boolean playsExist = false;
        Iterator<Show> showIterator = getShowsOfCinema(cinema);
        if (showIterator == null)
            return;
        while(showIterator.hasNext()) {
            Show show = showIterator.next();
            if (show instanceof Play) {
                System.out.println(show.toString());
                playsExist = true;
            }
        }
        if (playsExist == false)
            System.out.println("Acest mall nu are piese de teatru");
    }

    public void searchForMovie(String name) {
        Cinema[] cinemas = cinemaRepository.getCinemas();
        boolean found = false;
        for (int i = 0; i < cinemas.length; i++) {
            Iterator<Show> showIterator = getShowsOfCinema(cinemas[i]);
            if (showIterator == null)
                return;
            while (showIterator.hasNext()) {
                Show show = showIterator.next();
                if (show instanceof Movie && show.getName().toLowerCase().equals(name.toLowerCase())) {
                    System.out.println(cinemas[i].getAdress().getCity() + " " + cinemas[i].getAdress().getMall());
                    found = true;
                    break;
                }
            }
        }
        if (!found)
            System.out.println("Filmul selectat nu se afla la niciunul dintre mall-uri");
    }

    public void searchForPlay(String name) {
        Cinema[] cinemas = cinemaRepository.getCinemas();
        boolean found = false;
        for (int i = 0; i < cinemas.length; i++) {
            Iterator<Show> showIterator = getShowsOfCinema(cinemas[i]);
            if (showIterator == null)
                return;
            while (showIterator.hasNext()) {
                Show show = showIterator.next();
                if (show instanceof Play && show.getName().toLowerCase().equals(name.toLowerCase())) {
                    System.out.println(cinemas[i].getAdress().getCity() + " " + cinemas[i].getAdress().getMall());
                    found = true;
                    break;
                }
            }
        }
        if (!found)
            System.out.println("Piesa de teatru selectata nu se afla la niciunul dintre mall-uri");
    }
}
