package di.transcoder;

public class Worker implements Runnable {

  @Override
  public void run() {
    JobQueue jobQueue = Locator.getInstance().getJobQueue();
    Transcoder transcoder = Locator.getInstance().getTranscoder();

    while(true) {
      if(jobQueue.isEmpty()) continue;;
      JobData jobData = jobQueue.getJob();
      transcoder.transcode(jobData.getSource(), jobData.getTarget());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
