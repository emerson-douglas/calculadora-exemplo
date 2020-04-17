package com.emerson.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emerson.calculadora.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***** vars ******
        final EditText edtxt1 = findViewById (R.id.num1);
        final EditText edtxt2 = findViewById (R.id.num2);
        final Button btnsoma = findViewById (R.id.somabtn);
        final Button btnsub = findViewById (R.id.subbtn);
        final Button btndiv = findViewById (R.id.divbtn);
        final Button btnmult = findViewById (R.id.multbtn);
        final TextView lresult = findViewById (R.id.labelresult);
        //*****

        //***** clear edit texts
        edtxt1.setText("");
        edtxt2.setText("");
        //*****
        //***** events
        btnsoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stredtxt1 = edtxt1.getText().toString();
                String stredtxt2 = edtxt2.getText().toString();

                if(TextUtils.isEmpty(stredtxt1) && TextUtils.isEmpty(stredtxt2)) {
                    edtxt1.setError("preencha esse campo");
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt1)) {
                    edtxt1.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt2)) {
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                float num1 = Float.parseFloat(stredtxt1);
                float num2 = Float.parseFloat(stredtxt2);
                float result = num1 + num2;
                lresult.setText(Float.toString(num1)+" + "+Float.toString(num2)+" = "+Float.toString(result));
                Toast.makeText(getApplicationContext(),"soma", Toast.LENGTH_SHORT).show();
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stredtxt1 = edtxt1.getText().toString();
                String stredtxt2 = edtxt2.getText().toString();

                if(TextUtils.isEmpty(stredtxt1) && TextUtils.isEmpty(stredtxt2)) {
                    edtxt1.setError("preencha esse campo");
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt1)) {
                    edtxt1.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt2)) {
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                float num1 = Float.parseFloat(stredtxt1);
                float num2 = Float.parseFloat(stredtxt2);
                float result = num1 - num2;
                lresult.setText(Float.toString(num1)+" - "+Float.toString(num2)+" = "+Float.toString(result));
                Toast.makeText(getApplicationContext(),"subtração", Toast.LENGTH_SHORT).show();
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stredtxt1 = edtxt1.getText().toString();
                String stredtxt2 = edtxt2.getText().toString();

                if(TextUtils.isEmpty(stredtxt1) && TextUtils.isEmpty(stredtxt2)) {
                    edtxt1.setError("preencha esse campo");
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt1)) {
                    edtxt1.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt2)) {
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                float num1 = Float.parseFloat(stredtxt1);
                float num2 = Float.parseFloat(stredtxt2);
                float result = num1 / num2;
                lresult.setText(Float.toString(num1)+" / "+Float.toString(num2)+" = "+Float.toString(result));
                Toast.makeText(getApplicationContext(),"divisão", Toast.LENGTH_SHORT).show();
            }
        });
        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stredtxt1 = edtxt1.getText().toString();
                String stredtxt2 = edtxt2.getText().toString();

                if(TextUtils.isEmpty(stredtxt1) && TextUtils.isEmpty(stredtxt2)) {
                    edtxt1.setError("preencha esse campo");
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt1)) {
                    edtxt1.setError("preencha esse campo");
                    return;
                }
                if(TextUtils.isEmpty(stredtxt2)) {
                    edtxt2.setError("preencha esse campo");
                    return;
                }
                float num1 = Float.parseFloat(stredtxt1);
                float num2 = Float.parseFloat(stredtxt2);
                float result = num1 * num2;
                lresult.setText(Float.toString(num1)+" * "+Float.toString(num2)+" = "+Float.toString(result));
                Toast.makeText(getApplicationContext(),"multiplicação", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
