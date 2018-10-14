package parse.json.com.jsonparse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView employeeName1TextView;
    private TextView employeeCompanies1TextView;
    private TextView employeeLocation1TextView;
    private TextView employeeAge1TextView;

    private TextView employeeName2TextView;
    private TextView employeeCompanies2TextView;
    private TextView employeeLocation2TextView;
    private TextView employeeAge2TextView;


    public String getFileContents() throws IOException {
        InputStream stream = getAssets().open("employees.json");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuilder.append(temp);
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeName1TextView = findViewById(R.id.employeeName1TextView);
        employeeCompanies1TextView = findViewById(R.id.employeeCompanies1TextView);
        employeeLocation1TextView = findViewById(R.id.employeeLocation1TextView);
        employeeAge1TextView = findViewById(R.id.employeeAge1TextView);
        employeeName2TextView = findViewById(R.id.employeeName1TextView);
        employeeCompanies2TextView = findViewById(R.id.employeeCompanies2TextView);
        employeeLocation2TextView = findViewById(R.id.employeeLocation2TextView);
        employeeAge2TextView = findViewById(R.id.employeeAge2TextView);

        try {
            String jsonContent = getFileContents();
            getContents(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }

    private void getContents(String jsonContent) throws JSONException {
        JSONObject root = new JSONObject(jsonContent);
        JSONArray employees = root.getJSONArray("employees");
        if (employees != null && employees.length() > 0) {
            //For Fist employee
            JSONObject emp1Details = employees.getJSONObject(0);
            String emp1Name  = emp1Details.getString("name");
            employeeName1TextView.setText("Emp Name  : " +emp1Name);
            String emp1Age  = emp1Details.getString("age");
            employeeAge1TextView.setText("Emp Age  : " +emp1Age);
            String emp1Location = emp1Details.getString("location");
            employeeLocation1TextView.setText("Emp Location  : " +emp1Location);
            JSONArray emp1CompanyArray = emp1Details.getJSONArray("companies");
            //For emp1 company details
            JSONObject emp1CompanyDetals1 = emp1CompanyArray.getJSONObject(0);
            String emp1CompanyName1 = emp1CompanyDetals1.getString("name");
            JSONObject emp1CompanyDetals2 = emp1CompanyArray.getJSONObject(1);
            String emp1CompanyName2 = emp1CompanyDetals2.getString("name");
            employeeCompanies1TextView.setText("Emp Companies  : " +emp1CompanyName1+ " , " +emp1CompanyName2);

            //For Second employee
            JSONObject emp2Details = employees.getJSONObject(1);
            String emp2Name  = emp1Details.getString("name");
            employeeName2TextView.setText("Emp Name  : " +emp2Name);
            String emp2Age  = emp1Details.getString("age");
            employeeAge2TextView.setText("Emp Age  : " +emp2Age);
            String emp2Location = emp1Details.getString("location");
            employeeLocation2TextView.setText("Emp Location  : " +emp2Location);
            JSONArray emp2CompanyArray = emp1Details.getJSONArray("companies");
            //For emp2 company details
            JSONObject emp2CompanyDetals1 = emp1CompanyArray.getJSONObject(0);
            String emp2CompanyName1 = emp1CompanyDetals1.getString("name");
            JSONObject emp2CompanyDetals2 = emp1CompanyArray.getJSONObject(1);
            String emp2CompanyName2 = emp1CompanyDetals2.getString("name");
            employeeCompanies2TextView.setText("Emp Companies  : " +emp2CompanyName1+ " , " +emp2CompanyName2);
        }

    }
}
