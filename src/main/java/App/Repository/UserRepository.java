package App.Repository;

import App.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {


}
//This repository automatically generates many of the queries that may need to be called by the API
//such as "select all from table," specific queries can also be constructed here.
