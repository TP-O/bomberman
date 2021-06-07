package core;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window {

    private String title;

    private int width;

    private int height;

    private JFrame frame;

    private Canvas canvas;

    public Window(String inTitle, int inWidth, int inHeight) {
        title = inTitle;
        width = inWidth;
        height = inHeight;
    }

    public void display() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}
