package converter.com.converter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button lengthConverterButton;
    private Button weightConverterButton;
    private Button currencyConverterButton;
    private Button temperatureConverterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthConverterButton = findViewById(R.id.lengthConverterButton);
        weightConverterButton = findViewById(R.id.weightConverterButton);
        currencyConverterButton = findViewById(R.id.currencyConverterButton);
        temperatureConverterButton = findViewById(R.id.temperatureConverterButton);

        lengthConverterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LengthConverterActivity.class);
                startActivity(intent);
            }
        });

        weightConverterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WeightConverterLengthConverterActivity.class);
                startActivity(intent);
            }
        });

        currencyConverterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CurrencyConverterActivity.class);
                startActivity(intent);
            }
        });

        temperatureConverterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TemperatureConverterLengthConverterActivity.class);
                startActivity(intent);
            }
        });
    }
}
