import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel implements ActionListener {
    protected JButton startButton;
    protected JButton stopButton;
    protected JButton newGameButton;
    protected JButton clearButton;
    SeedGUI seedGUI;
    TickGUI tickGUI;
    Box box;
    Game game;

    public Buttons() {
        box = Box.createVerticalBox();
        startButton = newButton("Start", true);
        stopButton = newButton("Stop", false);
        newGameButton = newButton("Again", false);
        clearButton = newButton("Clear", true);
        box.add(startButton);
        box.add(stopButton);
        box.add(newGameButton);
        box.add(clearButton);
        add(box);
    }

    private JButton newButton(String name, boolean isEnabled) {
        JButton button = new JButton(name);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.LEADING);
        button.addActionListener(this);
        button.setEnabled(isEnabled);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(startButton)) {
            start();
        } else if (e.getSource().equals(stopButton)) {
            finish();
        } else if (e.getSource().equals(newGameButton)) {
            newGame();
        } else if (e.getSource().equals(clearButton)) {
            clear();
        }
    }

    private void clear() {
        if (game != null)
            game.getGrid().clear();
        if (seedGUI != null)
            seedGUI.clear();
        if (tickGUI != null)
            tickGUI.clear();
    }

    private void finish() {
        Main.stopTicking();
        stopButton.setEnabled(false);
        newGameButton.setEnabled(true);
    }

    private void newGame() {
        Main.tickGUI.setVisible(false);
        seedGUI.setVisible(true);
        startButton.setEnabled(true);
        newGameButton.setEnabled(false);
        clearButton.setEnabled(true);
    }

    private void start() {
        Main.startTicking(seedGUI.getSeeds());
        seedGUI.setVisible(false);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        clearButton.setEnabled(false);
    }

    public void setSeedGUI(SeedGUI seedGUI) {
        this.seedGUI = seedGUI;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setTickGUI(TickGUI tickGUI) {
        this.tickGUI = tickGUI;
    }
}


