package ch.dennymarti.grafikeditor.figures;

import org.json.simple.JSONObject;

import java.awt.*;

public abstract class Figur {

    protected Integer x;
    protected Integer y;

    protected Color color;

    protected boolean filled;

    public Figur() {

    }

    public Figur(int x, int y, Color color, boolean filled) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.filled = filled;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);

        if (filled) {
            drawFilled(graphics);
        } else {
            drawBlank(graphics);
        }
    }

    public abstract void drawFilled(Graphics graphics);

    public abstract void drawBlank(Graphics graphics);

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public void loadJSONObject(JSONObject jsonObject) {
        this.x = (int) ((long) jsonObject.get("x"));
        this.y = (int) ((long) jsonObject.get("y"));
        this.color = new Color((int) ((long) jsonObject.get("Color")));
        this.filled = (Boolean) jsonObject.get("Filled");
    }

    public JSONObject getJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("x", x);
        jsonObject.put("y", y);
        jsonObject.put("Color", color.getRGB());
        jsonObject.put("Filled", filled);
        return jsonObject;
    }
}
