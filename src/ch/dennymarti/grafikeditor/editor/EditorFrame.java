package ch.dennymarti.grafikeditor.editor;

import ch.dennymarti.grafikeditor.gui.EditorFooterBar;
import ch.dennymarti.grafikeditor.gui.EditorMenuBar;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {

    private EditorControl editorControl = new EditorControl();
    private EditorFooterBar editorFooterBar = new EditorFooterBar(editorControl);
    private EditorPanel editorPanel = new EditorPanel(editorControl, editorFooterBar);

    public EditorFrame(int width, int height) {
        setJMenuBar(new EditorMenuBar(editorControl, editorPanel, editorFooterBar));
        createPanel();
        centerWindow(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        editorControl.setEditorFooterBar(editorFooterBar);
    }

    private void createPanel() {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        wrapper.add(editorPanel, BorderLayout.CENTER);
        wrapper.add(editorFooterBar, BorderLayout.PAGE_END);
        setContentPane(wrapper);
    }

    private void centerWindow(int width, int height) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle windowSection = new Rectangle();
        windowSection.width = width;
        windowSection.height = height;
        windowSection.x = (screenSize.width - windowSection.width) / 2;
        windowSection.y = (screenSize.height - windowSection.height) / 2;
        setBounds(windowSection);
    }
}
