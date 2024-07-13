package live.mukeshtechlab.concurrency_2.MergeSortMultiThreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(3, 2, 1, 4, 6, 8, 7, 5);

        // ExecutorService
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Create MergeSorter Task
        MergeSorter mergeSorter = new MergeSorter(listToSort, executorService);

        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);

        // PrintSorted List
        List<Integer> sortedList = sortedListFuture.get();
        executorService.shutdown();
        System.out.println(sortedList);
    }
}
