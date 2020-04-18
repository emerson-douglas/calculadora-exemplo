package com.emerson.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***** ******
        final EditText edtxt1 = findViewById (R.id.num1);
        final EditText edtxt2 = findViewById (R.id.num2);
        final Button btnsoma = findViewById (R.id.somabtn);
        final Button btnsub = findViewById (R.id.subbtn);
        final Button btndiv = findViewById (R.id.divbtn);
        final Button btnmult = findViewById (R.id.multbtn);
        final TextView lresult = findViewById (R.id.labelresult);
        //*****

        //***** limpa os EditTexts
        edtxt1.setText("");
        edtxt2.setText("");
        //*****
        //***** eventos
        btnsoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stredtxt1 = edtxt1.getText().toString();
                String stredtxt2 = edtxt2.getText().toString();
                boolean check=txtisnull(edtxt1,edtxt2);
                if (check==true) {
                    calcula(edtxt1,edtxt2,"soma",lresult);
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check=txtisnull(edtxt1,edtxt2);
                if (check==true) {
                    calcula(edtxt1,edtxt2,"sub",lresult);
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check=txtisnull(edtxt1,edtxt2);
                if (check==true) {
                    calcula(edtxt1,edtxt2,"div",lresult);
                }
            }
        });
        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean check=txtisnull(edtxt1,edtxt2);
                if (check==true) {
                    calcula(edtxt1,edtxt2,"mult",lresult);
                }
            }
        });
    }
    boolean txtisnull(EditText edtxt1, EditText edtxt2){
        String txt1 = edtxt1.getText().toString();
        String txt2 = edtxt2.getText().toString();

        if(TextUtils.isEmpty(txt1) && TextUtils.isEmpty(txt2)) {
            edtxt1.setError("preencha esse campo");
            edtxt2.setError("preencha esse campo");
            return false;
        }
        if(TextUtils.isEmpty(txt1)) {
            edtxt1.setError("preencha esse campo");
            return false;
        }
        if(TextUtils.isEmpty(txt2)) {
            edtxt2.setError("preencha esse campo");
            return false;
        }else{return true;}

    }
    void calcula(EditText edtxt1, EditText edtxt2,String operacao, TextView resultado){
        String txt1 = edtxt1.getText().toString();
        String txt2 = edtxt2.getText().toString();
        //*****converte em float
        float num1 = Float.parseFloat(txt1);
        float num2 = Float.parseFloat(txt2);
        //*****
        if(operacao=="soma") {
            float result = num1 + num2;
            resultado.setText(Float.toString(num1) + " + " + Float.toString(num2) + " = " + Float.toString(result));
            Toast.makeText(getApplicationContext(), "soma", Toast.LENGTH_SHORT).show();
        }
        if(operacao=="sub") {
            float result = num1 - num2;
            resultado.setText(Float.toString(num1) + " - " + Float.toString(num2) + " = " + Float.toString(result));
            Toast.makeText(getApplicationContext(), "subtração", Toast.LENGTH_SHORT).show();
        }
        if(operacao=="div") {
            float result = num1 / num2;
            resultado.setText(Float.toString(num1) + " / " + Float.toString(num2) + " = " + Float.toString(result));
            Toast.makeText(getApplicationContext(), "divisão", Toast.LENGTH_SHORT).show();
        }
        if(operacao=="mult") {
            float result = num1 * num2;
            resultado.setText(Float.toString(num1) + " * " + Float.toString(num2) + " = " + Float.toString(result));
            Toast.makeText(getApplicationContext(), "multiplicação", Toast.LENGTH_SHORT).show();
        }
    }

}
