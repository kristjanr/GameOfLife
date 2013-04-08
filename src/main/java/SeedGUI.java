import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class SeedGUI extends Grid {

    public SeedGUI() {
        super();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JPanel panel = (JPanel) getComponentAt(e.getPoint());
                if (panel == null || panel == SeedGUI.this) {
                    return;
                }
                if (panel.getBackground() == originalColor) {
                    panel.setBackground(SELECTION_COLOR);
                    panel.revalidate();
                    panel.repaint();
                } else {
                    panel.setBackground(originalColor);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
    }
    // constructor ends here
    public Set getSeeds() {
        Set seeds = new HashSet<Cell>();
        for (Component component : this.getComponents()) {
            if (component.getBackground() != originalColor) {
                Cell cell = createCell(component);
                seeds.add(cell);
            }
        }
        return seeds;
    }
}