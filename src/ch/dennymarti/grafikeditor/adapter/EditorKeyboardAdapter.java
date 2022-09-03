package ch.dennymarti.grafikeditor.adapter;

import ch.dennymarti.grafikeditor.editor.EditorControl;
import ch.dennymarti.grafikeditor.editor.EditorPanel;
import ch.dennymarti.grafikeditor.gui.EditorFooterBar;
import ch.dennymarti.grafikeditor.utils.Drawing;
import ch.dennymarti.grafikeditor.utils.JSONFigurLoader;
import ch.dennymarti.grafikeditor.utils.FigurSaver;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditorKeyboardAdapter extends KeyAdapter {

    private EditorControl editorControl;
    private EditorPanel editorPanel;

    public EditorKeyboardAdapter(EditorControl editorControl, EditorPanel editorPanel) {
        this.editorControl = editorControl;
        this.editorPanel = editorPanel;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        editorControl.setKeyType(event.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == KeyEvent.VK_DELETE) {
            editorControl.clear();
            editorPanel.repaint();
        }
        if (keyCode == KeyEvent.VK_S && event.isControlDown()) {
            System.out.println("Saved figures");

            Drawing drawing = editorControl.getDrawing();
            new FigurSaver(drawing.getFigures());
        }
        if (keyCode == KeyEvent.VK_V && event.isControlDown()) {
            System.out.println("Loaded figures");

            editorControl.setDrawing(new JSONFigurLoader().load());
            editorPanel.repaint();
        }
    }
}
