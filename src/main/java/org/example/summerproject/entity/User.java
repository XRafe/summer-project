package org.example.summerproject.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_id_seq_generator", sequenceName = "user_id_seq")
    @GeneratedValue(generator = "user_id_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String email;

    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Note> notes;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
