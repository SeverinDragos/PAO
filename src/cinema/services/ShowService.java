package cinema.services;

import cinema.configuration.RepositoryConfig;
import cinema.domain.entity.Movie;
import cinema.domain.entity.Play;
import cinema.domain.entity.Show;
import cinema.domain.repository.ShowRepository;

public class ShowService {
    ShowRepository showRepository = RepositoryConfig.getInstance().getShowRepository();

    public void listMoviesWithGenre(String genre) {
        Show[] shows = showRepository.getShows();
        boolean found = false;
        for (int i = 0; i < shows.length; i++) {
            if (shows[i] instanceof Movie && shows[i].getGenre().toLowerCase().equals(genre.toLowerCase())) {
                System.out.println(shows[i].toString());
                found = true;
            }
        }
        if(!found)
            System.out.println("Nu exista filme cu genul selectat");
    }

    public void listPlaysWithGenre(String genre) {
        Show[] shows = showRepository.getShows();
        boolean found = false;
        for (int i = 0; i < shows.length; i++) {
            if (shows[i] instanceof Play && shows[i].getGenre().toLowerCase().equals(genre.toLowerCase())) {
                System.out.println(shows[i].toString());
                found = true;
            }
        }
        if(!found)
            System.out.println("Nu exista piese de teatru cu genul selectat");
    }

    public void list2DMovies() {
        Show[] shows = showRepository.getShows();
        boolean found = false;
        for (int i = 0; i < shows.length; i++) {
            if (shows[i] instanceof Movie) {
                Movie temp = (Movie)shows[i];
                if (temp.getType().toLowerCase().equals("2d")) {
                    System.out.println(shows[i].toString());
                    found = true;
                }
            }
        }
        if(!found)
            System.out.println("Nu exista filme 2D");
    }

    public void list3DMovies() {
        Show[] shows = showRepository.getShows();
        boolean found = false;
        for (int i = 0; i < shows.length; i++) {
            if (shows[i] instanceof Movie) {
                Movie temp = (Movie)shows[i];
                if (temp.getType().toLowerCase().equals("3d")) {
                    System.out.println(shows[i].toString());
                    found = true;
                }
            }
        }
        if(!found)
            System.out.println("Nu exista filme 3D");
    }
}
