package entities;

import java.util.Objects;

public class Note {

    private int id;
    private String tittle;
    private String textArea;


    public Note() {}

    public Note(String textArea) {
        this.textArea = textArea;
    }

    public int getId() {
        return id;
    }

    public String getTextArea() {
        return textArea;
    }

    public String getTittle() {
        return tittle;
    }

    public void  setNoteArg(int id, String tittle, String textArea) {
        this.tittle=tittle;
        this.textArea=textArea;
        this.id=id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTextArea(String textArea) {
        //this.tittle = textArea.substring(0, 10);
        this.textArea = textArea;
    }

    public void setTittle(String tittle) { this.tittle = tittle;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(textArea, note.textArea);
    }
    @Override
    public int hashCode() {
        return Objects.hash(textArea);
    }

    @Override
    public String toString() {
        return "entities.Note{" +
                "textArea='" + textArea + '\'' +
                '}';
    }
}
