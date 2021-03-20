package di.transcoder;

public interface JobQueue {
  void addJob(JobData jobData);
  JobData getJob();
}
