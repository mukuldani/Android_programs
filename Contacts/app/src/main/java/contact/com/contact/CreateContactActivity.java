package contact.com.contact;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateContactActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText mobileNumEditText;
    private Button insertButton;
    private ContactDatabase contactDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createcontact);

        nameEditText = findViewById(R.id.nameEditText);
        mobileNumEditText = findViewById(R.id.mobileNumEditText);
        insertButton = findViewById(R.id.insertButton);

        contactDatabase = Room.databaseBuilder(this,ContactDatabase.class,"Contact_db").allowMainThreadQueries().build();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                contact.setName(nameEditText.getText().toString());
                contact.setMobile_number(Long.parseLong(mobileNumEditText.getText().toString()));
                contactDatabase.contactDao().insertContact(contact);
                Toast.makeText(CreateContactActivity.this,"Record Inserted",Toast.LENGTH_LONG).show();
            }
        });

    }
}
