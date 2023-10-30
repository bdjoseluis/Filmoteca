package jose.luis.filmotecajoseluisbotella;

import java.util.ArrayList;

public class FilmDataSource {
    public static ArrayList<Film> films;
    public static void Initialize() {
        films = new ArrayList<Film>();

        Film f = new Film();
        f.setTitle("Interstellar");
        f.setDirector("Christopher Nolan");
        f.setImageResId(R.drawable.interestelar);
        f.setComments("A team of explorers travel throught a wormhole in space in an attempt to ensure humanity’s survival");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0816692");
        f.setYear(1984);
        films.add(f);

        f = new Film();
        f.setTitle("Back to the future");
        f.setDirector("Robert Zemeckis");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Marty McFly, is sent 30 years into the past in a time-travelling DeLorean.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0088763");
        f.setYear(1985);
        films.add(f);
    }
    }
