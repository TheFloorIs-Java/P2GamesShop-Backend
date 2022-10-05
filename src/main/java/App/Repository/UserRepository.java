package App.Repository;

import App.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface UserRepository extends JpaRepository<Users, Integer> {


=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("from Users")
    public List<Users> getAllUsers();

    @Query("from Users where user_id = :user_id")
    public Users getUserById(@Param("user_id")int user_id);
>>>>>>> origin/transactions-backend-2
}
