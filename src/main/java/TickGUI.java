
import java.awt.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class TickGUI extends Grid {
    private Game game;

    public TickGUI(Game game) {
        super();
        this.game = game;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        draw();
    }

    private void draw() {
        CopyOnWriteArraySet<Cell> cells = game.getGrid();

        for (Component component : getComponents()) {
            Cell location = createCell(component);
            if (cells.contains(location)) {
                component.setBackground(SELECTION_COLOR);
            } else {
                component.setBackground(originalColor);
            }
        }
    }
}
