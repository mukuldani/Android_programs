package list.todo.com.todolist;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText taskEditText;
    private Button roomInsertButton;
    private ToDoListDatabase toDoListDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        toDoListDatabase = Room.databaseBuilder(this, ToDoListDatabase.class,"ToDoList_db")
                            .allowMainThreadQueries().build();

        titleEditText = findViewById(R.id.titleEditText);
        taskEditText = findViewById(R.id.taskEditText);
        roomInsertButton = findViewById(R.id.roomInsertButton);

        roomInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoList toDoList = new ToDoList();
                toDoList.setTitle(titleEditText.getText().toString());
                toDoList.setTask(taskEditText.getText().toString());
                toDoListDatabase.toDoListDao().insertToDoList(toDoList);
                Toast.makeText(InsertActivity.this,"Record Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
