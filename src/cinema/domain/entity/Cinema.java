package cinema.domain.entity;


public class Cinema {
    private int[] movieTheatersId;
    private Adress adress;

    public Cinema() {}

    public Cinema(Cinema ob) {
        this.movieTheatersId = new int[ob.movieTheatersId.length];
        for (int i = 0; i < this.movieTheatersId.length; i++)
            this.movieTheatersId[i] = ob.movieTheatersId[i];
        this.adress = ob.adress;
    }

    public Cinema(int[] movieTheatersId, Adress adress) {
        this.movieTheatersId = new int[movieTheatersId.length];
        for (int i = 0; i < this.movieTheatersId.length; i++)
            this.movieTheatersId[i] = movieTheatersId[i];
        this.adress = adress;
    }

    public int[] getMovieTheatersId() {
        int[] ret = new int[movieTheatersId.length];
        for (int i = 0; i < ret.length; i++)
            ret[i] = movieTheatersId[i];
        return ret;
    }

    public void setMovieTheatersId(int[] movieTheatersId) {
        this.movieTheatersId = new int[movieTheatersId.length];
        for (int i = 0; i < this.movieTheatersId.length; i++)
            this.movieTheatersId[i] = movieTheatersId[i];
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

}
