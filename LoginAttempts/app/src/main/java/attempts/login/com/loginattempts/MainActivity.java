package attempts.login.com.loginattempts;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button clearButton;
    private SharedPreferences sharedPreferences;
    private final static String PREF_CREDENTIALS = "Credentials";
    private final static String PREF_KEY_LOGIN_ATTEMPTS = "Login_Attempts";
    private int login_attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        clearButton = findViewById(R.id.clearButton);
        sharedPreferences = getSharedPreferences(PREF_CREDENTIALS, Context.MODE_PRIVATE);

        if(getAttemptCount()){
            login_attempts = sharedPreferences.getInt(PREF_KEY_LOGIN_ATTEMPTS, 0);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                loginButton.setEnabled(true);
            }
        });
    }

    private void login() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(username.equals("shiv@gmail.com") && password.equals("shiv123")){
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        }else{
            if(login_attempts == 3){
                Toast.makeText(this,"All attempts done", Toast.LENGTH_LONG).show();
                loginButton.setEnabled(false);
            }else{
                login_attempts += 1;
                Toast.makeText(this,"Login Failed. Attempt - "+login_attempts, Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean getAttemptCount(){
        return sharedPreferences.contains(PREF_KEY_LOGIN_ATTEMPTS);
    }
}
