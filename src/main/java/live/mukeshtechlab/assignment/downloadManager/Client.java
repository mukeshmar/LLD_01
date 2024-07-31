package live.mukeshtechlab.assignment.downloadManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        DownloadManager downloadManager = new DownloadManager(Executors.newFixedThreadPool(2));
        List<String> fileUrls = Arrays.asList("file1", "file2", "file3", "file4", "file5");
        downloadManager.downloadFiles(fileUrls);
        downloadManager.shutdown();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread is doing some work...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
