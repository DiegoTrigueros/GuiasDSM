package sv.edu.udb.crud_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class ModifyUser extends AppCompatActivity {
    EditText edtNombre, edtId, edtApellido, edtPhone;
    String key="",nombre="",lastName="",phone="", accion="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_user);
        inicializar();
    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtName);
        edtId = findViewById(R.id.edtId);
        edtApellido = findViewById(R.id.edtApellido);
        edtPhone = findViewById(R.id.edtPhone);

        Bundle datos = getIntent().getExtras();
        key = datos.getString("userId");
        nombre=datos.getString("userName");
        lastName=datos.getString("userLastName");
        phone = datos.getString("userPhone");
        accion=datos.getString("accion");
        edtId.setText(key);
        edtNombre.setText(nombre);
        edtApellido.setText(lastName);
        edtPhone.setText(phone);
    }

    public void guardar(View v){
        String userId = edtId.getText().toString();
        String nombre = edtNombre.getText().toString();
        String apellido = edtApellido.getText().toString();
        String phone = edtPhone.getText().toString();

        User persona = new User(userId,nombre,apellido,phone);

        if (accion.equals("a")) {
            String uuid = UUID.randomUUID().toString();
            String new_uid = uuid.substring(uuid.length() - 16);
            persona.setUserId(new_uid);
            MainActivity.databaseRef.child(new_uid).setValue(persona);
        }
        else
        {
            MainActivity.databaseRef.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }
}
