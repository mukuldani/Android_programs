package room.login.com.loginroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface UsersDao {

    @Query("Select * from users where username = :username and password = :password")
    boolean checkLogin(String username, String password);

    @Insert
    void insertUserDetails(Users... users);
}
