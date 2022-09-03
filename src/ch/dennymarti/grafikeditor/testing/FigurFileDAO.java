package ch.dennymarti.grafikeditor.testing;

import javax.swing.*;
import java.io.*;

public class FigurFileDAO implements IFigurDAO {

    private BufferedReader in;

    public FigurFileDAO() {
        JFileChooser chooser = new JFileChooser();
        int openResult = chooser.showOpenDialog(null);
        if (openResult == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                in = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String[] readNextFigurData() {
        if (in != null) {
            try {
                String line = in.readLine();
                if (line != null && !line.isEmpty())
                    return line.split(",");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void close() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
