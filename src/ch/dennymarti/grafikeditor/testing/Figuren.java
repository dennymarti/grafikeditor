package ch.dennymarti.grafikeditor.testing;

import ch.dennymarti.grafikeditor.figures.Figur;

import java.util.List;

public class Figuren {

    public static void main(String[] args) {
        FigurFileDAO dao = new FigurFileDAO();
        FigurParser parser = new FigurParser(dao);
        List<Figur> figuren = parser.parse();
        dao.close();

        System.out.println(figuren);
    }
}
