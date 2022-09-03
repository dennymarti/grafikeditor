package ch.dennymarti.grafikeditor.testing;

public class FigurDAOStub implements IFigurDAO {

    private String[] figuren;

    private int currentFigur = 0;

    public FigurDAOStub(String... figuren) {
        this.figuren = figuren;
    }
    @Override
    public String[] readNextFigurData() {
        String[] figurData = null;
        if (currentFigur < figuren.length) {
            figurData = figuren[currentFigur].split(",");
            currentFigur++;
        }
        return figurData;
    }
}
