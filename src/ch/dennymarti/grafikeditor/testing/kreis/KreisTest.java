package ch.dennymarti.grafikeditor.testing.kreis;

import ch.dennymarti.grafikeditor.figures.Kreis;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KreisTest {

    @Test
    public void drawTest() {
        GraphicsStub graphicsStub = new GraphicsStub();
        int x = 16, y = 16;
        int radius = 64;
        Kreis testKreis = new Kreis(x, y, radius);

        testKreis.draw(graphicsStub);
        assertEquals(1, graphicsStub.drawCounter);
        assertEquals(-48, graphicsStub.x);
        assertEquals(-48, graphicsStub.y);
        assertEquals(128, graphicsStub.width);
        assertEquals(128, graphicsStub.height);
    }
}
