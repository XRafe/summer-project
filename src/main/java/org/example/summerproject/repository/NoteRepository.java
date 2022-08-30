package org.example.summerproject.repository;

import org.example.summerproject.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    Note findNoteByName(String name);

    boolean existsNoteByName(String name);
}
