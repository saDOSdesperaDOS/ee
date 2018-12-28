package dao;

import entities.Note;
import jdbc.ConnectionToDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlRequest {
    String SQL_FIND_ALL = "SELECT * FROM notestable";
    String SQL_FIND_BY_ID = SQL_FIND_ALL + " WHERE id=?";
    String SQL_INSERT = "INSERT INTO NotesTable (tittle, textArea) VALUES (?, ?)";

    public List<Note> sellectAll(){ // можно было возвратить Map<note.tittle, note.textArea> (типа ключ(tittle) -
        ConnectionToDB connectionToDB;                  // значение(textArea)), но тогда пришлось переделывать методы model.Model Add() & Del()
        List<Note> result = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connectionToDB = ConnectionToDB.getInstance();
            connection = connectionToDB.getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL);
            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setTittle(resultSet.getString("tittle"));
                note.setTextArea(resultSet.getString("textArea"));
                result.add(note);
            }
            connection.commit();
        } catch (SQLException e) {
            ConnectionToDB.rollBackQuietly(connection);
        } finally {
            ConnectionToDB.closeQuietly(resultSet);
            ConnectionToDB.closeQuietly(statement);
            ConnectionToDB.closeQuietly(connection);
        }
        return result;
    }

    public Note findById(int id) {
        Note note = null;
        ConnectionToDB connectionToDB;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connectionToDB = ConnectionToDB.getInstance();
            connection = connectionToDB.getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                note = new Note();
                note.setId(resultSet.getInt("id"));
                note.setTittle(resultSet.getString("tittle"));
                note.setTextArea(resultSet.getString("textArea"));
            }
            connection.commit();
        } catch (SQLException e) {
            ConnectionToDB.rollBackQuietly(connection);
        } finally {
            ConnectionToDB.closeQuietly(resultSet);
            ConnectionToDB.closeQuietly(statement);
            ConnectionToDB.closeQuietly(connection);
        }
        return note;
    }

    public Note add(Note note) {
        ConnectionToDB connectionToDB;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connectionToDB = ConnectionToDB.getInstance();
            connection = connectionToDB.getConnection();
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, note.getTittle());
            statement.setString(2, note.getTextArea());
            statement.execute();
            rs = statement.getGeneratedKeys();
            rs.next();
            int idGenerated = rs.getInt(1);
            note.setId(idGenerated);
            connection.commit();
        } catch (SQLException e) {
            ConnectionToDB.rollBackQuietly(connection);
        } finally {
            ConnectionToDB.closeQuietly(rs);
            ConnectionToDB.closeQuietly(statement);
            ConnectionToDB.closeQuietly(connection);
        }
        return note;
    }
}
