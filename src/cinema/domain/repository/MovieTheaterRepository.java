package cinema.domain.repository;

import cinema.domain.entity.MovieTheater;

public class MovieTheaterRepository {
    MovieTheater[] movieTheaters = new MovieTheater[] {
            new MovieTheater(250, new int[]{67, 93, 4}, new int[]{1, 2, 19}, 1),
            new MovieTheater(180, new int[]{37, 102, 82}, new int[]{3, 20, 21}, 2),
            new MovieTheater(210, new int[]{29, 38, 64}, new int[]{22, 4, 5}, 3),

            new MovieTheater(160, new int[]{87, 29, 102}, new int[]{23, 24, 6}, 4),
            new MovieTheater(220, new int[]{35, 60, 38}, new int[]{7, 8, 9}, 5),
            new MovieTheater(130, new int[]{47, 62, 73}, new int[]{10, 25, 11}, 6),

            new MovieTheater(175, new int[]{91, 6, 34}, new int[]{12, 13, 26}, 7),
            new MovieTheater(140, new int[]{65, 90, 71}, new int[]{27, 14, 15}, 8),
            new MovieTheater(200, new int[]{59, 63, 15}, new int[]{16, 17, 18}, 9)
    };

    public MovieTheater[] getMovieTheaters() {
        return movieTheaters;
    }

    public MovieTheater getMovieTheaterById(int id) {
        for (int i = 0; i < movieTheaters.length; i++)
            if (movieTheaters[i].getId() == id)
                return movieTheaters[i];
        return null;
    }
}
