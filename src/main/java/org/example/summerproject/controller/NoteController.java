package org.example.summerproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.NoteDto;
import org.example.summerproject.repository.NoteRepository;
import org.example.summerproject.service.ImplService.NoteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteServiceImpl noteService;
    private final NoteRepository noteRepository;

    @GetMapping
    public NoteDto createNote(@RequestBody NoteDto requestBody) {
        return noteService.createNote(requestBody);
    }

    @GetMapping
    public List<NoteDto> getAllNotes() {
        return noteService.getAllNotes();
    }
}
