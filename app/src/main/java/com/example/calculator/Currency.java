package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;

public class Currency extends AppCompatActivity {
    ConnectionDetector mConnectionDetector;
    TextView textView;
    TextView textView1;
    DownloadTask downloadTask;
    ListView listView;
    TextView finalTextView;
    ListView finalListView;
    GridLayout gridLayout1;
    GridLayout gridLayout2;
    ProgressDialog progressDialog;
    static Button button1;
    static Button button2;
    boolean connected=false;
    boolean start=true;
    public void processNum(View view){
        if (start){
            textView1.setText("");
            textView.setText("");
            start=false;
        }
        String value=String.valueOf(view.getTag());
        textView.setText(textView.getText()+value);

        textView1.setText("");
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
    @SuppressLint("SetTextI18n")
    public void equal(View view) throws UnsupportedEncodingException {
        if (textView.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter the Value", Toast.LENGTH_LONG).show();
            finalTextView.setText("");
        }else {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert inputMethodManager != null;
            inputMethodManager.hideSoftInputFromWindow(button1.getWindowToken(), 0);

            String encoder = URLEncoder.encode(button1.getText().toString(), "UTF-8");
            inputMethodManager.hideSoftInputFromWindow(button2.getWindowToken(), 0);

            String encoder2 = URLEncoder.encode(button2.getText().toString(), "UTF-8");
            downloadTask = new DownloadTask();
            downloadTask.execute("https://api.exchangeratesapi.io/api/latest?base=" + encoder + "&symbols=" + encoder2);
        }
    }
    public void clear(View view){
        textView.setText("");
        textView1.setText("");
    }
    public void delete(View view){
        String value=String.valueOf(view.getTag());
        if (value.equals("hello")){
            if (textView.getText().toString().isEmpty())
                return;
            textView.setText(textView.getText().subSequence(0, textView.getText().length()-1));
        }
        textView1.setText("");
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
        setContentView(R.layout.activity_currensy);
        textView=findViewById(R.id.textView2);
        textView1=findViewById(R.id.textView3);
        finalTextView=findViewById(R.id.textView6);
        listView=findViewById(R.id.listView2);
        finalListView=findViewById(R.id.listView);
        gridLayout1=findViewById(R.id.gridLayout1);
        gridLayout2=findViewById(R.id.gridLayout2);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button21);




        mConnectionDetector = new ConnectionDetector(getApplicationContext());
        if (!mConnectionDetector.isConnectingToInternet()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("No Internet Connection!!!")
                    .setMessage("Close the window and Connect to network otherwise it will not work")
                    .setPositiveButton("close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("continue",  new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_LONG).show();
                        }
                    }).show();

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<String> currency1=new ArrayList<String>();
        currency1.add("United States Dollar USD");
        currency1.add("Great Britain Pound GBP");
        currency1.add("Hong Kong Dollar HKD");
        currency1.add("Indonesian Rupiah IDR");
        currency1.add("Israeli Shekel ILS");
        currency1.add("Danish Krone DKK");
        currency1.add("Indian Rupee INR");
        currency1.add("Swiss Franc CHF");
        currency1.add("Mexican Peso MXN");
        currency1.add("Czech Koruna CZK");
        currency1.add("Singapore Dollar SGD");
        currency1.add("Thai Bath THB");
        currency1.add("Croatian Kuna HRK");
        currency1.add("Malaysian Ringgit MYR");
        currency1.add("Norwegian Krone NOK");
        currency1.add("Chinese Yuan CNY");
        currency1.add("Bulgarian Lev BGN");
        currency1.add("Philippine Peso PHP");
        currency1.add("Swedish Dollar SEK");
        currency1.add("Poland Zloty PLN");
        currency1.add("South African Routh ZAR");
        currency1.add("Canadian Dollar CAD");
        currency1.add("Icelandic Krona ISK");
        currency1.add("Brazilian Real BRL");
        currency1.add("Romanian Leu RON");
        currency1.add("New Zealand Dollar NZD");
        currency1.add("Turkish Lira TRY");
        currency1.add("Japan Yuan JPY");
        currency1.add("Russian Ruble RUB");
        currency1.add("South Korean Won KRW");
        currency1.add("Hungarian Forint HUF");
        currency1.add("Australian Dollar AUD");
        final ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, currency1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.setVisibility(View.INVISIBLE);
                gridLayout2.setVisibility(View.VISIBLE);
                gridLayout1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);

           //     finalTextView.setVisibility(View.VISIBLE);
                String string=currency1.get(position);
                int length=string.length();
                String last_char=string.substring(string.length()-3);
                button1.setText(last_char);
            }
        });
        final ArrayList<String> currency2=new ArrayList<String>();
        currency2.add("United States Dollar USD");
        currency2.add("Great Britain Pound GBP");
        currency2.add("Hong Kong Dollar HKD");
        currency2.add("Indonesian Rupiah IDR");
        currency2.add("Israeli Shekel ILS");
        currency2.add("Danish Krone DKK");
        currency2.add("Indian Rupee INR");
        currency2.add("Swiss Franc CHF");
        currency2.add("Mexican Peso MXN");
        currency2.add("Czech Koruna CZK");
        currency2.add("Singapore Dollar SGD");
        currency2.add("Thai Bath THB");
        currency2.add("Croatian Kuna HRK");
        currency2.add("Malaysian Ringgit MYR");
        currency2.add("Norwegian Krone NOK");
        currency2.add("Chinese Yuan CNY");
        currency2.add("Bulgarian Lev BGN");
        currency2.add("Philippine Peso PHP");
        currency2.add("Swedish Dollar SEK");
        currency2.add("Poland Zloty PLN");
        currency2.add("South African Routh ZAR");
        currency2.add("Canadian Dollar CAD");
        currency2.add("Icelandic Krona ISK");
        currency2.add("Brazilian Real BRL");
        currency2.add("Romanian Leu RON");
        currency2.add("New Zealand Dollar NZD");
        currency2.add("Turkish Lira TRY");
        currency2.add("Japan Yuan JPY");
        currency2.add("Russian Ruble RUB");
        currency2.add("South Korean Won KRW");
        currency2.add("Hungarian Forint HUF");
        currency2.add("Australian Dollar AUD");
        final ArrayAdapter arrayAdapter2=new ArrayAdapter(this, android.R.layout.simple_list_item_1, currency2);
        finalListView.setAdapter(arrayAdapter2);
        finalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView1.setText("");
                finalListView.setVisibility(View.INVISIBLE);
                gridLayout2.setVisibility(View.VISIBLE);
                gridLayout1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                String string=currency2.get(position);
                int length=string.length();
                String last_char=string.substring(string.length()-3);
                button2.setText(last_char);
            }
        });
    }


    public class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Currency.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(true);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);

            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                    downloadTask.cancel(true);
                    Toast.makeText(getApplicationContext(), "Asynctask is stropped", Toast.LENGTH_LONG).show();
                    downloadTask = new DownloadTask();
                }
            });
            progressDialog.show();

        }
        @SuppressLint("ShowToast")
        @Override
        protected String doInBackground(String... urls) {


                String result = "";
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                        url = new URL(urls[0]);
                        urlConnection = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = urlConnection.getInputStream();
                        InputStreamReader reader = new InputStreamReader(inputStream);

                        int data = reader.read();
                        while (data != -1) {
                            char current = (char) data;
                            result += current;
                            data = reader.read();
                        }


                    return result;
                } catch (MalformedURLException e) {
                    Toast.makeText(getApplicationContext(), "Could't find any data", Toast.LENGTH_LONG);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result == null) {
                new android.app.AlertDialog.Builder(Currency.this)
                        .setMessage("Sorry, we couldn't find any weather data. Please, try again.")
                        .setCancelable(false)
                        .setPositiveButton("Ok", null)
                        .show();
                progressDialog.dismiss();
            }else {
            try {
                JSONObject jsonObject = new JSONObject(result);
                String currencyInfo = jsonObject.getString("rates");
                final String dates = jsonObject.getString("date");
                JSONTokener jsonTokener = new JSONTokener(currencyInfo);
                JSONObject jsonObject1 = new JSONObject(jsonTokener);
                Log.i("value", " " + jsonObject1.get(button2.getText().toString()));
                String string = String.valueOf(jsonObject1.get(button2.getText().toString()));
                double valueOne = Double.parseDouble(textView.getText().toString());
                double finalCurrency = valueOne * Double.parseDouble(string);
                textView1.setText(String.valueOf(finalCurrency));

                    finalTextView.setText("        Exchange rates are provided by \n" +
                            "European Central Bank date of " + dates);
                    finalTextView.setVisibility(View.VISIBLE);


                progressDialog.dismiss();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        }

    }
    public class ConnectionDetector {

        private Context mContext;

        public ConnectionDetector(Context context){
            this.mContext = context;
        }
        public boolean isConnectingToInternet(){
            ConnectivityManager cm = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            if(cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                return true;
            }

            return false;

        }
    }
}