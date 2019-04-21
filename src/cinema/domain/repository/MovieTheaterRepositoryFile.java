package cinema.domain.repository;

import cinema.domain.entity.MovieTheater;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MovieTheaterRepositoryFile implements MovieTheaterRepository{

    private List movieTheaters = new LinkedList<MovieTheater>();

    public MovieTheaterRepositoryFile(String movieTheatersFileName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(movieTheatersFileName);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            int counter = 1;
            String line = scanner.nextLine();
            String[] values = line.split(",");
            int[] freeSeats = new int[3];
            int ind = 0;
            while (Integer.parseInt(values[counter]) != -1)
                freeSeats[ind++] = Integer.parseInt(values[counter++]);
            counter++;
            int[] showsId = new int[3];
            ind = 0;
            while (Integer.parseInt(values[counter]) != -1)
                showsId[ind++] = Integer.parseInt(values[counter++]);
            counter++;
            movieTheaters.add(new MovieTheater(Integer.parseInt(values[0]), freeSeats, showsId, Integer.parseInt(values[counter])));
        }
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
