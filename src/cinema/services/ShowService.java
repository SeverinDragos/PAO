package cinema.services;

import cinema.configuration.RepositoryConfig;
import cinema.domain.entity.Movie;
import cinema.domain.entity.Play;
import cinema.domain.entity.Show;
import cinema.domain.repository.ShowRepository;
import cinema.domain.repository.ShowRepositoryStatic;
import cinema.tool.CsvWriter;

import java.util.Iterator;
import java.util.Set;

public class ShowService {
    private ShowRepository showRepository = RepositoryConfig.getInstance().getShowRepository();

    public void listMoviesWithGenre(String genre) {
        CsvWriter.getInstance().write("listMoviesWithGenre , ");
        Iterator<Show> it = showRepository.getShows().iterator();
        boolean found = false;
        while (it.hasNext()) {
            Show show = it.next();
            if (show instanceof Movie && show.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                System.out.println(show.toString());
                found = true;
            }
        }
        if(!found)
            System.out.println("Nu exista filme cu genul selectat");
    }

    public void listPlaysWithGenre(String genre) {
        CsvWriter.getInstance().write("listPlaysWithGenre , ");
        Iterator<Show> it = showRepository.getShows().iterator();
        boolean found = false;
        while (it.hasNext()) {
            Show show = it.next();
            if (show instanceof Play && show.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                System.out.println(show.toString());
                found = true;
            }
        }
        if(!found)
            System.out.println("Nu exista piese de teatru cu genul selectat");
    }

    public void list2DMovies() {
        CsvWriter.getInstance().write("list2DMovies , ");
        Iterator<Show> it = showRepository.getShows().iterator();
        boolean found = false;
        while (it.hasNext()) {
            Show show = it.next();
            if (show instanceof Movie) {
                if (((Movie) show).getType().toLowerCase().equals("2d")) {
                    System.out.println(show.toString());
                    found = true;
                }
            }
        }
        if(!found)
            System.out.println("Nu exista filme 2D");
    }

    public void list3DMovies() {
        CsvWriter.getInstance().write("list3DMovies , ");
        Iterator<Show> it = showRepository.getShows().iterator();
        boolean found = false;
        while (it.hasNext()) {
            Show show = it.next();
            if (show instanceof Movie) {
                if (((Movie) show).getType().toLowerCase().equals("3d")) {
                    System.out.println(show.toString());
                    found = true;
                }
            }
        }
        if(!found)
            System.out.println("Nu exista filme 3D");
    }
}
