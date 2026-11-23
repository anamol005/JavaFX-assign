package assign_6_4.controller;

import assign_6_4.model.Note;
import assign_6_4.model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private TextArea notesArea;

    private Notebook notebook = new Notebook();

    @FXML
    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        Note note = new Note(title, content);
        notebook.addNote(note);

        String text = "";

        for (Note n : notebook.getNotes()) {
            text += n.getTitle() + "\n";
            text += n.getContent() + "\n\n";
        }

        notesArea.setText(text);
        titleField.clear();
        contentArea.clear();
    }
}
