package br.com.agencianextdigital.calculacombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Principal extends AppCompatActivity {

    private TextInputEditText et_gasolina, et_alcool;
    Button btn_calcular, btn_calcularMedia;
    TextView tv_resultado;
    double calcula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Inicia();


        btn_calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Principal.INPUT_METHOD_SERVICE);
                    if(imm.isActive())
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    Calcular();
                }
            });


        btn_calcularMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this, CalcularMedia.class);
                startActivity(i);
            }
        });
    }

    public void Inicia() {

            et_gasolina = (TextInputEditText) findViewById(R.id.et_gasolina);
            et_alcool = (TextInputEditText) findViewById(R.id.et_alcool);
            btn_calcular = (Button) findViewById(R.id.btn_calcular);
            btn_calcularMedia = (Button) findViewById(R.id.btn_calcularMedia);
            tv_resultado = (TextView) findViewById(R.id.tv_resultado);
    }

    public void Calcular() {

        if (et_gasolina.getText().toString().isEmpty()){
            tv_resultado.setText(String.valueOf("Valores Incorretos!"));
        }else if (et_alcool.getText().toString().isEmpty()) {
            tv_resultado.setText(String.valueOf("Valores Incorretos!"));
        }else{
            double gasolina = Double.parseDouble(et_gasolina.getText().toString());
            double alcool = Double.parseDouble(et_alcool.getText().toString());

            calcula = (alcool / gasolina);

            if (calcula < 0.70) {
                tv_resultado.setText(String.valueOf("Álcool é a melhor opção"));
            } else if (calcula > 0.70) {
                tv_resultado.setText(String.valueOf("Gasolina é a melhor opção"));
            }
        }
    }
}