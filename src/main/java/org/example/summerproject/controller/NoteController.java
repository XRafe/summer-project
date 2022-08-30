package org.example.summerproject.controller;

import lombok.AllArgsConstructor;
import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.entity.Note;
import org.example.summerproject.repository.NoteRepository;
import org.example.summerproject.service.impl.NoteServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {

    private NoteServiceImpl noteService;
    private final NoteRepository noteRepository;

    @PostMapping("/create")
    public NoteDTO createNote(NoteDTO noteDTO) {
        if (!noteRepository.existsNoteByName(noteDTO.getName())) {
            System.out.println("200");
            return noteService.createNote(noteDTO);
        } else {
            System.out.println("Данный объект уже существует");
            return null;
        }
    }

    @GetMapping("/data/find-all")
    public List<NoteDTO> findAllNoteFromData() throws SQLException {
        return noteService.findAllNoteFromData().stream().toList();
    }

    @GetMapping("/find-all")
    public List<NoteDTO> getAllNote() {
        return noteService.getAllNote();
    }

    public Note findNoteByName(String name) {
        if (noteRepository.existsNoteByName(name)) {
            System.out.println("200");
            return noteService.findNoteByName(name);
        } else {
            System.out.println("404");
            return null;
        }
    }
}
