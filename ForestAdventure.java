import java.util.Scanner;
public class ForestAdventure {
    private static final char PLAYER = 'P';
    private static final char TREE = 'T';
    private static final char EMPTY = '.';
    private static final char EXIT = 'E';
    private static char[][] forest;
    private static int playerRow;
    private static int playerCol;
    public static void main(String[] args) {
        initializeForest();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printForest();
            System.out.println("Enter a move (WASD to move, Q to quit): ");
            char move = scanner.next().charAt(0);
            if (move == 'Q' || move == 'q') {
                System.out.println("Thanks for playing!");
                break;
            }
            makeMove(move);
            if (forest[playerRow][playerCol] == EXIT) {
                System.out.println("Congratulations! You found the exit!");
                break;
            }
        }
        scanner.close();
    }
    private static void initializeForest() {
        forest = new char[][] {
            {'.', '.', 'T', '.', 'E'},
            {'.', 'T', '.', '.', 'T'},
            {'.', '.', '.', 'T', '.'},
            {'T', '.', 'T', '.', '.'},
            {'P', '.', '.', '.', '.'}
        };
        playerRow = 4;
        playerCol = 0;
    }
    private static void printForest() {
        for (char[] row : forest) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    private static void makeMove(char move) {
        int newRow = playerRow;
        int newCol = playerCol;
        switch (move) {
            case 'W':
            case 'w':
                newRow--;
                break;
            case 'A':
            case 'a':
                newCol--;
                break;
            case 'S':
            case 's':
                newRow++;
                break;
            case 'D':
            case 'd':
                newCol++;
                break;
            default:
                System.out.println("Invalid move. Use WASD to move.");
                return;
        }
        if (isValidMove(newRow, newCol)) {
            forest[playerRow][playerCol] = EMPTY;
            playerRow = newRow;
            playerCol = newCol;
            forest[playerRow][playerCol] = PLAYER;
        } else {
            System.out.println("Invalid move. You can't move there.");
        }
    }
    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= forest.length || col < 0 || col >= forest[0].length) {
            return false;
        }
        return forest[row][col] == EMPTY || forest[import java.util.Scanner;

    }
}
][col] == EXIT;
    }
}
