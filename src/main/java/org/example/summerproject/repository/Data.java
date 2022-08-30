package org.example.summerproject.repository;

import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
public class Data {

    public Set<UserDTO> findAllUser() {
        try (var st = AppDataSource.getConnection()
                .prepareStatement("select * from summerproject.user")) {
            var result = st.executeQuery();
            return mapResultSetToUserDto(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<UserDTO> mapResultSetToUserDto(ResultSet resultSet) throws SQLException {
        Set<UserDTO> users = new HashSet<>();
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");

            users.add(new UserDTO(email, name));
        }
        return users;
    }


    public Set<NoteDTO> findAllNote() throws SQLException {
        try (var st = AppDataSource.getConnection()
                .prepareStatement("select * from summerproject.note")) {
            var result = st.executeQuery();
            return mapResultSetToNoteDto(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Set<NoteDTO> mapResultSetToNoteDto(ResultSet resultSet) throws SQLException {
        Set<NoteDTO> notes = new HashSet<>();
        while (resultSet.next()) {
            String email = resultSet.getString("name");
            String name = resultSet.getString("text");

            notes.add(new NoteDTO(email, name));
        }
        return notes;
    }
}
