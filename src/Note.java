import java.util.Objects;

public class Note {

    private int id;
    private String tittle;
    private String textArea;


    public Note() {}

    /*public Note(int id) {this.id = id;*/


    public Note(int id, String textArea) {
        this.id = id;
        this.textArea = textArea;
        this.tittle = textArea.substring(0, 5);
    }

    public Note(String tittle, String textArea) {
        this.textArea = textArea;
        this.tittle = tittle;
    }

    public Note(String textArea) {
        Model model = Model.getInstance();
        this.id = model.lenght() + 1;
        this.textArea = textArea;
        this.tittle = this.textArea.substring(0, 6);
    }

    public Note(int id, String tittle, String textArea) {
        this.id = id;
        this.tittle = tittle;
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
        return "Note{" +
                "textArea='" + textArea + '\'' +
                '}';
    }
}
