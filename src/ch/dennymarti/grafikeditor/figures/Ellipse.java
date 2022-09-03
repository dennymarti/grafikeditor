package ch.dennymarti.grafikeditor.figures;

import org.json.simple.JSONObject;

import java.awt.*;

public class Ellipse extends Figur {

    protected int width;
    protected int height;

    public Ellipse() {
    }

    public Ellipse(int x, int y, int width, int height) {
        super(x, y, Color.BLACK, false);
        this.width = width;
        this.height = height;
    }

    public Ellipse(int x, int y, int width, int height, Color color, boolean filled) {
        super(x, y, color, filled);
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawFilled(Graphics graphics) {
        graphics.fillOval(x, y, width, height);
    }

    @Override
    public void drawBlank(Graphics graphics) {
        graphics.drawOval(x, y, width, height);
    }

    @Override
    public JSONObject getJSONObject() {
        JSONObject jsonObject = super.getJSONObject();
        jsonObject.put("Width", width);
        jsonObject.put("Height", height);
        return jsonObject;
    }

    @Override
    public void loadJSONObject(JSONObject jsonObject) {
        super.loadJSONObject(jsonObject);
        this.width = (int) ((long) jsonObject.get("Width"));
        this.height = (int) ((long) jsonObject.get("Height"));
    }
}
