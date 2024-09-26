package jose.luis.filmotecajoseluisbotella;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FilmListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lista;
    List<Film> listado;
    SQLiteDatabase db;
    private static final int codigoPelicula=1;
    private final String Canal_id="1";

    FilmAdapter miadaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filmlistactivity);


        db = openOrCreateDatabase("MisPeliculas", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS peliculas(id Integer Primary Key AutoIncrement,Imagen Integer,Titulo Varchar,Director Varchar, Año Integer, Formato Integer, Genero Integer, URL Varchar, Comentarios Varchar);");


        lista = (ListView) findViewById(R.id.listapeliculas);
        lista.setOnItemClickListener(this);
        registerForContextMenu(lista);
        listar();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Intent intent = new Intent(FilmListActivity.this, FilmDataActivity.class);
        intent.putExtra("FILM_POSITION", position);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, codigoPelicula);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
        }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemAgregarPelicula:
                AlertDialog.Builder builder = new AlertDialog.Builder(FilmListActivity.this);
                builder.setTitle("Nueva Pelicula")
                        .setMessage("¿Desea agregar una nueva pelicula?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Genero, Formato, URL, Comentarios) " +
                                "VALUES('" + R.drawable.cine + "','" + "Nueva Pelicula" + "', '" + "Sin Director" + "', '" + 2004 + "', '" + 2 + "', '" + 2 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Comentarios pelicula." + "');");
                        listado.add(new Film( listado.size(),R.drawable.cine, "Nueva Pelicula", "Roland Emmerich", 2004, 2, 2, "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1", "Jack Hall, paleoclimatólogo, debe realizar un arriesgado viaje desde Washington D. C. hasta Nueva York para llegar hasta su hijo, atrapado en una repentina tormenta internacional que sumerge al planeta en una nueva edad de hielo."));
                        listar();

                        mostrarNotificacion(true, true);

                        mostrartoastpropio("Nueva Pelicula Creada");
                        miadaptador.notifyDataSetChanged();
                        lista.setAdapter(miadaptador);


                    }
                });



                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // Crear el cuadro de diálogo
                AlertDialog alertDialog = builder.create();

                // Mostrar el cuadro de diálogo
                alertDialog.show();

                return true;
            case R.id.itemAcercaDe:
                // Abre la actividad AboutActivity
                Intent aboutIntent = new Intent(FilmListActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                return true;
            case R.id.cerrarsesion:
                Intent mainIntent = new Intent(FilmListActivity.this, MainActivity.class);
                startActivity(mainIntent);
                return true;
            case R.id.masinfo:
                Intent masIntent = new Intent(FilmListActivity.this, VideoPlayer.class);
                startActivity(masIntent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void mostrarNotificacion (boolean expandible, boolean actividad) {
        //1. - Crear la notificación con sus propiedades.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Canal_id);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);

        if (!expandible) {
            builder.setContentTitle("Nueva Pelicula");
            builder.setContentText("Has creado una nueva pelicula");
        } else {
            NotificationCompat.InboxStyle estilo = new NotificationCompat.InboxStyle();
            estilo.setBigContentTitle("Nueva Pelicula");

            //Crea las diferentes lineas
            String[] lineas = new String[5];
            lineas[0] = "Titulo Pelicula";
            lineas[1] = "Sin Autor";
            lineas[2] = "R.drawable.cine";
            lineas[3] = "Descripcion de la pelicula";

            for (int i = 0; i < lineas.length; i++)
                estilo.addLine(lineas[i]);

            builder.setStyle(estilo);

            builder.setPriority(NotificationCompat.PRIORITY_MAX);
            int posicion= listado.size()-1;
            Intent intent = new Intent(this, FilmEditActivity.class);
            intent.putExtra("FILM_POSITION", posicion);


            PendingIntent pending = PendingIntent.getActivity(this, posicion, intent, PendingIntent.FLAG_IMMUTABLE);
            builder.setContentIntent(pending);


            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel canal = new NotificationChannel(Canal_id, "Titulo del canal", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(canal);
            }

            Notification notificacion = builder.build();
            notificationManager.notify(Integer.parseInt(Canal_id), notificacion);
            builder.setStyle(estilo);
        }


        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucontext, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Film film=(Film) lista.getItemAtPosition(info.position);
        int id=item.getItemId();
        switch (id){
            case R.id.eliminar:
                AlertDialog.Builder builder = new AlertDialog.Builder(FilmListActivity.this);
                builder.setTitle("Eliminar Pelicula")
                        .setMessage("¿Desea eliminar la pelicula?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.execSQL("DELETE FROM peliculas WHERE id = '" + film.getId() + "';");
                        listado.remove(film);

                        miadaptador.notifyDataSetChanged();
                        lista.setAdapter(miadaptador);
                        miadaptador.notifyDataSetChanged();
                        listar();
                        miadaptador.notifyDataSetChanged();

                        String textoeliminar="Pelicula Eliminada";
                        mostrartoastpropio(textoeliminar);

                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                break;
            case R.id.editar:
                Intent intent = new Intent(FilmListActivity.this, FilmEditActivity.class);
                intent.putExtra("FILM_POSITION", info.position);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void mostrartoastpropio(String texto) {
        Toast mensaje = new Toast(FilmListActivity.this);
        View mensaje_layaout = getLayoutInflater().inflate(R.layout.toast_propio, null);
        mensaje.setView(mensaje_layaout);
        TextView textoToast = (TextView) mensaje_layaout.findViewById(R.id.toastMessage);
        textoToast.setText(texto);
        mensaje.setDuration(Toast.LENGTH_SHORT);
        mensaje.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case codigoPelicula:
                if(resultCode == Activity.RESULT_OK){
                    listar();
                    setResult(RESULT_OK, null);
                    miadaptador.notifyDataSetChanged();
                }
        }
    }



    private void listar() {
        listado = new ArrayList<Film>();
        // Codigo para leer de la base de datos y añadir a la lista.
        Cursor c = db.rawQuery("SELECT * FROM peliculas", null);
        if (c.getCount()==0){
            mostrartoastpropio("Se han añadido elementos a tu base de datos");
            crearPelis();
        }else{
            while(c.moveToNext()){
                int id = c.getInt(0);
                int imagen = c.getInt(1);
                String titulo = c.getString(2);
                String director = c.getString(3);
                int año = c.getInt(4);
                int formato = c.getInt(5);
                int genero = c.getInt(6);
                String url = c.getString(7);
                String comentarios = c.getString(8);

                listado.add(new Film(id, imagen, titulo, director, año, formato, genero, url, comentarios));
            }
        }
        c.close();
        miadaptador = new FilmAdapter(getApplicationContext(), R.layout.item_film, listado);
        lista.setAdapter(miadaptador);
    }

    private void crearPelis() {
        Cursor cursor = db.rawQuery("SELECT * FROM peliculas", null);
        if(cursor.getCount() == 0) {
            db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                    "VALUES('" + R.drawable.interestelar + "','" + "Interstellar" + "', '" + "Christopher Nolan" + "', '" + 1984 + "', '" + 2 + "', '" + 3 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "A team of explorers travel throught a wormhole in space in an attempt to ensure humanity’s survival" + "');");
            db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                    "VALUES('" + R.drawable.regreso + "','" + "Regreso al futuro" + "', '" + "Robert Zemeckis" + "', '" + 1985 + "', '" + 2 + "', '" + 3 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Marty McFly, is sent 30 years into the past in a time-travelling DeLorean" + "');");

            db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                    "VALUES('" + R.drawable.piratas + "','" + "Piratas del Caribe" + "', '" + "Gore Verbinski" + "', '" + 2003 + "', '" + 2 + "', '" + 2 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Las aventuras del Capitán Jack Sparrow en busca de un tesoro legendario." + "');");
            db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                    "VALUES('" + R.drawable.eldiademanana + "','" + "El dia de mañana" + "', '" + "Roland Emmerich" + "', '" + 2004 + "', '" + 1 + "', '" + 0 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Jack Hall, paleoclimatólogo, debe realizar un arriesgado viaje desde Washington D. C. hasta Nueva York para llegar hasta su hijo, atrapado en una repentina tormenta internacional que sumerge al planeta en una nueva edad de hielo." + "');");
       /*
        db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                "VALUES('" + R.drawable.eldiademanana + "','" + "El dia de mañana" + "', '" + "Roland Emmerich" +"', '" + 2004 + "', '" + 2 + "', '" + 2 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Jack Hall, paleoclimatólogo, debe realizar un arriesgado viaje desde Washington D. C. hasta Nueva York para llegar hasta su hijo, atrapado en una repentina tormenta internacional que sumerge al planeta en una nueva edad de hielo." + "');");
        db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                "VALUES('" + R.drawable.eldiademanana + "','" + "El dia de mañana" + "', '" + "Roland Emmerich" +"', '" + 2004 + "', '" + 2 + "', '" + 2 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Jack Hall, paleoclimatólogo, debe realizar un arriesgado viaje desde Washington D. C. hasta Nueva York para llegar hasta su hijo, atrapado en una repentina tormenta internacional que sumerge al planeta en una nueva edad de hielo." + "');");
        db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                "VALUES('" + R.drawable.eldiademanana + "','" + "El dia de mañana" + "', '" + "Roland Emmerich" +"', '" + 2004 + "', '" + 2 + "', '" + 2 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Jack Hall, paleoclimatólogo, debe realizar un arriesgado viaje desde Washington D. C. hasta Nueva York para llegar hasta su hijo, atrapado en una repentina tormenta internacional que sumerge al planeta en una nueva edad de hielo." + "');");
        db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                "VALUES('" + R.drawable.eldiademanana + "','" + "El dia de mañana" + "', '" + "Roland Emmerich" +"', '" + 2004 + "', '" + 2 + "', '" + 2 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Jack Hall, paleoclimatólogo, debe realizar un arriesgado viaje desde Washington D. C. hasta Nueva York para llegar hasta su hijo, atrapado en una repentina tormenta internacional que sumerge al planeta en una nueva edad de hielo." + "');");
        db.execSQL("INSERT INTO peliculas (Imagen, Titulo, Director, Año, Formato, Genero, URL, Comentarios) " +
                "VALUES('" + R.drawable.eldiademanana + "','" + "El dia de mañana" + "', '" + "Roland Emmerich" +"', '" + 2004 + "', '" + 2 + "', '" + 2 + "', '" + "https://www.imdb.com/title/tt0319262/?ref_=fn_al_tt_1" + "', '" + "Jack Hall, paleoclimatólogo, debe realizar un arriesgado viaje desde Washington D. C. hasta Nueva York para llegar hasta su hijo, atrapado en una repentina tormenta internacional que sumerge al planeta en una nueva edad de hielo." + "');");
    */
        }
        cursor.close();
        listar();

        }




}
