package App.Model;


import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//These annotations auto generate certain constructors and methods on runtime (like getters and setters)
//as well as declaring this model as a table in the connected database.
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generate user id
    @Column
    int id;
    @Column
    String username;
    @Column
    String password;
    @Column
    private int userRole = 0;

    //public boolean admin;
}
//This is the model for Users that defines the traits that users have in the database. Each of these values is
//connected to a column in the database.
