package ch.dennymarti.grafikeditor.utils;

import ch.dennymarti.grafikeditor.figures.Figur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FigurSaver {

    private static final File file = new File("figures.json");

    public FigurSaver(Figur[] figurs) {
        JSONArray jsonArray = new JSONArray();

        for (Figur figur : figurs) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", figur.getClass().getSimpleName());
            jsonObject.put("properties", figur.getJSONObject());
            jsonArray.add(jsonObject);
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println("Figuren konnten nicht gespeichert werden:(");
            System.out.println(exception.getMessage());
        }
    }
}
