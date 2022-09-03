package ch.dennymarti.grafikeditor.utils;

import ch.dennymarti.grafikeditor.figures.Figur;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Drawing {

    private final ArrayList<Figur> figures = new ArrayList<>();

    public void add(Figur figur) {
        figures.add(figur);
    }

    public void remove(Figur figur) {
        figures.remove(figur);
    }

    public void deleteAll() {
        figures.clear();
    }

    public void drawFigures(Graphics graphics) {
        for (Figur figur : figures) {
            figur.draw(graphics);
        }
    }

    public Figur[] getFigures() {
        return figures.toArray(new Figur[0]);
    }
}
