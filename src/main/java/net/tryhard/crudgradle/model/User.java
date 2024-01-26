package net.tryhard.crudgradle.model;

import jakarta.persistence.*;
import lombok.Data;

@Data //trying lombook,get,set,toString
@Entity //DB
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto++
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

}
