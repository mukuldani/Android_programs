package room.login.com.loginroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Users.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UsersDao usersDao();
}
