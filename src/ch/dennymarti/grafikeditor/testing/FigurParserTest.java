package ch.dennymarti.grafikeditor.testing;

import ch.dennymarti.grafikeditor.figures.Figur;
import ch.dennymarti.grafikeditor.figures.Linie;
import ch.dennymarti.grafikeditor.figures.Rechteck;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FigurParserTest {

    //private FigurFileDAO dao;
    private FigurDAOStub dao;
    private FigurParser parser;

    @Before
    public void setup() {
        //dao = new FigurFileDAO();
        dao = new FigurDAOStub("Linie,0,0,300,300", "Rechteck,30,30,80,80");
        parser = new FigurParser(dao);
    }

    @Test
    public void test() {
        List<Figur> figuren = parser.parse();
        assertEquals(2, figuren.size());
        Figur figur1 = figuren.get(0);
        Figur figur2 = figuren.get(1);

        assertTrue(figur1 instanceof Linie);
        assertTrue(figur2 instanceof Rechteck);

        Linie linie = (Linie) figur1;
        Rechteck rechteck = (Rechteck) figur2;

        assertEquals(0, linie.getX());
        assertEquals(30, rechteck.getX());
    }
}
