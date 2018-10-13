package handling.file.com.filehandling;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText fileContentEditText;
    private Button saveButton;
    private Button showContentButton;
    private TextView fileContentsTextView;
    private final static String FILE_NAME = "bvimit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileContentEditText = findViewById(R.id.fileContentEditText);
        saveButton = findViewById(R.id.saveButton);
        showContentButton = findViewById(R.id.showContentButton);
        fileContentsTextView = findViewById(R.id.fileContentsTextView);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    saveContent();
                    Toast.makeText(MainActivity.this, "User contents written to the file", Toast.LENGTH_SHORT).show();
                }  catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        showContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    displayFileContent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void displayFileContent() throws IOException {
        FileInputStream fileInputStream = openFileInput(FILE_NAME);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        fileContentsTextView.setVisibility(View.VISIBLE);
        fileContentsTextView.setText(bufferedReader.readLine());
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
    }

    private void saveContent() throws IOException {
        String userContent = fileContentEditText.getText().toString();
        FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_APPEND | Context.MODE_PRIVATE);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(userContent);
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

}
