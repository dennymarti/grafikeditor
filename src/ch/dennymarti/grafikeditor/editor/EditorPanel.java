package ch.dennymarti.grafikeditor.editor;

import ch.dennymarti.grafikeditor.adapter.EditorKeyboardAdapter;
import ch.dennymarti.grafikeditor.adapter.EditorMouseAdapter;
import ch.dennymarti.grafikeditor.gui.EditorFooterBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class EditorPanel extends JPanel {

    private EditorControl editorControl;

    public EditorPanel(EditorControl control, EditorFooterBar editorFooterBar) {
        editorControl = control;
        this.grabFocus();
        this.setFocusable(true);
        MouseAdapter mouseAdapter = new EditorMouseAdapter(editorControl, this, editorFooterBar);
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
        addKeyListener(new EditorKeyboardAdapter(editorControl, this));
    }

    // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
    // Methode beim EditorFrame oder beim EditorPanel aufruft.
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        editorControl.repaintAll(graphics);
    }
}
