package org.example.summerproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
