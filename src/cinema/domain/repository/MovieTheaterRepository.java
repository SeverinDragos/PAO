package cinema.domain.repository;

import cinema.domain.entity.MovieTheater;

import java.util.List;

public interface MovieTheaterRepository {
    public List getMovieTheaters();

    public MovieTheater getMovieTheaterById(int id);
}
