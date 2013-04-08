import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

public class Tick extends TimerTask {

    private final Game game;

    public Tick(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        Set<Cell> grid = game.getGrid();
        Set<Cell> nextGenerationGrid = new CopyOnWriteArraySet<Cell>();
        for (Cell cell : grid) {
            if (cell.stayAlive(grid)) {
                nextGenerationGrid.add(cell);
            }
            nextGenerationGrid.addAll(cell.giveBirthToNeighbours(grid));
        }
        game.setGrid(nextGenerationGrid);
        Main.frame.repaint();
    }
}
