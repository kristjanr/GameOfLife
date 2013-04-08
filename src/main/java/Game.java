import java.util.Set;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArraySet;

public class Game {
    private CopyOnWriteArraySet<Cell> grid;
    Timer tickTimer;

    public Game() {
        grid = new CopyOnWriteArraySet<Cell>();
    }

    public void start() {
        tickTimer = new Timer("tickTimer");
        Tick tick = new Tick(this);
        tickTimer.schedule(tick, 0, 1000 / 5);
    }

    public void seed(Set set) {
        grid.addAll(set);
    }

    public CopyOnWriteArraySet<Cell> getGrid() {
        return grid;
    }

    public void setGrid(Set<Cell> grid) {
        this.grid = (CopyOnWriteArraySet<Cell>) grid;
    }

    public Timer getTickTimer() {
        return tickTimer;
    }
}