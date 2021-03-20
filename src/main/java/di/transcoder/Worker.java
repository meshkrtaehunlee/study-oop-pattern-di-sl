package di.transcoder;

public class Worker {
  public void run() {
    JobQueue jobQueue = Locator.getInstance().getJobQueue();
    Transcoder transcoder = Locator.getInstance().getTranscoder();

    while(true) {
      JobData jobData = jobQueue.getJob();
      transcoder.transcode(jobData.getSource(), jobData.getTarget());
    }
  }
}
