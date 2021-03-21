package di.transcoder;

public class Worker implements Runnable {
  // 직접 생성할 경우 콘크리트 클래스에 대한 의존이 발생하기 때문에 사용할 객체의 생성을 뒤로 미룬다.
  // 언제까지? 이 객체가 생성되는 시점, 혹은 필요한 객체를 설정하는 시점
  JobQueue jobQueue;
  Transcoder transcoder;

  public Worker(JobQueue jobQueue, Transcoder transcoder) {
    this.jobQueue = jobQueue;
    this.transcoder = transcoder;
  }

  @Override
  public void run() {
    while(true) {
      if(jobQueue.isEmpty()) continue;
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
