package net.wls.test.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "user_name")
    private String name;

    @Getter
    @Setter
    @Column(name = "user_email")
    private String email;
}
