package org.example.summerproject.controller;

import lombok.AllArgsConstructor;
import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.entity.Note;
import org.example.summerproject.repository.NoteRepository;
import org.example.summerproject.service.ImplService.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/note")
@AllArgsConstructor
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public NoteDTO CreateNote(NoteDTO noteDTO) {
        if (!noteRepository.existsNoteByName(noteDTO.getName())) {
            return noteService.createNote(noteDTO);
        } else {
            System.out.println("Данный объект уже существует");
            return null;
        }
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public List<NoteDTO> FindAllNoteFromData() throws SQLException {
        return noteService.findAllNoteFromData().stream().toList();
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public List<NoteDTO> GetAllNote() {
        return noteService.getAllNote();
    }

    public Note FindNoteByName(String name) {
        if (noteRepository.existsNoteByName(name)) {
            System.out.println("200");
            return noteService.findNoteByName(name);
        } else {
            System.out.println("404");
            return null;
        }
    }
}
