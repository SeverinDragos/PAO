package cinema.domain.repository;

import cinema.domain.entity.Movie;
import cinema.domain.entity.Play;
import cinema.domain.entity.Show;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ShowRepositoryFile implements ShowRepository{
    private Set<Show> shows = new TreeSet<>();

    public ShowRepositoryFile(String movieFileName, String playFileName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(movieFileName);
        Scanner scanner = new Scanner(fileInputStream);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            shows.add(new Movie(values[0], values[1], Integer.parseInt(values[2]), values[3],Integer.parseInt(values[4])));
        }

        FileInputStream fileInputStream2 = new FileInputStream(playFileName);
        Scanner scanner2 = new Scanner(fileInputStream2);
        while (scanner2.hasNext()) {
            String line = scanner2.nextLine();
            String[] values = line.split(",");
            shows.add(new Play(values[0], values[1], Integer.parseInt(values[2]), values[3], Integer.parseInt(values[4])));
        }
    }

    public Set<Show> getShows() {
        return shows;
    }

    public Show getShowById(int id) {
        Iterator<Show> it = shows.iterator();
        while(it.hasNext()) {
            Show temp = it.next();
            if (temp.getId() == id)
                return temp;
        }
        return null;
    }
}
