package contact.com.contact;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ViewContactActivity extends AppCompatActivity {

    private ContactDatabase contactDatabase;
    private RecyclerView recyclerView;
    private List<Contact> contactList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        recyclerView = findViewById(R.id.viewContacts);
        contactDatabase = Room.databaseBuilder(this,ContactDatabase.class,"Contact_db").allowMainThreadQueries().build();
        contactList = contactDatabase.contactDao().getAllConatcts();
        if(contactList != null && contactList.size() > 0){
            ContactAdapter contactAdapter = new ContactAdapter(contactList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewContactActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(contactAdapter);
        }
    }
}
