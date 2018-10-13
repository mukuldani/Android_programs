package converter.com.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LengthConverterActivity extends AppCompatActivity {

    private EditText metersEditText;
    private Button kilometersButton;
    private Button centimetersButton;
    private Button inchButton;
    private TextView resultkmTextView;
    private TextView resultcmTextView;
    private TextView resultinchesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        metersEditText = findViewById(R.id.metersEditText);
        kilometersButton = findViewById(R.id.kilometersButton);
        centimetersButton = findViewById(R.id.centimetersButton);
        inchButton = findViewById(R.id.inchButton);
        resultkmTextView = findViewById(R.id.resultkmTextView);
        resultcmTextView = findViewById(R.id.resultcmTextView);
        resultinchesTextView = findViewById(R.id.resultinchesTextView);

        kilometersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int meters = Integer.parseInt(metersEditText.getText().toString());
                double km = meters * 0.001;
                resultkmTextView.setVisibility(View.VISIBLE);
                resultkmTextView.setText(meters +" meters to KM = " +km);
            }
        });

        centimetersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int meters = Integer.parseInt(metersEditText.getText().toString());
                double cm = meters * 100;
                resultcmTextView.setVisibility(View.VISIBLE);
                resultcmTextView.setText(meters +" meters to CM = " +cm);
            }
        });

        inchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int meters = Integer.parseInt(metersEditText.getText().toString());
                double inches = meters * 39.3701;
                resultinchesTextView.setVisibility(View.VISIBLE);
                resultinchesTextView.setText(meters +" meters to KM = " +inches);
            }
        });

    }
}
