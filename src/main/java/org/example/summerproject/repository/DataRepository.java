package org.example.summerproject.repository;

import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class DataRepository implements Serializable {

    public ArrayList<UserDTO> findAllUser() {
        try (var st = AppDataSource.getDataSource().getConnection()
                .prepareStatement("select * from summerproject.user")) {
            var result = st.executeQuery();
            return mapResultSetToUserDto(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<UserDTO> mapResultSetToUserDto(ResultSet resultSet) throws SQLException {
        ArrayList<UserDTO> users = new ArrayList<>();
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");

            users.add(new UserDTO(email, name));
        }
        return users;
    }


    public ArrayList<NoteDTO> findAllNote() throws SQLException {
        try (var st = AppDataSource.getDataSource().getConnection()
                .prepareStatement("select * from summerproject.note")) {
            var result = st.executeQuery();
            return mapResultSetToNoteDto(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<NoteDTO> mapResultSetToNoteDto(ResultSet resultSet) throws SQLException {
        ArrayList<NoteDTO> notes = new ArrayList<>();
        while (resultSet.next()) {
            String email = resultSet.getString("name");
            String name = resultSet.getString("text");

            notes.add(new NoteDTO(email, name));
        }
        return notes;
    }
}
