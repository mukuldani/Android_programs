package list.todo.com.todolist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ToDoListDao {

    @Query("Select * from todolist")
    List<ToDoList> getAllToDoList();

    @Query("Select * from todolist where title = :title")
    ToDoList getToDoListByTitle(String title);

    @Insert
    void insertToDoList(ToDoList... toDoLists);

    @Update
    void updateToDoList(ToDoList toDoList);

    @Delete
    void deleteToDoList(ToDoList toDoList);

}
