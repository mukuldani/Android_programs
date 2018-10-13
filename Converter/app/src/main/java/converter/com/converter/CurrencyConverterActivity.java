package converter.com.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrencyConverterActivity extends AppCompatActivity{


    private EditText indianEditText;
    private Button usdButton;
    private Button poundButton;
    private Button yenButton;
    private TextView resultusdTextView;
    private TextView resultpoundTextView;
    private TextView resultyenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        indianEditText = findViewById(R.id.indianEditText);
        usdButton = findViewById(R.id.usdButton);
        poundButton = findViewById(R.id.poundButton);
        yenButton = findViewById(R.id.yenButton);
        resultusdTextView = findViewById(R.id.resultusdTextView);
        resultpoundTextView = findViewById(R.id.resultpoundTextView);
        resultyenTextView = findViewById(R.id.resultyenTextView);

        usdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rs = Integer.parseInt(indianEditText.getText().toString());
                double usd = rs * 0.015;
                resultusdTextView.setVisibility(View.VISIBLE);
                resultusdTextView.setText(rs +" RS to USD = " +usd);
            }
        });

        poundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rs = Integer.parseInt(indianEditText.getText().toString());
                double pound = rs * 0.011;
                resultpoundTextView.setVisibility(View.VISIBLE);
                resultpoundTextView.setText(rs +" RS to Pound = " +pound);
            }
        });

        yenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rs = Integer.parseInt(indianEditText.getText().toString());
                double yen = rs * 1.61;
                resultyenTextView.setVisibility(View.VISIBLE);
                resultyenTextView.setText(rs +" RS to Yen = " +yen);
            }
        });

    }
}
