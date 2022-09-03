package ch.dennymarti.grafikeditor.gui;

import ch.dennymarti.grafikeditor.editor.EditorControl;
import ch.dennymarti.grafikeditor.editor.EditorFrame;
import ch.dennymarti.grafikeditor.editor.EditorPanel;
import ch.dennymarti.grafikeditor.utils.FigurLoader;
import ch.dennymarti.grafikeditor.utils.FigurSaver;
import ch.dennymarti.grafikeditor.utils.JSONFigurLoader;

import javax.swing.*;

public class EditorMenuBar extends JMenuBar {

    private EditorControl editorControl;
    private EditorPanel editorPanel;
    private EditorFooterBar editorFooterBar;

    public EditorMenuBar(EditorControl editorControl, EditorPanel editorPanel, EditorFooterBar editorFooterBar) {
        super();

        this.editorControl = editorControl;
        this.editorPanel = editorPanel;
        this.editorFooterBar = editorFooterBar;

        loadFigurTypes();
        loadActionTypes();
    }

    public void loadFigurTypes() {
        JMenu figurTypesMenu = new JMenu("Figuren");

        JMenuItem circle = new JMenuItem("Kreis");
        circle.addActionListener(event -> {
            editorControl.setKeyType('c');
            editorFooterBar.updateFunction("Kreis");
        });

        JMenuItem rectangle = new JMenuItem("Rechteck");
        rectangle.addActionListener(event -> {
            editorControl.setKeyType('r');
            editorFooterBar.updateFunction("Rechteck");
        });

        JMenuItem ellipse = new JMenuItem("Ellipse");
        ellipse.addActionListener(event -> {
            editorControl.setKeyType('e');
            editorFooterBar.updateFunction("Ellipse");
        });
        JMenuItem line = new JMenuItem("Linie");
        line.addActionListener(event -> {
            editorControl.setKeyType('m');
            editorFooterBar.updateFunction("Linie");
        });

        figurTypesMenu.add(circle);
        figurTypesMenu.add(rectangle);
        figurTypesMenu.add(line);
        figurTypesMenu.add(ellipse);

        this.add(figurTypesMenu);
    }

    public void loadActionTypes() {
        JMenu actionTypesMenu = new JMenu("Aktionen");

        JMenuItem save = new JMenuItem("Figuren speichern");
        save.addActionListener(event -> {
            System.out.println("Saved figures");
            new FigurSaver(editorControl.getDrawing().getFigures());
        });
        JMenuItem load = new JMenuItem("Figuren laden");
        load.addActionListener(event -> {
            System.out.println("Loaded figures");
            editorControl.setDrawing(new JSONFigurLoader().load());
            editorPanel.repaint();
        });
        JMenuItem delete = new JMenuItem("Figuren löschen");
        delete.addActionListener(event -> {
            editorControl.clear();
            editorPanel.repaint();
        });

        actionTypesMenu.add(save);
        actionTypesMenu.add(load);
        actionTypesMenu.add(delete);

        this.add(actionTypesMenu);
    }
}
