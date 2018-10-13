package savedetails.login.com.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button clearButton;
    private CheckBox remmbermeCheckBox;
    private SharedPreferences sharedPreferences;
    private final static String PREF_CREDENTIALS = "Credentials";
    private final static String PREF_KEY_USERNAME = "Username";
    private final static String PREF_KEY_PASSWORD = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        clearButton = findViewById(R.id.clearButton);
        remmbermeCheckBox = findViewById(R.id.remmbermeCheckBox);
        sharedPreferences = getSharedPreferences(PREF_CREDENTIALS, Context.MODE_PRIVATE);

        if(isAlreadyLogedIn()){
            String username = sharedPreferences.getString(PREF_KEY_USERNAME,"");
            String password = sharedPreferences.getString(PREF_KEY_PASSWORD,"");
            usernameEditText.setText(username);
            passwordEditText.setText(password);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(username.equals("shiv@gmail.com") && password.equals("shiv123")){
                    if(remmbermeCheckBox.isChecked()){
                        sharedPreferences.edit().putString(PREF_KEY_USERNAME,username).apply();
                        sharedPreferences.edit().putString(PREF_KEY_PASSWORD,password).apply();
                    }
                    Toast.makeText(MainActivity.this,"Welcome",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                usernameEditText.setText("");
                passwordEditText.setText("");
            }
        });

    }

    private boolean isAlreadyLogedIn() {
        return sharedPreferences.contains(PREF_KEY_USERNAME) && sharedPreferences.contains(PREF_KEY_PASSWORD);
    }
}
