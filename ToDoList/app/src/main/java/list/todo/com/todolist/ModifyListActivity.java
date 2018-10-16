package list.todo.com.todolist;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ModifyListActivity extends AppCompatActivity {

    private TextView titleEditText;
    private TextView taskEditText;
    private Button updateTaskButton;
    private Button deleteTaskButton;
    private ToDoListDatabase toDoListDatabase;
    private List<ToDoList> toDoLists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        titleEditText = findViewById(R.id.titleEditText);
        taskEditText = findViewById(R.id.taskEditText);
        updateTaskButton = findViewById(R.id.updateTaskButton);
        deleteTaskButton = findViewById(R.id.deleteTaskButton);

        toDoListDatabase = Room.databaseBuilder(this, ToDoListDatabase.class, "ToDoList_db")
                .allowMainThreadQueries().build();


        updateTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoList toDoList = toDoListDatabase.toDoListDao().getToDoListByTitle(titleEditText.getText().toString());

                if (toDoList != null) {
                    toDoList.setTask(taskEditText.getText().toString());
                    toDoListDatabase.toDoListDao().updateToDoList(toDoList);
                    Toast.makeText(ModifyListActivity.this, "Record Modified", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ModifyListActivity.this, "Record not found!", Toast.LENGTH_LONG).show();
                }
            }
        });

        deleteTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoList toDoList = toDoListDatabase.toDoListDao().getToDoListByTitle(titleEditText.getText().toString());

                if (toDoList != null) {
                    toDoListDatabase.toDoListDao().deleteToDoList(toDoList);
                    Toast.makeText(ModifyListActivity.this, "Record Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ModifyListActivity.this, "Record not found!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
