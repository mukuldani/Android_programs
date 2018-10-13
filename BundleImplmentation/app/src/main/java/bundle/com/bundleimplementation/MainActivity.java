package bundle.com.bundleimplementation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton genderButton;
    private EditText salaryEditText;
    private CheckBox angularCheckBox;
    private CheckBox bootstrapCheckBox;
    private CheckBox nodeJsCheckBox;
    private CheckBox androidCheckBox;
    private RatingBar ratingBar;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        salaryEditText = findViewById(R.id.salaryEditText);
        angularCheckBox = findViewById(R.id.angularCheckBox);
        bootstrapCheckBox = findViewById(R.id.bootstrapCheckBox);
        nodeJsCheckBox = findViewById(R.id.nodeJsCheckBox);
        androidCheckBox = findViewById(R.id.androidCheckBox);
        ratingBar = findViewById(R.id.ratingBar);
        submitButton = findViewById(R.id.submitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                int genderId = genderRadioGroup.getCheckedRadioButtonId();
                genderButton = findViewById(genderId);
                String gender = genderButton.getText().toString();
                int salary = Integer.parseInt(salaryEditText.getText().toString());
                double tax = 0;
                if(salary > 20000 && salary < 50000){
                    tax = 0.12 * salary;
                }else if(salary > 50001){
                    tax = 0.18 * salary;
                }


                float rating = ratingBar.getRating();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putString("Gender", gender);
                bundle.putInt("Salary",salary);
                bundle.putDouble("Tax",tax);

                if(angularCheckBox.isChecked()){
                    bundle.putString("AngularJS",angularCheckBox.getText().toString());
                }
                if(bootstrapCheckBox.isChecked()){
                    bundle.putString("Bootstrap","Bootstrap");
                }
                if(nodeJsCheckBox.isChecked()){
                    bundle.putString("NodeJS","Node JS");
                }
                if(androidCheckBox.isChecked()){
                    bundle.putString("Android","Android");
                }

                bundle.putFloat("Rating",rating);

                Intent intent = new Intent(MainActivity.this,ShowDetails.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }
}
