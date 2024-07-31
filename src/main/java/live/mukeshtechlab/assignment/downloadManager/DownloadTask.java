package live.mukeshtechlab.assignment.downloadManager;

public class DownloadTask implements Runnable {
    private String fileUrl;

    public DownloadTask(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        for(int progress = 0; progress <= 100; progress += 10){
            System.out.println("Progress for " + fileUrl + ": " + progress + "%");
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException interruptedException){
                System.out.println(interruptedException.getMessage());
            }
        }
    }
}
