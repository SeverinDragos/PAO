package cinema.domain.entity;

import java.util.Arrays;

public class MovieTheater {
    private int capacity;
    private int[] freeSeats;
    private int[] showsId;
    private int id;

    public MovieTheater() {

    }

    public MovieTheater(MovieTheater ob) {
        this.capacity = ob.capacity;
        this.freeSeats = new int[ob.freeSeats.length];
        for (int i = 0; i < this.freeSeats.length; i++)
            this.freeSeats[i] = ob.freeSeats[i];
        this.showsId = new int[ob.showsId.length];
        for (int i = 0; i < this.showsId.length; i++)
            this.showsId[i] = ob.showsId[i];
        this.id = ob.id;
    }

    public MovieTheater(int capacity, int[] freeSeats, int[] showsId, int id) {
        this.capacity = capacity;
        this.freeSeats = new int[freeSeats.length];
        for (int i = 0; i < this.freeSeats.length; i++)
            this.freeSeats[i] = freeSeats[i];
        this.showsId = new int[showsId.length];
        for (int i = 0; i < this.showsId.length; i++)
            this.showsId[i] = showsId[i];
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int[] getFreeSeats() {
        int[] ret = new int[freeSeats.length];
        for (int i = 0; i < ret.length; i++)
            ret[i] = freeSeats[i];
        return ret;
    }

    public void setFreeSeats(int[] freeSeats) {
        this.freeSeats = new int[freeSeats.length];
        for (int i = 0; i < this.freeSeats.length; i++)
            this.freeSeats[i] = freeSeats[i];
    }

    public int[] getShowsId() {
        int[] ret = new int[showsId.length];
        for (int i = 0; i < ret.length; i++)
            ret[i] = showsId[i];
        return ret;
    }

    public void setShowsId(int[] showsId) {
        this.showsId = new int[showsId.length];
        for (int i = 0; i < this.showsId.length; i++)
            this.showsId[i] = showsId[i];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieTheater{" +
                "capacity=" + capacity +
                ", freeSeats=" + Arrays.toString(freeSeats) +
                ", showsId=" + Arrays.toString(showsId) +
                ", id=" + id +
                '}';
    }
}
