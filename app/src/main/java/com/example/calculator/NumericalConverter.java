package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class NumericalConverter extends AppCompatActivity {
    Button button1Convert, buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;
    Button button2Convert, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    ListView listView1;
    ListView listView2;
    GridLayout gridLayout;

    boolean start=true;

    public void convert1(View view){
        textView3.setVisibility(View.INVISIBLE);
        disableButtons();
        textView1.setText("");
        listView1.setVisibility(View.VISIBLE);
        button1Convert.setVisibility(View.INVISIBLE);
        button2Convert.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.INVISIBLE);
    }
    public void convert2(View view){
        textView3.setVisibility(View.INVISIBLE);
        textView2.setText("");
        listView2.setVisibility(View.VISIBLE);
        button1Convert.setVisibility(View.INVISIBLE);
        button2Convert.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.INVISIBLE);
    }
    public void disableButtons(){
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
        button5.setClickable(false);
        button6.setClickable(false);
        button7.setClickable(false);
        button8.setClickable(false);
        button9.setClickable(false);
        buttonA.setClickable(false);
        buttonB.setClickable(false);
        buttonC.setClickable(false);
        buttonD.setClickable(false);
        buttonE.setClickable(false);
        buttonF.setClickable(false);
        button2.setTextColor(Color.LTGRAY);
        button3.setTextColor(Color.LTGRAY);
        button4.setTextColor(Color.LTGRAY);
        button5.setTextColor(Color.LTGRAY);
        button6.setTextColor(Color.LTGRAY);
        button7.setTextColor(Color.LTGRAY);
        button8.setTextColor(Color.LTGRAY);
        button9.setTextColor(Color.LTGRAY);
        buttonA.setTextColor(Color.LTGRAY);
        buttonB.setTextColor(Color.LTGRAY);
        buttonC.setTextColor(Color.LTGRAY);
        buttonD.setTextColor(Color.LTGRAY);
        buttonE.setTextColor(Color.LTGRAY);
        buttonF.setTextColor(Color.LTGRAY);
    }
    public void updateText(){
        String value=button1Convert.getText().toString();
        if (textView1.getText().toString().isEmpty()){
            textView2.setText("");
        }
        if (value.equals("OCT")){
            button2.setClickable(true);
            button3.setClickable(true);
            button4.setClickable(true);
            button5.setClickable(true);
            button6.setClickable(true);
            button7.setClickable(true);
            button2.setTextColor(Color.BLACK);
            button3.setTextColor(Color.BLACK);
            button4.setTextColor(Color.BLACK);
            button5.setTextColor(Color.BLACK);
            button6.setTextColor(Color.BLACK);
            button7.setTextColor(Color.BLACK);
        }
        if (value.equals("DEC")){
            button2.setClickable(true);
            button3.setClickable(true);
            button4.setClickable(true);
            button5.setClickable(true);
            button6.setClickable(true);
            button7.setClickable(true);
            button8.setClickable(true);
            button9.setClickable(true);
            button2.setTextColor(Color.BLACK);
            button3.setTextColor(Color.BLACK);
            button4.setTextColor(Color.BLACK);
            button5.setTextColor(Color.BLACK);
            button6.setTextColor(Color.BLACK);
            button7.setTextColor(Color.BLACK);
            button8.setTextColor(Color.BLACK);
            button9.setTextColor(Color.BLACK);
        }
        if (value.equals("HEX")){
            button2.setClickable(true);
            button3.setClickable(true);
            button4.setClickable(true);
            button5.setClickable(true);
            button6.setClickable(true);
            button7.setClickable(true);
            button8.setClickable(true);
            button9.setClickable(true);
            buttonA.setClickable(true);
            buttonB.setClickable(true);
            buttonC.setClickable(true);
            buttonD.setClickable(true);
            buttonE.setClickable(true);
            buttonF.setClickable(true);
            button2.setTextColor(Color.BLACK);
            button3.setTextColor(Color.BLACK);
            button4.setTextColor(Color.BLACK);
            button5.setTextColor(Color.BLACK);
            button6.setTextColor(Color.BLACK);
            button7.setTextColor(Color.BLACK);
            button8.setTextColor(Color.BLACK);
            button9.setTextColor(Color.BLACK);
            buttonA.setTextColor(Color.BLACK);
            buttonB.setTextColor(Color.BLACK);
            buttonC.setTextColor(Color.BLACK);
            buttonD.setTextColor(Color.BLACK);
            buttonE.setTextColor(Color.BLACK);
            buttonF.setTextColor(Color.BLACK);
        }


    }

    @SuppressLint("SetTextI18n")
    public void processNumber(View view){
        if (start){
            textView1.setText("");
            start=false;
        }
        String value=String.valueOf(view.getTag());
        textView1.setText(textView1.getText()+value);

    }
    public void equal(View view){
        String tagString=String.valueOf(view.getTag());
        if (tagString.equals("equal")) {
            if (button1Convert.getText().equals("BIN") && button2Convert.getText().equals("BIN")) {
                String value = textView1.getText().toString();
                textView2.setText(value);
            }
            if (button1Convert.getText().equals("BIN") && button2Convert.getText().equals("OCT")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 2);
                String oString = Integer.toOctalString(bNum);
                textView2.setText(oString);
            }
            if (button1Convert.getText().equals("BIN") && button2Convert.getText().equals("DEC")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 2);
                textView2.setText(Integer.toString(bNum));
            }
            if (button1Convert.getText().equals("BIN") && button2Convert.getText().equals("HEX")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 2);
                String oString = Integer.toHexString(bNum);
                textView2.setText(oString.toUpperCase());
            }
            if (button1Convert.getText().equals("OCT") && button2Convert.getText().equals("BIN")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 8);
                String oString = Integer.toBinaryString(bNum);
                textView2.setText(oString);
            }
            if (button1Convert.getText().equals("OCT") && button2Convert.getText().equals("OCT")) {
                String value = textView1.getText().toString();
                textView2.setText(value);
            }
            if (button1Convert.getText().equals("OCT") && button2Convert.getText().equals("DEC")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 8);
                textView2.setText(Integer.toString(bNum));
            }
            if (button1Convert.getText().equals("OCT") && button2Convert.getText().equals("HEX")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 8);
                String oString = Integer.toHexString(bNum);
                textView2.setText(oString.toUpperCase());
            }
            if (button1Convert.getText().equals("DEC") && button2Convert.getText().equals("BIN")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 10);
                String decimalString=Integer.toBinaryString(bNum);
                textView2.setText(decimalString);
            }
            if (button1Convert.getText().equals("DEC") && button2Convert.getText().equals("OCT")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 10);
                String decimalString=Integer.toOctalString(bNum);
                textView2.setText(decimalString);
            }
             if (button1Convert.getText().equals("DEC") && button2Convert.getText().equals("DEC")) {
                String value = textView1.getText().toString();
                textView2.setText(value);
            }
            if (button1Convert.getText().equals("DEC") && button2Convert.getText().equals("HEX")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 10);
                String decimalString=Integer.toHexString(bNum);
                textView2.setText(decimalString);
            }
            if (button1Convert.getText().equals("HEX") && button2Convert.getText().equals("BIN")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 16);
                String hex=Integer.toBinaryString(bNum);
                textView2.setText(hex);
            }
            if (button1Convert.getText().equals("HEX") && button2Convert.getText().equals("OCT")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 16);
                String hex=Integer.toOctalString(bNum);
                textView2.setText(hex);
            }
            if (button1Convert.getText().equals("HEX") && button2Convert.getText().equals("DEC")) {
                String value = textView1.getText().toString();
                int bNum = Integer.parseInt(value, 16);
                textView2.setText(Integer.toString(bNum));
            }
            if (button1Convert.getText().equals("HEX") && button2Convert.getText().equals("HEX")) {
                String value = textView1.getText().toString();
                textView2.setText(value);
            }



        }
    }
    public void processDel(View view){
        textView1.setText("");
        textView2.setText("");
    }
    public void processDelOne(View view){
        String value=String.valueOf(view.getTag());
        if (value.equals("DEL")){
            if (textView1.getText().toString().isEmpty()) {
                textView2.setText("");
                return;
            }
            textView1.setText(textView1.getText().subSequence(0, textView1.getText().length()-1));
            textView2.setText("");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if (id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical_converter);
        textView1=findViewById(R.id.textView2);
        textView2=findViewById(R.id.textView3);
        textView3=findViewById(R.id.textView4);
        listView1=findViewById(R.id.listView1);
        listView2=findViewById(R.id.listView2);
        gridLayout=findViewById(R.id.gridlayout);
        button1Convert=findViewById(R.id.button);
        button2Convert=findViewById(R.id.button21);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button2=findViewById(R.id.button14);
        button3=findViewById(R.id.button15);
        buttonB=findViewById(R.id.button16);
        button4=findViewById(R.id.button9);
        button5=findViewById(R.id.button10);
        button6=findViewById(R.id.button11);
        buttonC=findViewById(R.id.button12);
        button7=findViewById(R.id.button5);
        button8=findViewById(R.id.button6);
        button9=findViewById(R.id.button7);
        buttonA=findViewById(R.id.button20);
        buttonD=findViewById(R.id.button8);
        buttonF=findViewById(R.id.button3);
        buttonE=findViewById(R.id.button4);

        disableButtons();

        final ArrayList<String> convert1=new ArrayList<String>();
        convert1.add("Binary  BIN");
        convert1.add("Octal OCT");
        convert1.add("Decimal DEC");
        convert1.add("Hexadecimal HEX");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, convert1);
        listView1.setAdapter(arrayAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView1.setVisibility(View.INVISIBLE);
                button1Convert.setVisibility(View.VISIBLE);
                button2Convert.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                //textView3.setVisibility(View.VISIBLE);
                gridLayout.setVisibility(View.VISIBLE);
                if (position==0){
                    button1Convert.setText("BIN");
                }
                if (position==1){
                    button1Convert.setText("OCT");
                }
                if (position==2){
                    button1Convert.setText("DEC");
                }
                if (position==3){
                    button1Convert.setText("HEX");
                }
                updateText();
            }
        });
        ArrayList<String> convert2=new ArrayList<String>();
        convert2.add("Binary  BIN");
        convert2.add("Octal OCT");
        convert2.add("Decimal DEC");
        convert2.add("Hexadecimal HEX");
        ArrayAdapter arrayAdapter1=new ArrayAdapter(this, android.R.layout.simple_list_item_1, convert2);
        listView2.setAdapter(arrayAdapter1);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView2.setVisibility(View.INVISIBLE);
                button1Convert.setVisibility(View.VISIBLE);
                button2Convert.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
               // textView3.setVisibility(View.VISIBLE);
                gridLayout.setVisibility(View.VISIBLE);
                if (position==0){
                    button2Convert.setText("BIN");
                }
                if (position==1){
                    button2Convert.setText("OCT");
                }
                if (position==2){
                    button2Convert.setText("DEC");
                }
                if (position==3){
                    button2Convert.setText("HEX");
                }
            }
        });

    }
}