package cinema.domain.repository;

import cinema.domain.entity.Adress;
import cinema.domain.entity.Cinema;
import cinema.domain.entity.MovieTheater;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CinemaRepositoryFile implements CinemaRepository{
    List<Cinema> cinemas = new ArrayList<>();

    public CinemaRepositoryFile(String cinemaFileName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(cinemaFileName);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            int counter = 0;
            String line = scanner.nextLine();
            String[] values = line.split(",");
            int[] movieTheatersId = new int[3];
            int ind = 0;
            while (Integer.parseInt(values[counter]) != -1)
                movieTheatersId[ind++] = Integer.parseInt(values[counter++]);
            counter++;
            cinemas.add(new Cinema(movieTheatersId, new Adress(values[counter], values[counter + 1]), Integer.parseInt(values[counter+ 2])));
        }
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
