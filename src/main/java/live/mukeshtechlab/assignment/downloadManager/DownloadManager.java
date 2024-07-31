package live.mukeshtechlab.assignment.downloadManager;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class DownloadManager {

    private ExecutorService executorService;

    public DownloadManager(ExecutorService executorService){
        this.executorService = executorService;
    }

    public void downloadFiles(List<String> fileUrls){
        for(String url : fileUrls){
            DownloadTask downloadTask = new DownloadTask(url);
            executorService.execute(downloadTask);
        }
    }
    public void shutdown(){
        executorService.shutdown();
    }
}
