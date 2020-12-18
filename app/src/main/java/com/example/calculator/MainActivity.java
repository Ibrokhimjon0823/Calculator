package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {
    Button share;
    Button button1;
    TextView textView;
    TextView textView2;
    public boolean start = true;
    String operator = "";
    double num1 = 0;
    int num = 0;

    @SuppressLint("SetTextI18n")
    public void processNumber(View view) {
        if (start) {
            textView.setText("");
            start = false;
        }

        String value = String.valueOf(view.getTag());
        textView.setText(textView.getText() + value);
        // textView2.setText(textView2.getText()+value);

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


    public void processOperator(View view) {
        String value = String.valueOf(view.getTag());
        if (!value.equals("=")) {
            if (textView.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "First, Enter Value", Toast.LENGTH_LONG).show();
            }else {
                if (!operator.isEmpty())
                    return;
                operator = value;
                String stringNum;
                stringNum = textView.getText().toString();
                num1 = Double.parseDouble(stringNum);
                textView.setText("");
            }
        } else {
            if (operator.isEmpty())
                return;
            String stringNum;
            stringNum = textView.getText().toString();

            double num2 = Double.parseDouble(stringNum);
            double output = calculate(num1, num2, operator);
            textView.setText(String.valueOf(output));
            operator = "";
            start = true;


        }
    }

    public void processDel(View view) {
        String value = String.valueOf(view.getTag());
        if (value.equals("C")) {
            textView.setText("");
        }
    }

    public void processDelOne(View view) {
        String value = String.valueOf(view.getTag());
        if (value.equals("DEL")) {
            if (textView.getText().toString().isEmpty())
                return;
            textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1));

        }
    }
    public void root(View view) {
        String value = String.valueOf(view.getTag());
        if (value.equals("sqrt")) {
            String string;
            if (textView.getText().toString().isEmpty())
                return;
            string = textView.getText().toString();
            double num = Double.parseDouble(string);
            if (num < 0) {
                Toast.makeText(getApplicationContext(), "wrong number", Toast.LENGTH_SHORT).show();
                textView.setText("");
            } else {
                double num1 = Math.sqrt(num);
                textView.setText(String.valueOf(num1));
            }
        }
    }

    private ShareActionProvider shareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.currency:
                Intent currency=new Intent(getApplicationContext(), Currency.class);
                startActivity(currency);
                break;
            case R.id.numeric:
                Intent numerical = new Intent(getApplicationContext(), NumericalConverter.class);
                startActivity(numerical);
                break;
            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "O'xshamadi boshqatdan";
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;
            case R.id.volume:
                Intent intent = new Intent(getApplicationContext(), volume.class);
                startActivity(intent);
                break;
            default:
                return false;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        textView = findViewById(R.id.textView);


    }

    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0)
                    return 0;
                return num1 / num2;
            case "%":
                return num1 % num2;
            default:
                return 0;
        }
    }
}