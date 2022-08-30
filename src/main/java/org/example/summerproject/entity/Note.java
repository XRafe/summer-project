package org.example.summerproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Note {
    @Id
    @SequenceGenerator(name = "note_id_seq_generator", sequenceName = "note_id_seq")
    @GeneratedValue(generator = "note_id_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Integer userId;

    public Note(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
