package br.com.agencianextdigital.calculacombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Principal.class);
                startActivity(i);
                finish();
            }
        }, 4000);

    }
}


// CRIAR APP QUE CALCULE QUAL COMBUSTIVEL É O MAIS RECOMENDADO DE ACORDO COM O PREÇO DIGITADO.

// CRIAR DENTRO DESSE APP UM BOTÃO PARA CHAMAR OUTRA TELA ONDE A MESMA IRÁ CALCULAR O VALOR DE
//  ABASTECIDA E QUANTOS KM ELA ANDOU PARA SABER QUAL É A MÉDIA GASTA NA VIAGEM.