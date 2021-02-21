package sv.edu.udb.ejercicio_desafio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txtSalarioResult, txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtSalarioResult=(TextView) findViewById(R.id.txtSalarioResult);
        txtMensaje = findViewById(R.id.txtMensaje);

        Bundle bundle = getIntent().getExtras();
        String tiempo = bundle.getString("txtTiempo");
        String salario=bundle.getString("txtSalario");

        Integer tiempoInt = Integer.parseInt(tiempo);
        Integer salarioInt = Integer.parseInt(salario);

        Double nuevoSalario = 0.0;
        if(salarioInt < 500 && tiempoInt >=10){
            txtMensaje.setText("Salario con 20% de aumento");
            nuevoSalario = (salarioInt * 0.20) + salarioInt;
            txtSalarioResult.setText(nuevoSalario.toString());
        }else if(salarioInt < 500 && tiempoInt < 5){
            txtMensaje.setText("Salario con 5% de aumento");
            nuevoSalario = (salarioInt * 0.05) + salarioInt;
            txtSalarioResult.setText(nuevoSalario.toString());
        }else if(salarioInt < 500){
            txtMensaje.setText("Salario sin aumento");
            txtSalarioResult.setText(nuevoSalario.toString());
        }

    }
}
