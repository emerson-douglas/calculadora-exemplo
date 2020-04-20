package com.emerson.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText edtxt1;
    private EditText edtxt2;
    private Button btnsoma;
    private Button btnsub;
    private Button btndiv;
    private Button btnmult;
    private TextView lresult;
    private TextView lhistorico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***** ******
        edtxt1 = findViewById (R.id.num1);
        edtxt2 = findViewById (R.id.num2);
        btnsoma = findViewById (R.id.somabtn);
        btnsub = findViewById (R.id.subbtn);
        btndiv = findViewById (R.id.divbtn);
        btnmult = findViewById (R.id.multbtn);
        lresult = findViewById (R.id.labelresult);
        lhistorico = findViewById(R.id.listhist);
        //*****

        //***** limpa os EditTexts
        edtxt1.setText("");
        edtxt2.setText("");
        //*****
        //***** eventos
        btnsoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    calcula("soma");
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcula("sub");
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcula("div");
            }
        });
        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcula("mult");
            }
        });
    }



    boolean txtisnull(EditText edtxt1, EditText edtxt2, TextView resultado){
        resultado.setText("");
        String txt1 = edtxt1.getText().toString();
        String txt2 = edtxt2.getText().toString();

        if(TextUtils.isEmpty(txt1) && TextUtils.isEmpty(txt2)) {
            edtxt1.setError("preencha esse campo");
            edtxt2.setError("preencha esse campo");
            return true;
        }
        if(TextUtils.isEmpty(txt1)) {
            edtxt1.setError("preencha esse campo");
            return true;
        }
        if(TextUtils.isEmpty(txt2)) {
            edtxt2.setError("preencha esse campo");
            return true;
        }else{return false;}
    }
    void calcula(String operacao){
        if(txtisnull(edtxt1,edtxt2,lresult)){return;}
        String txt1 = edtxt1.getText().toString();
        String txt2 = edtxt2.getText().toString();
        //*****converte em float
        float num1 = Float.parseFloat(txt1);
        float num2 = Float.parseFloat(txt2);
        //*****
        if (operacao == "soma") {
            float result = num1 + num2;
            String txtresultado=num1 + " + " + num2 + " = " + result+"\n";
            lresult.setText(txtresultado);
            Historico(txtresultado);
            Toast.makeText(getApplicationContext(), "soma", Toast.LENGTH_SHORT).show();
        }
        if (operacao == "sub") {
            float result = num1 - num2;
            String txtresultado=num1 + " - " + num2 + " = " + result+"\n";
            lresult.setText(txtresultado);
            Historico(txtresultado);
            Toast.makeText(getApplicationContext(), "subtração", Toast.LENGTH_SHORT).show();
        }
        if (operacao == "div") {
            float result = num1 / num2;
            String txtresultado=num1 + " / " + num2 + " = " + result+"\n";
            lresult.setText(txtresultado);
            Historico(txtresultado);

            Toast.makeText(getApplicationContext(), "divisão", Toast.LENGTH_SHORT).show();
        }
        if (operacao == "mult") {
            float result = num1 * num2;
            String txtresultado=num1 + " * " + num2 + " = " + result+"\n";
            lresult.setText(txtresultado);
            Historico(txtresultado);
            Toast.makeText(getApplicationContext(), "multiplicação", Toast.LENGTH_SHORT).show();
        }
    }
    void Historico(String txtresultado){
        lhistorico.append(txtresultado);
        lhistorico.setMovementMethod(new ScrollingMovementMethod());

    }
}
