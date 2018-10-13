package room.login.com.loginroom;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
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
    private Button signupButton;
    private Button loginButton;
    private UserDataBase userDataBase;
    private SharedPreferences sharedPreferences;
    private final static String PREF_CREDENTIALS = "Credentials";
    private final static String PREF_KEY_USERNAME = "Username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDataBase = Room.databaseBuilder(this,UserDataBase.class,"Users_db").allowMainThreadQueries().build();

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signupButton = findViewById(R.id.signupButton);
        loginButton = findViewById(R.id.loginButton);
        sharedPreferences = getSharedPreferences(PREF_CREDENTIALS, Context.MODE_PRIVATE);
        if(isAlreadySignedup()){
            signupButton.setEnabled(false);
            loginButton.setEnabled(true);
        }
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users = new Users();
                users.setUsername(usernameEditText.getText().toString());
                users.setPassword(passwordEditText.getText().toString());
                userDataBase.usersDao().insertUserDetails(users);
                sharedPreferences.edit().putString(PREF_KEY_USERNAME,usernameEditText.getText().toString()).apply();
                Toast.makeText(MainActivity.this,"user Details saved", Toast.LENGTH_LONG).show();

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                boolean checkUserDetails = userDataBase.usersDao().checkLogin(username,password);
                if(checkUserDetails){
                    Toast.makeText(MainActivity.this,"Welcome",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Please Check the credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean isAlreadySignedup() {
        return sharedPreferences.contains(PREF_KEY_USERNAME);
    }
}
