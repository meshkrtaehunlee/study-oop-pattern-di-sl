package di.transcoder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileJobQueue implements JobQueue {
  BlockingQueue<JobData> queue = new LinkedBlockingQueue<>();

  @Override
  public void addJob(JobData jobData) {
    System.out.println("FileJobQueue에 작업을 저장합니다.");
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
