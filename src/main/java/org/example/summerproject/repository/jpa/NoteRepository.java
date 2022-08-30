package org.example.summerproject.repository.jpa;

import org.example.summerproject.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    Optional<Note> findNoteByName(String name);

    boolean existsNoteByName(String name);
}
