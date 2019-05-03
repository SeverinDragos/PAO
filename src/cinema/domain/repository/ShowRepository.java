package cinema.domain.repository;

import cinema.domain.entity.Show;

import java.util.Set;

public interface ShowRepository {
    public Set<Show> getShows();

    public Show getShowById(int id);
}
