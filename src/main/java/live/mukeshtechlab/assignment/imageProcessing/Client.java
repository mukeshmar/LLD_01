package live.mukeshtechlab.assignment.imageProcessing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        int[][] oriArr = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        };

        int N = oriArr.length;
        int M = oriArr[0].length;

        int midRow = N/2;
        int midCol = M/2;

        // Create four Task
        ArrayRepainter p1 = new ArrayRepainter(oriArr, 0, midRow - 1, 0, midCol - 1);
        ArrayRepainter p2 = new ArrayRepainter(oriArr, 0, midRow - 1, midCol, M - 1);
        ArrayRepainter p3 = new ArrayRepainter(oriArr, midRow, N - 1, midRow, midCol - 1);
        ArrayRepainter p4 = new ArrayRepainter(oriArr, midRow, N - 1, midRow, M - 1);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);
        executorService.execute(p4);

        // Shutdown the Executor Service
        executorService.shutdown();

        executorService.awaitTermination(60, TimeUnit.SECONDS);

        for(int[] arr : oriArr){
            System.out.println(Arrays.toString(arr));
        }


    }
}
