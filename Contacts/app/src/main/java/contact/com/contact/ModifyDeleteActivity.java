package contact.com.contact;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyDeleteActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mobileNumEditText;
    private Button updateButton;
    private Button deleteButton;
    private ContactDatabase contactDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        nameEditText = findViewById(R.id.nameEditText);
        mobileNumEditText = findViewById(R.id.mobileNumEditText);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        contactDatabase = Room.databaseBuilder(this, ContactDatabase.class,"Contact_db").allowMainThreadQueries().build();


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                contact.setName(nameEditText.getText().toString());
                contact.setMobile_number(Long.parseLong(mobileNumEditText.getText().toString()));
                contactDatabase.contactDao().updateContact(contact);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                contact.setName(nameEditText.getText().toString());
                contact.setMobile_number(Long.parseLong(mobileNumEditText.getText().toString()));
                contactDatabase.contactDao().deleteContact(contact);
            }
        });

    }
}
