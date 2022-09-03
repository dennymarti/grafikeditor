package ch.dennymarti.grafikeditor.group;

import ch.dennymarti.grafikeditor.figures.Figur;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Group extends Figur {

    private final List<Figur> group = new ArrayList<>();

    public Group(int x, int y, Color color, boolean filled) {
        super(x, y, color, filled);
    }

    public void add(Figur figur) {
        group.add(figur);
    }

    public void remove(Figur figur) {
        group.remove(figur);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void drawFilled(Graphics graphics) {
        for (Figur figur : group) {
            figur.drawFilled(graphics);
        }
    }

    @Override
    public void drawBlank(Graphics graphics) {
        for (Figur figur : group) {
            figur.drawBlank(graphics);
        }
    }

    public List<Figur> getFiguren() {
        return group;
    }
}
