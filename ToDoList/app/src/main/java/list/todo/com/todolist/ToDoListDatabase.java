package list.todo.com.todolist;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ToDoList.class}, version = 1)
public abstract class ToDoListDatabase extends RoomDatabase {
    public abstract ToDoListDao toDoListDao();
}
