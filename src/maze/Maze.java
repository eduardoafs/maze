package maze;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.*;

public class Maze {
    private int x;
    private int y;
    private Cell[][] maze;
    HashMap<Cell, Cell> parent;

    public Maze(int x, int y) {
        this.x = x;
        this.y = y;
        parent = new HashMap<>();
        maze = new Cell[x][y];
        for (int i=0;i<x;i++) {
            maze[i] = new Cell[y];
            for (int j=0;j<y;j++) {
                maze[i][j] = new Cell(i,j);
            }
        }
        init();
        generate();
    }

    private void init() {

    }


    private Set<Cell> visited;
    // generate the maze
    private void generate() {
        System.out.println("Generating maze...");
        SecureRandom randomizer = new SecureRandom();
        // start position = (1,1)
        visited = new HashSet<>();
        maze[0][1].clear();
        Cell position = maze[1][1];
        parent.put(position, maze[0][1]);

        // TODO busca em profundidade aleatória
        generate(position);
        maze[x-1][y-2].clear();
        parent.put(maze[x-1][y-2], maze[x-2][y-2]);
        printMaze();
    }

    private void generate(Cell start) {
        if (visited.contains(start)) return;
        List<Cell> possible = allMoves(start);
        visited.add(start);
        for (Cell c : possible) {
            if (!visited.contains(c)) {
                parent.put(c, start);
                destroyWall(c, start);
                generate(c);
            }
        }
    }

    private void printMaze() {
        System.out.println();
        for (int i=0; i<x;i++) {
            for (int j=0;j<y;j++) {
                System.out.print((char) maze[i][j].value);
            }
            System.out.println();
        }
    }

    private void destroyWall(Cell position, Cell previous) {
        if (previous==position) return; // do nothing
        else {
            int posx = (position.x + previous.x)/2;
            int posy = (position.y + previous.y)/2;
            Cell target = maze[posx][posy];
            target.clear();
            parent.put(position, target);
            parent.put(target, previous);
        }
    }

    private List<Cell> allMoves(Cell position) {
        List<Cell> moves = new ArrayList<>();
        int posx = position.x;
        int posy = position.y;

        // north
        Cell north = posx-2 >= 0? maze[posx-2][posy] : null;
        Cell south = posx+2 < this.x? maze[posx+2][posy] : null;
        Cell west = posy-2 >= 0? maze[posx][posy-2] : null;
        Cell east = posy+2 < this.y? maze[posx][posy+2] : null;

        if (north!=null) moves.add(north);
        if (south!=null) moves.add(south);
        if (west!=null) moves.add(west);
        if (east!=null) moves.add(east);

        Collections.shuffle(moves);
        return moves;
    }
    private void solution() {
        Cell m = maze[x-1][y-2];
        Stack stack = new Stack();

        while (m!=maze[0][1]) {
            stack.push(m);
            m = parent.get(m);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Maze m = new Maze(11, 11);
        System.out.println("Solution:");
        m.solution();
    }

}