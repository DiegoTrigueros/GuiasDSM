package sv.edu.udb.ejercicio_desafio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtTiempo, txtSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTiempo = findViewById(R.id.txtTiempo);
        txtSalario = findViewById(R.id.txtSalario);
    }

    public void ResultActivity(View v){
        if ((Integer.parseInt(txtTiempo.getText().toString()) < 0) || (Integer.parseInt(txtTiempo.getText().toString()) < 0)){
            Toast notificacion= Toast.makeText(this,"Error en valores",Toast.LENGTH_LONG);
            notificacion.show();
        }else{
            Intent i=new Intent(this, ResultActivity.class);
            i.putExtra("txtSalario", txtSalario.getText().toString());
            i.putExtra("txtTiempo", txtTiempo.getText().toString());
            startActivity(i);
        }
    }
}
