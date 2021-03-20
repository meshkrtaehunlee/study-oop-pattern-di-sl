package di.transcoder;

public class Worker {
  public void run() {
    JobQueue jobQueue = null;
    Transcoder transcoder = null;


    while(true) {
      JobData jobData = jobQueue.getJob();
      transcoder.transcode(jobData.getSource(), jobData.getTarget());
    }
  }
}
