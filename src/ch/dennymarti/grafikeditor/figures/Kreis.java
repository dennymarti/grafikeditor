package ch.dennymarti.grafikeditor.figures;

import org.json.simple.JSONObject;

import java.awt.*;

public class Kreis extends Figur {

    private int radius;

    public Kreis() {

    }

    public Kreis(int x, int y, int radius) {
        super(x, y, Color.BLACK, false);
        this.radius = radius;
    }

    public Kreis(int x, int y, int radius, Color color, boolean filled) {
        super(x, y, color, filled);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void drawBlank(Graphics graphics) {
        graphics.drawOval(x - radius, y - radius, radius*2, radius*2);
    }

    @Override
    public void drawFilled(Graphics graphics) {
        graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public JSONObject getJSONObject() {
        JSONObject jsonObject = super.getJSONObject();
        jsonObject.put("Radius", getRadius());
        return jsonObject;
    }

    @Override
    public void loadJSONObject(JSONObject jsonObject) {
        super.loadJSONObject(jsonObject);
        this.radius = (int) ((long) jsonObject.get("Radius"));
    }
}
