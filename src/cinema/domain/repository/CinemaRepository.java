package cinema.domain.repository;

import cinema.domain.entity.Adress;
import cinema.domain.entity.Cinema;

public class CinemaRepository {
    private Cinema[] cinemas = new Cinema[] {
            new Cinema(new int[] {1, 2, 3}, new Adress("Iasi", "Iulius mall")),
            new Cinema(new int[] {4, 5, 6}, new Adress("Bucuresti", "AFI Cotroceni")),
            new Cinema(new int[] {7, 8, 9}, new Adress("Constanta", "Vivo"))
    };

    public Cinema[] getCinemas() {
        return cinemas;
    }

    public Cinema getCinemaByMall(String mall) {
        for (int i = 0; i < cinemas.length; i++)
            if (cinemas[i].getAdress().getMall().toLowerCase().equals(mall.toLowerCase()))
                return cinemas[i];
        return null;
    }
}
