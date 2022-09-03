package ch.dennymarti.grafikeditor.utils;

import ch.dennymarti.grafikeditor.figures.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONFigurLoader implements FigurLoader {

    private final File file = new File("figures.json");

    @Override
    public Drawing load() {
        Drawing drawing = new Drawing();
        JSONParser jsonParser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));

            for (var jsonElement : jsonArray) {
                if (jsonElement instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) jsonElement;

                    Figur figur = null;

                    switch (jsonObject.get("type").toString()) {
                        case "Ellipse":
                            figur = new Ellipse();
                            break;
                        case "Kreis":
                            figur = new Kreis();
                            break;
                        case "Rechteck":
                            figur = new Rechteck();
                            break;
                        case "Linie":
                            figur = new Linie();
                            break;
                    }
                    if (figur == null) {
                        continue;
                    }
                    figur.loadJSONObject((JSONObject) jsonObject.get("properties"));

                    drawing.add(figur);
                }
            }
        } catch (IOException | ParseException exception) {
            System.out.println("Datei konnte nicht gelesen werden:(");
            System.out.println(exception.getMessage());
        }
        return drawing;
    }
}
