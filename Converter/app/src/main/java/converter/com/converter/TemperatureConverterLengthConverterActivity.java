package converter.com.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemperatureConverterLengthConverterActivity extends AppCompatActivity {

    private EditText celciusEditText;
    private Button fahrenheitButton;
    private Button kelvinButton;
    private TextView resultfahrenheitTextView;
    private TextView resultkelvinTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        celciusEditText = findViewById(R.id.celciusEditText);
        fahrenheitButton = findViewById(R.id.fahrenheitButton);
        kelvinButton = findViewById(R.id.kelvinButton);
        resultfahrenheitTextView = findViewById(R.id.resultfahrenheitTextView);
        resultkelvinTextView = findViewById(R.id.resultkelvinTextView);

        fahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int celcius = Integer.parseInt(celciusEditText.getText().toString());
                double fah = celcius * 32;
                resultfahrenheitTextView.setVisibility(View.VISIBLE);
                resultfahrenheitTextView.setText(celcius +" celcius to fahrenheit = " +fah);
            }
        });

        kelvinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int celcius = Integer.parseInt(celciusEditText.getText().toString());
                double kelvin = celcius * 273.15;
                resultkelvinTextView.setVisibility(View.VISIBLE);
                resultkelvinTextView.setText(celcius +" celcius to kelvin = " +kelvin);
            }
        });

    }
}
