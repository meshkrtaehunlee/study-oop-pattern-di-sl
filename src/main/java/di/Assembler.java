package di;

import di.transcoder.FfmpegTranscoder;
import di.transcoder.FileJobQueue;
import di.transcoder.JobQueue;
import di.transcoder.Transcoder;
import di.transcoder.Worker;
import di.ui.JobCLI;

public class Assembler {
  private Worker worker;
  private JobCLI jobCLI;

  public void createAndWire() {
    // 애플리케이션 영영엑서 사용할 객체를 생성하고 생성자에 의존 객체를 주입해준다.
    JobQueue jobQueue = new FileJobQueue();
    Transcoder transcoder = new FfmpegTranscoder();

    // 실행 대상이 되는 객체를 제공하기 위해 생성
    this.worker = new Worker(jobQueue, transcoder);
    this.jobCLI = new JobCLI(jobQueue);
  }

  // 실행 대상이 되는 객체 제공
  public Worker getWorker() {
    return worker;
  }

  public JobCLI getJobCLI() {
    return jobCLI;
  }
}
