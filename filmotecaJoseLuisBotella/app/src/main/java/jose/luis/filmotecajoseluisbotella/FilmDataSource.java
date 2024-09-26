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
        f.setTitle("Regreso al futuro");
        f.setDirector("Robert Zemeckis");
        f.setImageResId(R.drawable.regreso);
        f.setComments("Marty McFly, is sent 30 years into the past in a time-travelling DeLorean.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0088763");
        f.setYear(1985);
        films.add(f);

        f = new Film();
        f.setTitle("Piratas del Caribe");
        f.setDirector("Gore Verbinski");
        f.setImageResId(R.drawable.piratas);
        f.setComments("Las aventuras del Capitán Jack Sparrow en busca de un tesoro legendario.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_ACTION);
        f.setImdbUrl("http://www.imdb.com/title/tt0325980");
        f.setYear(2003);
        films.add(f);

        f = new Film();
        f.setTitle("Toy Story");
        f.setDirector("John Lasseter");
        f.setImageResId(R.drawable.toy);
        f.setComments("La primera película animada de Pixar sobre los juguetes que cobran vida cuando los humanos no están mirando.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0114709");
        f.setYear(1995);
        films.add(f);

        f = new Film();
        f.setTitle("Star Wars");
        f.setDirector("George Lucas");
        f.setImageResId(R.drawable.star);
        f.setComments("El inicio de la legendaria saga de Star Wars en una galaxia muy, muy lejana.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0076759");
        f.setYear(1977);
        films.add(f);

        f = new Film();
        f.setTitle("Indiana Jones");
        f.setDirector("Steven Spielberg");
        f.setImageResId(R.drawable.indiana);
        f.setComments("Las aventuras del arqueólogo y aventurero Indiana Jones en busca de un tesoro legendario.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_ACTION);
        f.setImdbUrl("http://www.imdb.com/title/tt0082971");
        f.setYear(1981);
        films.add(f);

        f = new Film();
        f.setTitle("Jurassic Park");
        f.setDirector("Steven Spielberg");
        f.setImageResId(R.drawable.jurasic);
        f.setComments("Un grupo de científicos queda atrapado en una isla llena de dinosaurios genéticamente recreados.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0107290");
        f.setYear(1993);
        films.add(f);

        f = new Film();
        f.setTitle("Torrente");
        f.setDirector("Santiago Segura");
        f.setImageResId(R.drawable.torrente);
        f.setComments("Las locuras del policía más inepto de España mientras intenta resolver un caso.");
        f.setFormat(Film.FORMAT_DVD);
        f.setGenre(Film.GENRE_COMEDY);
        f.setImdbUrl("http://www.imdb.com/title/tt0117898");
        f.setYear(1998);
        films.add(f);

        f = new Film();
        f.setTitle("Shrek");
        f.setDirector("Andrew Adamson, Vicky Jenson");
        f.setImageResId(R.drawable.sreck);
        f.setComments("Un ogro llamado Shrek se embarca en una misión para rescatar a la princesa Fiona.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_ACTION);
        f.setImdbUrl("http://www.imdb.com/title/tt0126029");
        f.setYear(2001);
        films.add(f);

        f = new Film();
        f.setTitle("El Señor de los Anillos");
        f.setDirector("Peter Jackson");
        f.setImageResId(R.drawable.indiana);
        f.setComments("La primera entrega de la epopeya de fantasía basada en la obra de J.R.R. Tolkien.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0120737");
        f.setYear(2001);
        films.add(f);

        f = new Film();
        f.setTitle("Harry Potter y la Piedra Filosofal");
        f.setDirector("Chris Columbus");
        f.setImageResId(R.drawable.harry);
        f.setComments("La primera película de la saga de Harry Potter basada en las novelas de J.K. Rowling.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0241527");
        f.setYear(2001);
        films.add(f);

        f = new Film();
        f.setTitle("Vengadores: Endgame");
        f.setDirector("Anthony y Joe Russo");
        f.setImageResId(R.drawable.vengadores);
        f.setComments("La culminación de la saga de los Vengadores de Marvel.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt4154796");
        f.setYear(2019);
        films.add(f);

        f = new Film();
        f.setTitle("El Laberinto del Fauno");
        f.setDirector("Guillermo del Toro");
        f.setImageResId(R.drawable.fauno);
        f.setComments("En la posguerra española, una niña se escapa a un mundo de fantasía mientras lidia con la brutalidad de su padrastro.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0457430");
        f.setYear(2006);
        films.add(f);

        f.setTitle("El Padrino");
        f.setDirector("Francis Ford Coppola");
        f.setImageResId(R.drawable.descarga);
        f.setComments("La saga de una poderosa familia de la mafia en Nueva York.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_DRAMA);
        f.setImdbUrl("http://www.imdb.com/title/tt0068646");
        f.setYear(1972);
        films.add(f);

        f = new Film();
        f.setTitle("El Laberinto del Fauno");
        f.setDirector("Guillermo del Toro");
        f.setImageResId(R.drawable.fauno);
        f.setComments("Una niña escapa a un mundo de fantasía mientras enfrenta la brutalidad de su padrastro en la posguerra española.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0457430");
        f.setYear(2006);
        films.add(f);

        f = new Film();
        f.setTitle("El Resplandor");
        f.setDirector("Stanley Kubrick");
        f.setImageResId(R.drawable.resplandor);
        f.setComments("Un escritor y su familia experimentan eventos paranormales aislados en un hotel aislado.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_HORROR);
        f.setImdbUrl("http://www.imdb.com/title/tt0081505");
        f.setYear(1980);
        films.add(f);

        f = new Film();
        f.setTitle("Mar Adentro");
        f.setDirector("Alejandro Amenábar");
        f.setImageResId(R.drawable.mar);
        f.setComments("La historia de un tetrapléjico que luchó por el derecho a morir con dignidad.");
        f.setFormat(Film.FORMAT_DVD);
        f.setGenre(Film.GENRE_DRAMA);
        f.setImdbUrl("http://www.imdb.com/title/tt0369702");
        f.setYear(2004);
        films.add(f);

    }
    public static Film posicionpelicula(int position) {
        if (position >= 0 && position < films.size()) {
            return films.get(position);
        }
        return null;
    }

    }
