package live.mukeshtechlab.assignment.imageProcessing;

import java.util.concurrent.ExecutorService;

public class ArrayRepainter implements Runnable {
    private final int[][] array;
    private int startRow;
    private int endRow;
    private int startCol;
    private int endCol;

    public ArrayRepainter(int[][] array, int startRow, int endRow, int startCol, int endCol){
        this.array = array;
        this.startRow = startRow;
        this.endRow = endRow;
        this.startCol = startCol;
        this.endCol = endCol;
    }

    @Override
    public void run() {
        for(int row = startRow; row <= endRow; row++){
            for(int col = startCol; col<= endCol; col++){
                array[row][col] = array[row][col] * 2; // Repainting Array by multiplying values with 2
            }
        }
    }
}
