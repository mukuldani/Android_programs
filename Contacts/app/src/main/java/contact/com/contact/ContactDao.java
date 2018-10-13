package contact.com.contact;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("Select * from conatcts")
    List<Contact> getAllConatcts();

    @Query("Select * from conatcts where mobile_number = :num")
    Contact getToDoListByTitle(Long num);

    @Insert
    void insertContact(Contact... contacts);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

}
