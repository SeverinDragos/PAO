package cinema.domain.repository;

import cinema.domain.entity.MovieTheater;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MovieTheaterRepositoryStatic implements MovieTheaterRepository{
    private List <MovieTheater> movieTheaters = new LinkedList<MovieTheater>();

    public MovieTheaterRepositoryStatic() {
        movieTheaters.add(new MovieTheater(250, new int[]{67, 93, 4}, new int[]{1, 2, 19}, 1));
        movieTheaters.add(new MovieTheater(180, new int[]{37, 102, 82}, new int[]{3, 20, 21}, 2));
        movieTheaters.add(new MovieTheater(210, new int[]{29, 38, 64}, new int[]{22, 4, 5}, 3));
        movieTheaters.add(new MovieTheater(160, new int[]{87, 29, 102}, new int[]{23, 24, 6}, 4));
        movieTheaters.add(new MovieTheater(220, new int[]{35, 60, 38}, new int[]{7, 8, 9}, 5));
        movieTheaters.add(new MovieTheater(130, new int[]{47, 62, 73}, new int[]{10, 25, 11}, 6));
        movieTheaters.add(new MovieTheater(175, new int[]{91, 6, 34}, new int[]{12, 13, 26}, 7));
        movieTheaters.add(new MovieTheater(140, new int[]{65, 90, 71}, new int[]{27, 14, 15}, 8));
        movieTheaters.add(new MovieTheater(200, new int[]{59, 63, 15}, new int[]{16, 17, 18}, 9));
    }

    public List getMovieTheaters() {
        return movieTheaters;
    }

    public MovieTheater getMovieTheaterById(int id) {
        Iterator<MovieTheater> it = movieTheaters.iterator();
        while (it.hasNext()) {
            MovieTheater movieTheater = it.next();
            if (movieTheater.getId() == id)
                return movieTheater;
        }
        return null;
    }
}
