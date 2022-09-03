package ch.dennymarti.grafikeditor.figures;

import org.json.simple.JSONObject;

import java.awt.*;

public class Linie extends Figur {

    private int endX;
    private int endY;

    public Linie() {
    }

    public Linie(int startX, int startY, int endX, int endY) {
        super(startX, startY, Color.BLACK, false);
        this.endX = endX;
        this.endY = endY;
    }

    public Linie(int startX, int startY, int endX, int endY, Color color) {
        super(startX, startY, color, false);
        this.endX = endX;
        this.endY = endY;
    }

    public void drawFilled(Graphics graphics) {
        // ...
    }

    @Override
    public void drawBlank(Graphics graphics) {
        graphics.drawLine(x, y, endX, endY);
    }

    @Override
    public JSONObject getJSONObject() {
        JSONObject jsonObject = super.getJSONObject();
        jsonObject.put("endX", endX);
        jsonObject.put("endY", endY);
        return jsonObject;
    }

    @Override
    public void loadJSONObject(JSONObject jsonObject) {
        super.loadJSONObject(jsonObject);
        this.endX = (int) ((long) jsonObject.get("endX"));
        this.endY = (int) ((long) jsonObject.get("endY"));
    }
}
