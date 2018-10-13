package bundle.com.bundleimplementation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowDetails extends AppCompatActivity {

    private TextView nameTextView;
    private TextView genderTextView;
    private TextView salaryTextView;
    private TextView taxTextView;
    private TextView ratingTextView;
    private TextView angularTextView;
    private TextView bootstrapTextView;
    private TextView nodejsTextView;
    private TextView androidTextView;

    private ArrayList<String> languagesKnownList = new ArrayList<String>();
    private String languages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        nameTextView = findViewById(R.id.nameTextView);
        genderTextView = findViewById(R.id.genderTextView);
        salaryTextView = findViewById(R.id.salaryTextView);
        taxTextView = findViewById(R.id.taxTextView);
        ratingTextView = findViewById(R.id.ratingTextView);
        angularTextView = findViewById(R.id.angularTextView);
        bootstrapTextView = findViewById(R.id.bootstrapTextView);
        nodejsTextView = findViewById(R.id.nodejsTextView);
        androidTextView = findViewById(R.id.androidTextView);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String name = bundle.getString("Name");
        String gender = bundle.getString("Gender");
        int salary = bundle.getInt("Salary");
        double tax = bundle.getDouble("Tax");
        float rating = bundle.getFloat("Rating");

        nameTextView.setText("Name : " +name);
        genderTextView.setText("Gender : " +gender);
        salaryTextView.setText("Salary : "+salary);
        taxTextView.setText("Tax : "+tax);
        ratingTextView.setText("Ratings : "+rating);

        String angular = bundle.getString("AngularJS");
        String bootstrap = bundle.getString("Bootstrap");
        String nodejs = bundle.getString("NodeJS");
        String android = bundle.getString("Android");

        if(angular != null){
            angularTextView.setVisibility(View.VISIBLE);
            angularTextView.setText(angular);
        }
        if(bootstrap != null){
            bootstrapTextView.setVisibility(View.VISIBLE);
            bootstrapTextView.setText(bootstrap);
        }
        if(nodejs != null){
            nodejsTextView.setVisibility(View.VISIBLE);
            nodejsTextView.setText(nodejs);
        }
        if(android != null){
            androidTextView.setVisibility(View.VISIBLE);
            androidTextView.setText(android);
        }
    }
}
