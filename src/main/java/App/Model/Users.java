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
    int id;
    @Column
    String username;
    @Column
    String password;

    //public boolean admin;
}
