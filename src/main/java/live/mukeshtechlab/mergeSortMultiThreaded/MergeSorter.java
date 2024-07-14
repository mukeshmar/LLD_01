package live.mukeshtechlab.mergeSortMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> listToSort;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> listToSort, ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        // MergeSort logic with Multithreading
        int N = listToSort.size();
        if (N <= 1) {
            return listToSort;
        }

        List<Integer> leftHalf = new ArrayList<>(listToSort.subList(0, N / 2));
        List<Integer> rightHalf = new ArrayList<>(listToSort.subList(N / 2, N));

        // Create the Task
        MergeSorter leftMergeSorter = new MergeSorter(leftHalf, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightHalf, executorService);

        Future<List<Integer>> leftSortedListFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedListFuture = executorService.submit(rightMergeSorter);

        // Now we need to merge two sorted Lists
        List<Integer> leftSortedList = leftSortedListFuture.get();
        List<Integer> rightSortedList = rightSortedListFuture.get();

        return merge(leftSortedList, rightSortedList);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sortedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                sortedList.add(left.get(i));
                i++;
            } else {
                sortedList.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            sortedList.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            sortedList.add(right.get(j));
            j++;
        }

        return sortedList;
    }
}
