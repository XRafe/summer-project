package org.example.summerproject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Note {
    @Id
    @SequenceGenerator(name = "note_id_seq_generator", sequenceName = "note_id_seq")
    @GeneratedValue(generator = "note_id_seq_generator", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
}
