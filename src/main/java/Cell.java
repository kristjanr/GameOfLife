import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Cell extends Point {
    HashSet<Cell> neighbours;

    public Cell(int x, int y) {
        super(x, y);
    }

    public boolean stayAlive(Set<Cell> grid) {
        int nrOfAliveNeighbours = countAliveNeighbours(grid);
        if (nrOfAliveNeighbours == 2 || nrOfAliveNeighbours == 3) {
            return true;
        } else return false;
    }

    private int countAliveNeighbours(Set<Cell> grid) {
        int count = 0;
        for (Cell cell : getNeighbours()) {
            if (grid.contains(cell)) {
                count++;
            }
        }
        return count;
    }


    public Collection<? extends Cell> giveBirthToNeighbours(Set<Cell> grid) {
        Set<Cell> newborn = new HashSet<Cell>();
        for (Cell cell : getNeighbours()) {
            if (cell.countAliveNeighbours(grid) == 3) {
                newborn.add(cell);
            }
        }
        return newborn;
    }

    private HashSet<Cell> getNeighbours() {
        if (neighbours == null) {
            HashSet<Cell> neighbours = new HashSet();
            Cell n1 = new Cell(x - 1, y - 1);
            Cell n2 = new Cell(x - 1, y);
            Cell n3 = new Cell(x - 1, y + 1);
            Cell n4 = new Cell(x, y - 1);
            Cell n5 = new Cell(x, y + 1);
            Cell n6 = new Cell(x + 1, y - 1);
            Cell n7 = new Cell(x + 1, y);
            Cell n8 = new Cell(x + 1, y + 1);
            neighbours.add(n1);
            neighbours.add(n2);
            neighbours.add(n3);
            neighbours.add(n4);
            neighbours.add(n5);
            neighbours.add(n6);
            neighbours.add(n7);
            neighbours.add(n8);
            this.neighbours = neighbours;
        }
        return neighbours;
    }
}
