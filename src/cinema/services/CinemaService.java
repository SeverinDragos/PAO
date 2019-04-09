package cinema.services;

import cinema.configuration.RepositoryConfig;
import cinema.domain.entity.*;
import cinema.domain.repository.CinemaRepository;
import cinema.domain.repository.MovieTheaterRepository;
import cinema.domain.repository.ShowRepository;

public class CinemaService {
    CinemaRepository cinemaRepository = RepositoryConfig.getInstance().getCinemaRepository();
    MovieTheaterRepository movieTheaterRepository = RepositoryConfig.getInstance().getMovieTheaterRepository();
    ShowRepository showRepository = RepositoryConfig.getInstance().getShowRepository();

    public void listAllCinemas() {
        Cinema[] cinemas = cinemaRepository.getCinemas();
        for (int i = 0; i < cinemas.length; i++)
            System.out.println(cinemas[i].getAdress().getCity() + " " + cinemas[i].getAdress().getMall());
    }

    public void listAvailableShows(String mall) {
        Cinema cinema = cinemaRepository.getCinemaByMall(mall);
        if (cinema == null) {
            System.out.println("Acest mall nu exista");
            return;
        }

        int[] movieTheatersId = cinema.getMovieTheatersId();
        for (int i = 0; i < movieTheatersId.length; i++) {
            MovieTheater movieTheater = movieTheaterRepository.getMovieTheaterById(movieTheatersId[i]);
            if (movieTheater == null) {
                System.out.println("Sample data incorrect");
                return;
            }
            int[] showsId = movieTheater.getShowsId();
            for (int mti = 0; mti < showsId.length; mti++) {
                Show show = showRepository.getShowById(showsId[mti]);
                if (show == null) {
                    System.out.println("Sample data incorrect: " + movieTheater.getId() + " " + showsId[mti]);
                    return;
                }
                else
                System.out.println(show.toString());
            }
        }

    }

    public void listAvailableMovies(String mall) {
        Cinema cinema = cinemaRepository.getCinemaByMall(mall);
        if (cinema == null) {
            System.out.println("Acest mall nu exista");
            return;
        }

        int[] movieTheatersId = cinema.getMovieTheatersId();
        for (int i = 0; i < movieTheatersId.length; i++) {
            MovieTheater movieTheater = movieTheaterRepository.getMovieTheaterById(movieTheatersId[i]);
            if (movieTheater == null) {
                System.out.println("Sample data incorrect");
                return;
            }
            int[] showsId = movieTheater.getShowsId();
            for (int mti = 0; mti < showsId.length; mti++) {
                Show show = showRepository.getShowById(showsId[mti]);
                if (show == null) {
                    System.out.println("Sample data incorrect: " + movieTheater.getId() + " " + showsId[mti]);
                    return;
                }
                else
                    if (show instanceof Movie)
                    System.out.println(show.toString());
            }
        }

    }

    public void listAvailablePlays(String mall) {
        Cinema cinema = cinemaRepository.getCinemaByMall(mall);
        if (cinema == null) {
            System.out.println("Acest mall nu exista");
            return;
        }

        int[] movieTheatersId = cinema.getMovieTheatersId();
        for (int i = 0; i < movieTheatersId.length; i++) {
            MovieTheater movieTheater = movieTheaterRepository.getMovieTheaterById(movieTheatersId[i]);
            if (movieTheater == null) {
                System.out.println("Sample data incorrect");
                return;
            }
            int[] showsId = movieTheater.getShowsId();
            for (int mti = 0; mti < showsId.length; mti++) {
                Show show = showRepository.getShowById(showsId[mti]);
                if (show == null) {
                    System.out.println("Sample data incorrect: " + movieTheater.getId() + " " + showsId[mti]);
                    return;
                }
                else
                if (show instanceof Play)
                    System.out.println(show.toString());
            }
        }

    }

    public void searchForMovie(String name) {
        Cinema[] cinemas = cinemaRepository.getCinemas();
        boolean found = false;
        forloop:
        for (int it = 0; it < cinemas.length; it++) {
            int[] movieTheatersId = cinemas[it].getMovieTheatersId();
            for (int i = 0; i < movieTheatersId.length; i++) {
                MovieTheater movieTheater = movieTheaterRepository.getMovieTheaterById(movieTheatersId[i]);
                if (movieTheater == null) {
                    System.out.println("Sample data incorrect");
                    return;
                }
                int[] showsId = movieTheater.getShowsId();
                for (int mti = 0; mti < showsId.length; mti++) {
                    Show show = showRepository.getShowById(showsId[mti]);
                    if (show == null) {
                        System.out.println("Sample data incorrect: " + movieTheater.getId() + " " + showsId[mti]);
                        return;
                    } else if (show instanceof Movie && show.getName().toLowerCase().equals(name.toLowerCase())) {
                        System.out.println(cinemas[it].getAdress().getCity() + " " + cinemas[it].getAdress().getMall());
                        found = true;
                        break forloop;
                    }
                }
            }
        }
        if (!found)
            System.out.println("Filmul selectat nu se afla la niciunul dintre mall-uri");

    }

    public void searchForPlay(String name) {
        Cinema[] cinemas = cinemaRepository.getCinemas();
        boolean found = false;
        forloop:
        for (int it = 0; it < cinemas.length; it++) {
            int[] movieTheatersId = cinemas[it].getMovieTheatersId();
            for (int i = 0; i < movieTheatersId.length; i++) {
                MovieTheater movieTheater = movieTheaterRepository.getMovieTheaterById(movieTheatersId[i]);
                if (movieTheater == null) {
                    System.out.println("Sample data incorrect");
                    return;
                }
                int[] showsId = movieTheater.getShowsId();
                for (int mti = 0; mti < showsId.length; mti++) {
                    Show show = showRepository.getShowById(showsId[mti]);
                    if (show == null) {
                        System.out.println("Sample data incorrect: " + movieTheater.getId() + " " + showsId[mti]);
                        return;
                    } else if (show instanceof Play && show.getName().toLowerCase().equals(name.toLowerCase())) {
                        System.out.println(cinemas[it].getAdress().getCity() + " " + cinemas[it].getAdress().getMall());
                        found = true;
                        break forloop;
                    }
                }
            }
        }
        if (!found)
            System.out.println("Piesa de teatru selectata nu se afla la niciunul dintre mall-uri");

    }

}
