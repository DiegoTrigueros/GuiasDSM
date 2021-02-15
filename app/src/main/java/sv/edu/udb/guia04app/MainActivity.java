package sv.edu.udb.guia04app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre, txtSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtSalario = findViewById(R.id.txtHoras);
    }

    public void ResultActivity(View v){
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("txtNombre", txtNombre.getText().toString());
        i.putExtra("txtHoras", txtSalario.getText().toString());
        startActivity(i);
    }
}
