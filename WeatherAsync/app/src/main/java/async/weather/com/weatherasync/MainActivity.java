package async.weather.com.weatherasync;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button fetchWeatherDataButton;
    private TextView cityNameTextView;
    private TextView weatherTextView;
    private TextView weatherDescriptionTextView;
    private TextView temperatureTextView;
    private TextView pressureTextView;
    private TextView humidityTextView;
    private TextView visibilityTextView;
    private TextView windSpeedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        fetchWeatherDataButton = findViewById(R.id.fetchWeatherDataButton);
        cityNameTextView = findViewById(R.id.cityNameTextView);
        weatherTextView = findViewById(R.id.weatherTextView);
        weatherDescriptionTextView = findViewById(R.id.weatherDescriptionTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        pressureTextView = findViewById(R.id.pressureTextView);
        humidityTextView = findViewById(R.id.humidityTextView);
        visibilityTextView = findViewById(R.id.visibilityTextView);
        windSpeedTextView = findViewById(R.id.windSpeedTextView);

        fetchWeatherDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchWeatherResponse();
            }
        });
    }

    private void fetchWeatherResponse() {
        FetctWeatherDataTask fetch = new FetctWeatherDataTask();
        fetch.execute("http://www.json-generator.com/api/json/get/bHWddvthgy?intent=2");
    }

    private class FetctWeatherDataTask extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            try {
                URL server_url = new URL(url);
                HttpURLConnection connection = (HttpURLConnection)server_url.openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK){
                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String temp;
                    while((temp = bufferedReader.readLine()) != null){
                        stringBuilder.append(temp);
                        stringBuilder.append(System.getProperty("line.separator"));
                    }
                    return stringBuilder.toString();
                }else{
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.VISIBLE);
            try {
                parseWeatherContent(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseWeatherContent(String s) throws JSONException {
        JSONObject root = new JSONObject(s);
        String cityName = root.getString("name");
        cityNameTextView.setText("City : "+cityName);

        JSONArray weather = root.getJSONArray("weather");
        if(weather != null && weather.length() > 0){
            JSONObject weatherObj1 = weather.getJSONObject(0);
            String mainWeather = weatherObj1.getString("main");
            weatherTextView.setText("Weather : " +mainWeather);
            String weatherDesc = weatherObj1.getString("description");
            weatherDescriptionTextView.setText("Description : "+weatherDesc);
        }
        JSONObject weatherParams = root.getJSONObject("main");
        String temperature = weatherParams.getString("temp");
        temperatureTextView.setText("Temperature : "+temperature);
        String pressure = weatherParams.getString("pressure");
        temperatureTextView.setText("Pressure : " +pressure);
        String humidity = weatherParams.getString("humidity");
        humidityTextView.setText("Humidity : "+humidity);
        String visibility = root.getString("visibility");
        visibilityTextView.setText("Visibility : "+visibility);

        JSONObject windParams = root.getJSONObject("wind");
        String windSpeed = windParams.getString("speed");
        windSpeedTextView.setText("Wind Speed : "+windSpeed);
    }
}
