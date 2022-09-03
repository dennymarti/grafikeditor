package ch.dennymarti.grafikeditor.editor;

import ch.dennymarti.grafikeditor.figures.*;
import ch.dennymarti.grafikeditor.gui.EditorFooterBar;
import ch.dennymarti.grafikeditor.utils.Drawing;

import java.awt.*;

public class EditorControl {

    private Drawing drawing = new Drawing();
    private EditorFooterBar editorFooterBar;
    private char keyType;

    private Point firstPoint;

    public Drawing getDrawing() {
        return drawing;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    public void setEditorFooterBar(EditorFooterBar editorFooterBar) {
        this.editorFooterBar = editorFooterBar;
    }

    public void repaintAll(Graphics graphics) {
        drawing.drawFigures(graphics);
    }

    public void setKeyType(char keyType) {
        this.keyType = keyType;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void clear() {
        drawing.deleteAll();
    }

    public void setLastPoint(Point secondPoint) {
        int x = Math.min(firstPoint.x, secondPoint.x);
        int y = Math.min(firstPoint.y, secondPoint.y);
        int width = Math.abs(secondPoint.x - firstPoint.x);
        int height = Math.abs(secondPoint.y - firstPoint.y);
        Figur newFigure;

        switch (keyType) {
            case 'r':
                newFigure = new Rechteck(x, y, width, height, Color.BLACK, false);
                editorFooterBar.updateFunction("Rechteck");
                break;
            case 'c':
                newFigure = new Kreis(firstPoint.x, firstPoint.y, ((int) Math.round(Math.sqrt(Math.pow(firstPoint.x - secondPoint.x, 2) + Math.pow(firstPoint.y - secondPoint.y, 2)))), Color.BLACK, false);
                editorFooterBar.updateFunction("Kreis");
                break;
            case 'e':
                newFigure = new Ellipse(x, y, width, height, Color.BLACK, false);
                editorFooterBar.updateFunction("Ellipse");
                break;
            default:
                newFigure = new Linie(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y, Color.BLACK);
                editorFooterBar.updateFunction("Linie");
        }
        drawing.add(newFigure);
    }
}
