package list.todo.com.todolist;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class ViewListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ToDoListDatabase toDoListDatabase;
    private List<ToDoList> toDoLists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        recyclerView = findViewById(R.id.viewToDoListRecyclerView);
        toDoListDatabase = Room.databaseBuilder(this, ToDoListDatabase.class, "ToDoList_db")
                .allowMainThreadQueries().build();

        toDoLists = toDoListDatabase.toDoListDao().getAllToDoList();

        if (toDoLists != null && toDoLists.size() > 0) {
            ToDoListAdapter toDoListAdapter = new ToDoListAdapter(toDoLists);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewListActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(toDoListAdapter);

        } else {
            Toast.makeText(ViewListActivity.this, "No data found", Toast.LENGTH_LONG).show();
        }

    }
}
