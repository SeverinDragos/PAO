package cinema.domain.repository;

import cinema.domain.entity.Cinema;

import java.util.List;

public interface CinemaRepository {
    public List<Cinema> getCinemas();

    public Cinema getCinemaByMall(String mall);
}
