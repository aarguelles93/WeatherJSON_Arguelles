package com.uninorte.andresarguelles.weatherjson_arguelles;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends ActionBarActivity {

    public String currentAPI;
    public String forecastAPI;

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentAPI = "api.openweathermap.org/data/2.5/weather?q=London,uk";
        forecastAPI = "api.openweathermap.org/data/2.5/forecast/daily?q=Barranquilla,CO&units=mentric&cnt=6&mode=json";

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
    }

    public void httpRequester() {
        String response;

        URL urlCurrent = null;
        HttpURLConnection urlConnection;

        try {
            urlCurrent = new URL(currentAPI);
            URL urlForecast = new URL (forecastAPI);
            urlConnection = (HttpURLConnection) urlCurrent.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            response = convertStreamToString(in);
            textView.setText(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            //
        }
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
