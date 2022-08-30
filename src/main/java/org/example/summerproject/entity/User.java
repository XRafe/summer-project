package org.example.summerproject.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @SequenceGenerator(name = "user_id_seq_generator", sequenceName = "user_id_seq")
    @GeneratedValue(generator = "user_id_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String email;

    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Note> notes;
}
