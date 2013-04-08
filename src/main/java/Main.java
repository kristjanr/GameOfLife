
import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Main {
    public static JFrame frame;
    private static Game game;
    public static TickGUI tickGUI;

    public static void main(String args[]) {
        seedGUI();
        game = new Game();
    }

    private static void tickingGUI(Game game) {
        tickGUI = new TickGUI(game);
        drawFrame(tickGUI);
    }

    private static void seedGUI() {
        SeedGUI seedGUI = new SeedGUI();
        Buttons buttons = new Buttons();
        buttons.setSeedGUI(seedGUI);
        buttons.setTickGUI(tickGUI);
        buttons.setGame(game);
        buttons.setOpaque(true); //content panes must be opaque
        frame = new JFrame("TheGame");
        frame.getContentPane().add(buttons, BorderLayout.WEST);

        drawFrame(seedGUI);
    }

    private static void drawFrame(JPanel panel) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void startTicking(Set seeds) {
        game.seed(seeds);
        tickingGUI(game);
        game.start();
    }

    public static void stopTicking() {
        game.getTickTimer().cancel();
    }
}
