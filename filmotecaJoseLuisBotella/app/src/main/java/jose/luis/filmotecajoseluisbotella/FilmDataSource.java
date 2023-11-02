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

        f = new Film();
        f.setTitle("Piratas del Caribe: La Maldición del Perla Negra");
        f.setDirector("Gore Verbinski");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Las aventuras del Capitán Jack Sparrow en busca de un tesoro legendario.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_ACTION);
        f.setImdbUrl("http://www.imdb.com/title/tt0325980");
        f.setYear(2003);
        films.add(f);

        f = new Film();
        f.setTitle("Toy Story");
        f.setDirector("John Lasseter");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("La primera película animada de Pixar sobre los juguetes que cobran vida cuando los humanos no están mirando.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0114709");
        f.setYear(1995);
        films.add(f);

        f = new Film();
        f.setTitle("Star Wars: Episodio IV - Una Nueva Esperanza");
        f.setDirector("George Lucas");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("El inicio de la legendaria saga de Star Wars en una galaxia muy, muy lejana.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0076759");
        f.setYear(1977);
        films.add(f);

        f = new Film();
        f.setTitle("Indiana Jones y los Cazadores del Arca Perdida");
        f.setDirector("Steven Spielberg");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Las aventuras del arqueólogo y aventurero Indiana Jones en busca de un tesoro legendario.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_ACTION);
        f.setImdbUrl("http://www.imdb.com/title/tt0082971");
        f.setYear(1981);
        films.add(f);

        f = new Film();
        f.setTitle("Jurassic Park");
        f.setDirector("Steven Spielberg");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Un grupo de científicos queda atrapado en una isla llena de dinosaurios genéticamente recreados.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0107290");
        f.setYear(1993);
        films.add(f);

        f = new Film();
        f.setTitle("Torrente, el brazo tonto de la ley");
        f.setDirector("Santiago Segura");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Las locuras del policía más inepto de España mientras intenta resolver un caso.");
        f.setFormat(Film.FORMAT_DVD);
        f.setGenre(Film.GENRE_COMEDY);
        f.setImdbUrl("http://www.imdb.com/title/tt0117898");
        f.setYear(1998);
        films.add(f);

        f = new Film();
        f.setTitle("Shrek");
        f.setDirector("Andrew Adamson, Vicky Jenson");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Un ogro llamado Shrek se embarca en una misión para rescatar a la princesa Fiona.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_ACTION);
        f.setImdbUrl("http://www.imdb.com/title/tt0126029");
        f.setYear(2001);
        films.add(f);

        f = new Film();
        f.setTitle("El Señor de los Anillos: La Comunidad del Anillo");
        f.setDirector("Peter Jackson");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("La primera entrega de la epopeya de fantasía basada en la obra de J.R.R. Tolkien.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0120737");
        f.setYear(2001);
        films.add(f);

        f = new Film();
        f.setTitle("Harry Potter y la Piedra Filosofal");
        f.setDirector("Chris Columbus");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("La primera película de la saga de Harry Potter basada en las novelas de J.K. Rowling.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0241527");
        f.setYear(2001);
        films.add(f);

        f = new Film();
        f.setTitle("Vengadores: Endgame");
        f.setDirector("Anthony y Joe Russo");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("La culminación de la saga de los Vengadores de Marvel.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt4154796");
        f.setYear(2019);
        films.add(f);

        f = new Film();
        f.setTitle("El Laberinto del Fauno");
        f.setDirector("Guillermo del Toro");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("En la posguerra española, una niña se escapa a un mundo de fantasía mientras lidia con la brutalidad de su padrastro.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0457430");
        f.setYear(2006);
        films.add(f);

        f = new Film();
        f.setTitle("El Secreto de sus Ojos");
        f.setDirector("Juan José Campanella");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Un investigador judicial jubilado busca la verdad detrás de un caso sin resolver y recuerda un amor del pasado.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_DRAMA);
        f.setImdbUrl("http://www.imdb.com/title/tt1305806");
        f.setYear(2009);
        films.add(f);

        f.setTitle("El Padrino");
        f.setDirector("Francis Ford Coppola");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("La saga de una poderosa familia de la mafia en Nueva York.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_DRAMA);
        f.setImdbUrl("http://www.imdb.com/title/tt0068646");
        f.setYear(1972);
        films.add(f);

        f = new Film();
        f.setTitle("El Laberinto del Fauno");
        f.setDirector("Guillermo del Toro");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Una niña escapa a un mundo de fantasía mientras enfrenta la brutalidad de su padrastro en la posguerra española.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_SCIFI);
        f.setImdbUrl("http://www.imdb.com/title/tt0457430");
        f.setYear(2006);
        films.add(f);

        f = new Film();
        f.setTitle("El Resplandor");
        f.setDirector("Stanley Kubrick");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Un escritor y su familia experimentan eventos paranormales aislados en un hotel aislado.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_HORROR);
        f.setImdbUrl("http://www.imdb.com/title/tt0081505");
        f.setYear(1980);
        films.add(f);

        f = new Film();
        f.setTitle("Mujeres al Borde de un Ataque de Nervios");
        f.setDirector("Pedro Almodóvar");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Una azafata busca al amante que la dejó con una cacerola de gazpacho como única explicación.");
        f.setFormat(Film.FORMAT_DVD);
        f.setGenre(Film.GENRE_COMEDY);
        f.setImdbUrl("http://www.imdb.com/title/tt0095675");
        f.setYear(1988);
        films.add(f);

        f = new Film();
        f.setTitle("Los Otros");
        f.setDirector("Alejandro Amenábar");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Una mujer con dos hijos fotosensibles contrata a tres sirvientes para cuidar de su mansión.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_HORROR);
        f.setImdbUrl("http://www.imdb.com/title/tt0230600");
        f.setYear(2001);
        films.add(f);

        f = new Film();
        f.setTitle("Mar Adentro");
        f.setDirector("Alejandro Amenábar");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("La historia de un tetrapléjico que luchó por el derecho a morir con dignidad.");
        f.setFormat(Film.FORMAT_DVD);
        f.setGenre(Film.GENRE_DRAMA);
        f.setImdbUrl("http://www.imdb.com/title/tt0369702");
        f.setYear(2004);
        films.add(f);

        f = new Film();
        f.setTitle("Rec");
        f.setDirector("Jaume Balagueró, Paco Plaza");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Una reportera y su cámara quedan atrapados en un edificio infectado por una extraña epidemia.");
        f.setFormat(Film.FORMAT_BLURAY);
        f.setGenre(Film.GENRE_HORROR);
        f.setImdbUrl("http://www.imdb.com/title/tt1038988");
        f.setYear(2007);
        films.add(f);

        f = new Film();
        f.setTitle("Y tu mamá también");
        f.setDirector("Alfonso Cuarón");
        f.setImageResId(R.mipmap.ic_launcher);
        f.setComments("Dos adolescentes emprenden un viaje con una mujer mayor y descubren la vida y el deseo.");
        f.setFormat(Film.FORMAT_DIGITAL);
        f.setGenre(Film.GENRE_DRAMA);
        f.setImdbUrl("http://www.imdb.com/title/tt0245574");
        f.setYear(2001);
        films.add(f);
    }
    }
