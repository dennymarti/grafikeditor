package ch.dennymarti.grafikeditor.adapter;

import ch.dennymarti.grafikeditor.editor.EditorControl;
import ch.dennymarti.grafikeditor.editor.EditorPanel;
import ch.dennymarti.grafikeditor.gui.EditorFooterBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorMouseAdapter extends MouseAdapter {

    private double x;
    private double x2;

    private EditorPanel editorPanel;
    private EditorControl editorControl;
    private EditorFooterBar editorFooterBar;

    public EditorMouseAdapter(EditorControl editorControl, EditorPanel editorPanel, EditorFooterBar editorFooterBar) {
        this.editorControl = editorControl;
        this.editorPanel = editorPanel;
        this.editorFooterBar = editorFooterBar;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        editorControl.setFirstPoint(event.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        editorControl.setLastPoint(event.getPoint());
        updatePanel();
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        x = event.getPoint().getX();
        System.out.println("Eintritt: " + x);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        editorFooterBar.updateMouse(event.getPoint());
    }

    @Override
    public void mouseExited(MouseEvent event) {
        x2 = event.getPoint().getX();
        double difference = (x - x2);
        System.out.println("Austritt: " + x2);
        System.out.println("X-Differenz: " + difference);
    }

    private void updatePanel() {
        editorPanel.repaint();
    }
}
