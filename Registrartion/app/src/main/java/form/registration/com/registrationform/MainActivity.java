package form.registration.com.registrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText ageEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton radioButton;
    private Button submitButton;
    private Button clearButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        submitButton = findViewById(R.id.submitButton);
        clearButton = findViewById(R.id.clearButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                int genderId = genderRadioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(genderId);
                String gender = radioButton.getText().toString();
                Toast.makeText(MainActivity.this,"Name : " +name + "\nAge : " +age+
                        "\nEmail ID : "+email+ "\nPhone : "+phone+"\n Gender : "+gender, Toast.LENGTH_LONG).show();
                clearText();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearText();
            }
        });

    }

    private void clearText() {
        nameEditText.setText("");
        ageEditText.setText("");
        emailEditText.setText("");
        phoneEditText.setText("");
        genderRadioGroup.clearCheck();
    }


}
