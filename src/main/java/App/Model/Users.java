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
    /**
     *  represents the primary key for the user table in the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generate user id
    @Column
    int id;
    /**
     * represents a user's username
     */
    @Column
    String username;
    /**
     * represents a password that a user creates
     */
    @Column
    String password;
    /**
     * defines a user's privileges. it defaults to 0, but if it is set to 1, then a user gains administrative access
     */
    @Column
    private int userRole = 0;


}
//This is the model for Users that defines the traits that users have in the database. Each of these values is
//connected to a column in the database.
