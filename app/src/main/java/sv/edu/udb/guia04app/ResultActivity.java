package sv.edu.udb.guia04app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txtNombre, txtSalarioNeto, txtISSS, txtAFP, txtRenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtNombre = findViewById(R.id.txtNombreResult);
        txtSalarioNeto = findViewById(R.id.txtSalarioResult);
        txtISSS = findViewById(R.id.txtISSS);
        txtAFP = findViewById(R.id.txtAFP);
        txtRenta = findViewById(R.id.txtRenta);

        Bundle bundle = getIntent().getExtras();
        String nombre=bundle.getString("txtNombre");
        String horas=bundle.getString("txtHoras");

        txtNombre.setText(nombre);
        Integer horasTrabajadas = Integer.parseInt(horas);
        Double salarioNeto, isss, afp, renta;
        salarioNeto = horasTrabajadas * 8.5;
        txtSalarioNeto.setText("Salario neto: "+salarioNeto.toString());
        isss = salarioNeto * 0.02;
        afp = salarioNeto * 0.03;
        renta = salarioNeto * 0.04;
        txtISSS.setText("ISSS: "+isss.toString());
        txtRenta.setText("Renta: "+renta.toString());
        txtAFP.setText("AFP: "+afp.toString());
    }
}
