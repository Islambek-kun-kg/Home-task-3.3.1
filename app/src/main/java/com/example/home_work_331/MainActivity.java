package com.example.home_work_331;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2, edt3;
    private double edtNum1, edtNum2, edtNum3;
    private TextView textView, textView1, textView2;
    private String edtNumText1, edtNumText2, edtNumText3;
    private String save, save1, save2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        edt1 = findViewById(R.id.editText2);
        edt2 = findViewById(R.id.editText3);
        edt3 = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
    }

    public void doubleThisNumbers() {
        edtNumText1 = edt1.getText().toString();
        edtNumText2 = edt2.getText().toString();
        edtNumText3 = edt3.getText().toString();
        if (edtNumText1.equals("") || edtNumText2.equals("") || edtNumText3.equals("")) {
            Toast.makeText(this, "Заполните все поля!!!", Toast.LENGTH_LONG).show();
        } else {
            edtNum1 = Double.parseDouble(edtNumText1);
            edtNum2 = Double.parseDouble(edtNumText2);
            edtNum3 = Double.parseDouble(edtNumText3);
        }
    }

    public void Sum(View view) {
        doubleThisNumbers();
        textView.setText((String) Double.valueOf(edtNum1 + edtNum2 + edtNum3).toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(save, textView.getText().toString());
        outState.putString(save1, textView1.getText().toString());
        outState.putString(save2, textView2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText((String) savedInstanceState.get(save));
        textView1.setText((String) savedInstanceState.get(save1));
        textView2.setText((String) savedInstanceState.get(save2));
    }

    public void Min(View view) {
        doubleThisNumbers();
        textView1.setText((String) Double.valueOf(edtNum1 - edtNum2 - edtNum3).toString());
    }

    public void Um(View view) {
        doubleThisNumbers();
        textView2.setText((String) Double.valueOf(edtNum1 * edtNum2 * edtNum3).toString());
    }
}