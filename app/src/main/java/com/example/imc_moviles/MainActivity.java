package com.example.imc_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonAceptar;
    private EditText peso;
    private EditText estatura;
    private TextView resul;
    private float pesoimc=0.0f;
    private float estaturaimc= 0.0f;
    private float imcCal= 0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAceptar=(Button) findViewById(R.id.btt_aceptar);
        peso=(EditText) findViewById(R.id.editText_peso);
        estatura=(EditText) findViewById(R.id.editText_estatura);
        resul=(TextView) findViewById(R.id.texv_resultado);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesoimc= Float.parseFloat(peso.getText().toString());
                estaturaimc= Float.parseFloat(estatura.getText().toString());
                imcCal=calculaIMC(pesoimc,estaturaimc);

                resul.setText("Descripcion, "+clasificacionIMC(imcCal)+"\n"+"IMC "+imcCal);
            }
        });
    }

    public float calculaIMC(float peso,float altura){
        return peso/(altura*altura);
    }

    public String clasificacionIMC(float a){
        String clasificacion="Obesidad Clase III";

            if(a<16.0f) {
                clasificacion = "Desnutricion severa";
            }else if(a>16.0f && a<18.5f){
                clasificacion="Desnutricion Moderada";
            }else if(a>=18.5f && a<=22.0f){
                clasificacion="Bajo peso";
            }else if(a>22.0f && a<25.0f){
                clasificacion="Peso Normal";
            }else if(a>=25.0f && a<30.0f){
                clasificacion="Preobesidad";
            }else if(a>=30.0f && a<35.0){
                clasificacion="Obesidad Clase I";
            }else if(a>=35.0f && a<40.0){
                clasificacion="Obesidad Clase II";
            }
        return clasificacion;
    }
}
