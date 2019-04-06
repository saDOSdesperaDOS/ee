package model;

import entities.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    private static Model instance = new Model();//instansce is singletone
    private List<Note> model;

    public Model() {
        model = new ArrayList<>();
    }

    public static Model getInstance() {
        return instance;
    }

    public void add(Note note) {
        model.add(note);
    }

    public void delete(Note note) {
        model.remove(note);
    }

    public int lenght() { return model.size();}

    public List<String> list() {
        return model.stream()
                .map(Note::getTextArea)
                .collect(Collectors.toList());
    }


}
