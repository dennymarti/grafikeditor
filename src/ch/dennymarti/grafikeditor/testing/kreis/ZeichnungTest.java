package ch.dennymarti.grafikeditor.testing.kreis;

import ch.dennymarti.grafikeditor.figures.Ellipse;
import ch.dennymarti.grafikeditor.figures.Kreis;
import ch.dennymarti.grafikeditor.figures.Linie;
import ch.dennymarti.grafikeditor.figures.Rechteck;
import ch.dennymarti.grafikeditor.utils.Drawing;

import org.junit.Test;
import org.mockito.InOrder;

import java.awt.*;

import static org.mockito.Mockito.*;

public class ZeichnungTest {

    private Graphics graphics = mock(Graphics.class);

    @Test
    public void drawTestFigures() {
        Drawing drawing = new Drawing();

        // Rechteck
        Rechteck rechteck = new Rechteck(18, 18, 28, 28);
        drawing.add(rechteck);
        drawing.drawFigures(graphics);
        verify(graphics, times(1)).drawRect(18, 18, 28, 28);

        // Kreis
        Kreis kreis = new Kreis(128, 128, 64);
        drawing.add(kreis);

        // Höhe vom Rechteck ändern
        rechteck.setHeight(34);
        drawing.drawFigures(graphics);

        verify(graphics, times(1)).drawRect(18, 18, 28, 34);
        verify(graphics, times(1)).drawOval(64, 64, 128, 128);

        InOrder order = inOrder(graphics);

        // Länge vom Dreieck ändern
        rechteck.setWidth(60);

        // Radius vom Kreis ändern
        kreis.setRadius(32);

        // Linie
        Linie linie = new Linie(8, 8, 24, 24);
        drawing.add(linie);
        drawing.drawFigures(graphics);

        // Reihenfolge überprüfen
        order.verify(graphics).drawRect(18, 18, 60, 34);
        order.verify(graphics).drawOval(18, 18, 64, 64);
        order.verify(graphics).drawLine(8, 8, 24, 24);

        // Überprüfen ob Ellipse mit korrekter Position, Grösse und Farbe gezeichnet wurde
        Ellipse ellipse = new Ellipse(72, 72, 90, 120);
        ellipse.setColor(Color.ORANGE);
        drawing.add(ellipse);
    }
}
