package org.example.summerproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.note.NoteDto;
import org.example.summerproject.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/create")
    public NoteDto createNote(NoteDto noteDTO) {
        return noteService.createNote(noteDTO);
    }

    @GetMapping("/data/find-all")
    public List<NoteDto> findAllNoteFromData() {
        return noteService.findAllNoteFromData();
    }

    @GetMapping("/find-all")
    public List<NoteDto> getAllNote() {
        return noteService.getAllNote();
    }

    @GetMapping("/find-by-name")
    public NoteDto findNoteByName(String name) {
        return noteService.findNoteByName(name);
    }
}
