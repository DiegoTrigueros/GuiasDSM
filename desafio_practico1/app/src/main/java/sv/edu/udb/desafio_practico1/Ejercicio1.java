package sv.edu.udb.desafio_practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {
    public String cadenaVotos;
    public double votos1;
    public double votos2;
    public double votos3;
    public double votos4;
    public double porcentaje1;
    public double porcentaje2;
    public double porcentaje3;
    public double porcentaje4;
    public double total;

    private EditText Votos;
    private TextView Resultado1;
    private TextView Resultado2;
    private TextView Resultado3;
    private TextView Resultado4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        Votos=(EditText)findViewById(R.id.editTextVotos);
        Resultado1=(TextView)findViewById(R.id.textCand1);
        Resultado2=(TextView)findViewById(R.id.textCand2);
        Resultado3=(TextView)findViewById(R.id.textCand3);
        Resultado4=(TextView)findViewById(R.id.textCand4);

        Button clickButton = findViewById(R.id.btnCalcular);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {   Calcular();  }
        });
    }

    public void Calcular() {

        //Reiniciando los votos
        votos1 = 0;
        votos2 = 0;
        votos3 = 0;
        votos4 = 0;

        if(Votos.getText().toString() != "" || Votos.getText().toString() != null)
        {
            cadenaVotos = Votos.getText().toString();

            String[] votosSeparados = cadenaVotos.split(",");
            for(int i = 0; i < votosSeparados.length; i++)
            {
                if(votosSeparados[i] != "" && votosSeparados[i] != null)
                {
                    if(votosSeparados[i].trim().contains("1")) votos1 = votos1 + 1;
                    if(votosSeparados[i].trim().contains("2")) votos2 = votos2 + 1;
                    if(votosSeparados[i].trim().contains("3")) votos3 = votos3 + 1;
                    if(votosSeparados[i].trim().contains("4")) votos4 = votos4 + 1;
                }
            }
            total = votos1 + votos2 + votos3 + votos4;
            if(total > 0)
            {
                porcentaje1 = votos1/total*100;
                porcentaje2 = votos2/total*100;;
                porcentaje3 = votos3/total*100;;
                porcentaje4 = votos4/total*100;;
            }

            Resultado1.setText("Candidato 1: " + String.format("%.2f", porcentaje1) + "%");
            Resultado2.setText("Candidato 2: " + String.format("%.2f", porcentaje2) + "%");
            Resultado3.setText("Candidato 3: " + String.format("%.2f", porcentaje3) + "%");
            Resultado4.setText("Candidato 4: " + String.format("%.2f", porcentaje4) + "%");
            Resultado1.setVisibility(View.VISIBLE);
            Resultado2.setVisibility(View.VISIBLE);
            Resultado3.setVisibility(View.VISIBLE);
            Resultado4.setVisibility(View.VISIBLE);
        }
        else
        {
            Toast.makeText(this, "Por favor ingrese una cadena de votos válida.", Toast.LENGTH_SHORT).show();
        }
    }
}