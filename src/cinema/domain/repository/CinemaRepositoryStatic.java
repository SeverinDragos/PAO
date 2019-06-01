package cinema.domain.repository;

import cinema.domain.entity.Adress;
import cinema.domain.entity.Cinema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CinemaRepositoryStatic implements CinemaRepository{
    private List<Cinema> cinemas = new ArrayList<>();

    public CinemaRepositoryStatic() {
        cinemas.add(new Cinema(new int[] {1, 2, 3}, new Adress("Iasi", "Iulius mall"),1));
        cinemas.add(new Cinema(new int[] {4, 5, 6}, new Adress("Bucuresti", "AFI Cotroceni"),2));
        cinemas.add(new Cinema(new int[] {7, 8, 9}, new Adress("Constanta", "Vivo"),3));
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public Cinema getCinemaByMall(String mall) {
        Iterator<Cinema> it = cinemas.iterator();
        while(it.hasNext()) {
            Cinema cinema = it.next();
            if (cinema.getAdress().getMall().toLowerCase().equals(mall.toLowerCase()))
                return cinema;
        }
        return null;
    }
}
