package org.example.summerproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {

    @Id
    @SequenceGenerator(name = "user_id_seq_generator", sequenceName = "user_id_seq")
    @GeneratedValue(generator = "user_id_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String email;

    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Note> notes;
}
