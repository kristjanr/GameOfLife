import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    protected static final int ROW_COUNT = 50;
    private static final int W = 600 / ROW_COUNT;
    private static final int H = W;
    private static final Dimension PREF_SIZE = new Dimension(W, H);
    protected Color originalColor = null;
    protected static final Color SELECTION_COLOR = Color.pink;

    public Grid() {
        setLayout(new GridLayout(ROW_COUNT, ROW_COUNT, 1, 1));
        setBackground(Color.black);

        for (int i = 0; i < ROW_COUNT * ROW_COUNT; i++) {
            JPanel panel = new JPanel();
            String name = String.format("%d,%d",
                    i / ROW_COUNT, i % ROW_COUNT);
            panel.setName(name);
            if (i == 0) {
                originalColor = panel.getBackground();
            }
            panel.setPreferredSize(PREF_SIZE);
            add(panel);
        }
    }

    protected Cell createCell(Component component) {
        int x = parseX(component.getName());
        int y = parseY(component.getName());
        return new Cell(x, y);
    }

    public void clear() {
        for (Component component : getComponents()) {
            component.setBackground(originalColor);
        }
    }

    private int parseY(String name) {
        return Integer.parseInt(name.split(",")[0]);
    }

    private int parseX(String name) {
        return Integer.parseInt(name.split(",")[1]);
    }
}
