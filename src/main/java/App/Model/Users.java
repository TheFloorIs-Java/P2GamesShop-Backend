package App.Model;


import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //SPRING ORM: registers this class to be associated with a database table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generate user id
    @Column
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    //@Column
    //private boolean userRole;


    //public boolean admin;
}
