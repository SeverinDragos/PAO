package cinema.domain.repository;

import cinema.domain.entity.Show;

public interface ShowRepository {
    public Show[] getShows();

    public Show getShowById(int id);
}
