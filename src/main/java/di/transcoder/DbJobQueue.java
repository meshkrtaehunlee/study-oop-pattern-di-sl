package di.transcoder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class DbJobQueue implements JobQueue {
  BlockingQueue<JobData> queue = new LinkedBlockingDeque<>();

  @Override
  public void addJob(JobData jobData) {
    System.out.println("DbJobQueue작업을 저장합니다.");
    queue.add(jobData);
  }

  @Override
  public JobData getJob() {
    return queue.poll();
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }
}
