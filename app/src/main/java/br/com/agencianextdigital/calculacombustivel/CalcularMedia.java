package br.com.agencianextdigital.calculacombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class CalcularMedia extends AppCompatActivity {

    private TextInputEditText et_km, et_litros;
    TextView tv_mostrar;
    Button btn_calcula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_media);

        Inicia();

        btn_calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcula();
            }
        });
    }

    public void Inicia(){
        et_km = (TextInputEditText) findViewById(R.id.et_km);
        et_litros = (TextInputEditText) findViewById(R.id.et_litros);
        btn_calcula = (Button) findViewById(R.id.btn_calcula);
        tv_mostrar = (TextView) findViewById(R.id.tv_mostrar);
    }

    public void Calcula() {

        if (et_km.getText().toString().isEmpty()){
            tv_mostrar.setText(String.valueOf("Valores Incorretos!"));
        }else if (et_litros.getText().toString().isEmpty()) {
            tv_mostrar.setText(String.valueOf("Valores Incorretos!"));
        }else {
            double km = Double.parseDouble(et_km.getText().toString());
            double litros = Double.parseDouble(et_litros.getText().toString());

            DecimalFormat df = new DecimalFormat("0.0");
            Double calcula = (km / litros);

            tv_mostrar.setText(String.valueOf( df.format(calcula) + " km por litro"));
        }
    }
}