package sv.edu.udb.guia12app.content.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context,
                          String name,
                          SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase database) {
        createTable(database); // Tabla "students"
        loadDummyData(database); // Datos de prueba
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Actualizaciones
    }

    /**
     * Crear tabla en la base de datos
     *
     * @param database Instancia de la base de datos
     */
    private void createTable(SQLiteDatabase database) {
        String cmd = "CREATE TABLE " + StudentsContract.STUDENTS + " (" +
                StudentsContract.Columnas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                StudentsContract.Columnas.NOMBRE + " TEXT, " +
                StudentsContract.Columnas.APELLIDO + " TEXT, " +
                StudentsContract.Columnas.CARNET + " TEXT);";
        database.execSQL(cmd);
    }

    /**
     * Carga datos de ejemplo en la tabla
     * @param database Instancia de la base de datos
     */
    private void loadDummyData(SQLiteDatabase database) {

        ContentValues values = new ContentValues();
        values.put(StudentsContract.Columnas.NOMBRE, "Oscar");
        values.put(StudentsContract.Columnas.APELLIDO, "Serpas");
        values.put(StudentsContract.Columnas.CARNET, "SO170273");
        database.insert(StudentsContract.STUDENTS, null, values);

        values = new ContentValues();
        values.put(StudentsContract.Columnas.NOMBRE, "Juan");
        values.put(StudentsContract.Columnas.APELLIDO, "Perez");
        values.put(StudentsContract.Columnas.CARNET, "JP160379");
        database.insert(StudentsContract.STUDENTS, null, values);


        values = new ContentValues();
        values.put(StudentsContract.Columnas.NOMBRE, "Oscar");
        values.put(StudentsContract.Columnas.APELLIDO, "Palacios");
        values.put(StudentsContract.Columnas.CARNET, "PM170275");
        database.insert(StudentsContract.STUDENTS, null, values);


        values = new ContentValues();
        values.put(StudentsContract.Columnas.NOMBRE, "Diego");
        values.put(StudentsContract.Columnas.APELLIDO, "Trigueros");
        values.put(StudentsContract.Columnas.CARNET, "TF170240");
        database.insert(StudentsContract.STUDENTS, null, values);


        values = new ContentValues();
        values.put(StudentsContract.Columnas.NOMBRE, "Ricardo");
        values.put(StudentsContract.Columnas.APELLIDO, "Majano");
        values.put(StudentsContract.Columnas.CARNET, "MD170149");
        database.insert(StudentsContract.STUDENTS, null, values);

    }
}
