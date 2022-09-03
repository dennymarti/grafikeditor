package ch.dennymarti.grafikeditor.testing.kreis;

public class GraphicsStub extends ConcreteGraphics {

    int drawCounter = 0;

    int x;
    int y;
    int width;
    int height;

    @Override
    public void drawOval(int x, int y, int width, int height) {
        drawCounter++;

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
