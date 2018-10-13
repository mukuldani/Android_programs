package converter.com.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeightConverterLengthConverterActivity extends AppCompatActivity {
    private EditText gramsEditText;
    private Button kgButton;
    private Button poundButton;
    private Button tonneButton;
    private TextView resultkgTextView;
    private TextView resultpoundTextView;
    private TextView resultTonneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        gramsEditText = findViewById(R.id.gramsEditText);
        kgButton = findViewById(R.id.kgButton);
        poundButton = findViewById(R.id.poundButton);
        tonneButton = findViewById(R.id.tonneButton);
        resultkgTextView = findViewById(R.id.resultkgTextView);
        resultpoundTextView = findViewById(R.id.resultpoundTextView);
        resultTonneTextView = findViewById(R.id.resultTonneTextView);

        kgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int grams = Integer.parseInt(gramsEditText.getText().toString());
                double kg = grams * 0.001;
                resultkgTextView.setVisibility(View.VISIBLE);
                resultkgTextView.setText(grams +" grams to KM = " +kg);
            }
        });

        poundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int grams = Integer.parseInt(gramsEditText.getText().toString());
                double pound = grams * 0.00220462;
                resultpoundTextView.setVisibility(View.VISIBLE);
                resultpoundTextView.setText(grams +" grams to pound = " +pound);
            }
        });

        tonneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int grams = Integer.parseInt(gramsEditText.getText().toString());
                double tonne = grams * 9.9999;
                resultTonneTextView.setVisibility(View.VISIBLE);
                resultTonneTextView.setText(grams +" grams to Ounce = " +tonne);
            }
        });

    }
}
