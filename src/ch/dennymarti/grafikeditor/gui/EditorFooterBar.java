package ch.dennymarti.grafikeditor.gui;

import ch.dennymarti.grafikeditor.editor.EditorControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditorFooterBar extends JPanel {

    private EditorControl editorControl;

    private JLabel function;
    private JLabel mouse;

    public EditorFooterBar(EditorControl editorControl) {
        super();

        this.editorControl = editorControl;
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(8, 8,8, 8));

        function = new JLabel("Funktion: Linie");
        this.add(function, BorderLayout.WEST);

        mouse = new JLabel("Maus: x=0, y=0");
        this.add(mouse, BorderLayout.EAST);
    }

    public void updateFunction(String type) {
        function.setText("Funktion: " + type);
    }

    public void updateMouse(Point point) {
        mouse.setText("Maus: x=" + point.getX() + ", y=" + point.getY());
    }
}
