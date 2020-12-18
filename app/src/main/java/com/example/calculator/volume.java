package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class volume extends AppCompatActivity {
    TextView textView;
    TextView textView1;
    ListView listView;
    TextView finalTextView;
    ListView finalListView;
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    static Button button1;
    static Button button2;

    boolean start=true;
    public void processNum(View view){
        if (start){
            textView.setText("");
            start=false;
        }
        String value=String.valueOf(view.getTag());
        textView.setText(textView.getText()+value);
    }
    public void volume1(View view){
        listView.setVisibility(View.VISIBLE);
        gridLayout2.setVisibility(View.INVISIBLE);
        gridLayout1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        finalTextView.setVisibility(View.INVISIBLE);

    }
    public void volume2(View view){
        finalListView.setVisibility(View.VISIBLE);
        gridLayout2.setVisibility(View.INVISIBLE);
        gridLayout1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        finalTextView.setVisibility(View.INVISIBLE);
    }
    public void equal(View view){

        String value=String.valueOf(view.getTag());
        if (value.equals("equal")){
            if (textView.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "enter value in text field",Toast.LENGTH_LONG ).show();
                textView1.setText("");
            }
            if (button1.getText().equals("M^3")&&button2.getText().equals("M^3")){
                String value1=textView.getText().toString();
                textView1.setText(value1);
            }
            if (button1.getText().equals("M^3")&&button2.getText().equals("DM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*1000;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("M^3")&&button2.getText().equals("CM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*1000000;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("M^3")&&button2.getText().equals("MM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*1000000000;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("DM^3")&&button2.getText().equals("M^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*0.001;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("DM^3")&&button2.getText().equals("DM^3")){
                String value1=textView.getText().toString();
                textView1.setText(value1);
            }
            if (button1.getText().equals("DM^3")&&button2.getText().equals("CM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*1000;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("DM^3")&&button2.getText().equals("MM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*1000000;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("CM^3")&&button2.getText().equals("M^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*0.000001;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("CM^3")&&button2.getText().equals("DM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*0.001;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("CM^3")&&button2.getText().equals("CM^3")){
                String value1=textView.getText().toString();
                textView1.setText(value1);
            }
            if (button1.getText().equals("CM^3")&&button2.getText().equals("MM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*1000;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("MM^3")&&button2.getText().equals("M^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*0.000000001;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("MM^3")&&button2.getText().equals("DM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*0.000001;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("MM^3")&&button2.getText().equals("CM^3")){
                String value1=textView.getText().toString();
                double value2=Double.parseDouble(value1);
                double value3=0;
                value3=value2*0.001;
                if (value1.equals("0")){
                    textView1.setText("0");
                }
                textView1.setText(String.valueOf(value3));
            }
            if (button1.getText().equals("MM^3")&&button2.getText().equals("MM^3")){
                String value1=textView.getText().toString();
                textView1.setText(value1);
            }


        }
    }
    public void clear(View view){
        textView.setText("");
    }
    public void delete(View view){
        String value=String.valueOf(view.getTag());
        if (value.equals("hello")){
            if (textView.getText().toString().isEmpty())
                return;
            textView.setText(textView.getText().subSequence(0, textView.getText().length()-1));

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
        setContentView(R.layout.activity_volume);
        textView=findViewById(R.id.textView2);
        textView1=findViewById(R.id.textView3);
        finalTextView=findViewById(R.id.textView6);
        listView=findViewById(R.id.listView2);
        finalListView=findViewById(R.id.listView);
        gridLayout1=findViewById(R.id.gridLayout1);
        gridLayout2=findViewById(R.id.gridLayout2);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button21);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("Cubic meter");
        arrayList.add("Cubic decimeter");
        arrayList.add("Cubic centimeter");
        arrayList.add("Cubic millimeter");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @SuppressLint({"ResourceType", "SetTextI18n"})
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    listView.setVisibility(View.INVISIBLE);
                    gridLayout2.setVisibility(View.VISIBLE);
                    gridLayout1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    textView1.setVisibility(View.VISIBLE);
                    //finalTextView.setVisibility(View.VISIBLE);
                    if (position == 0) {
                        button1.setText("M^3");
                    } else if (position == 1) {
                        button1.setText("DM^3");
                    } else if (position == 2) {
                        button1.setText("CM^3");
                    } else if (position == 3) {
                        button1.setText("MM^3");
                    } else {
                        button1.setText("choose");
                    }
                }
            });


        ArrayList<String> arrayList1=new ArrayList<String>();
        arrayList1.add("Cubic meter");
        arrayList1.add("Cubic decimeter");
        arrayList1.add("Cubic centimeter");
        arrayList1.add("Cubic millimeter");
        ArrayAdapter arrayAdapter1=new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList1);
        finalListView.setAdapter(arrayAdapter1);
        finalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint({"ResourceType", "SetTextI18n"})
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                finalListView.setVisibility(View.INVISIBLE);
                gridLayout2.setVisibility(View.VISIBLE);
                gridLayout1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
               // finalTextView.setVisibility(View.VISIBLE);
                if (position == 0) {
                    button2.setText("M^3");
                } else if (position == 1) {
                    button2.setText("DM^3");
                } else if (position == 2) {
                    button2.setText("CM^3");
                } else if (position == 3) {
                    button2.setText("MM^3");
                } else {
                    button2.setText("choose");
                }
            }
        });


    }

}