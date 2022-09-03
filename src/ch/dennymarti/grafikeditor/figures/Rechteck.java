package ch.dennymarti.grafikeditor.figures;

import org.json.simple.JSONObject;

import java.awt.*;

public class Rechteck extends Figur {
    
    private int width;
    private int height;

    public Rechteck() {
    }

    public Rechteck(int x, int y, int width, int height) {
        super(x, y, Color.BLACK, false);
        this.width = width;
        this.height = height;
    }

    public Rechteck(int x, int y, int width, int height, Color color, boolean filled) {
        super(x, y, color, filled);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void drawFilled(Graphics graphics) {
        graphics.fillRect(x, y, width, height);
    }

    @Override
    public void drawBlank(Graphics graphics) {
        graphics.drawRect(x, y, width, height);
    }

    @Override
    public void loadJSONObject(JSONObject jsonObject) {
        super.loadJSONObject(jsonObject);
        this.width = (int) ((long) jsonObject.get("Width"));
        this.height = (int) ((long) jsonObject.get("Height"));
    }

    @Override
    public JSONObject getJSONObject() {
        JSONObject jsonObject = super.getJSONObject();
        jsonObject.put("Width", width);
        jsonObject.put("Height", height);
        return jsonObject;
    }
}
