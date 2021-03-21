package di;

import di.transcoder.FfmpegTranscoder;
import di.transcoder.FileJobQueue;
import di.transcoder.JobQueue;
import di.transcoder.Locator;
import di.transcoder.Transcoder;
import di.transcoder.Worker;
import di.ui.JobCLI;

public class Main {

  public static void main(String[] args) {
    // 저수준 모듈 객체 생성
    // 객체를 사용하기 위해선 이곳(메인영역)이 변경되어야 한다.
    // 메인영역은 애플리케이션에 의존하고 있으나, 애플리케이션영역은 메인에 의존하지 않으므로,
    // 메인영역이 변경되더라도 애플리케이션은 변경될 가능성이 없어 어떠한 영향도 끼치지 않는다.

    // 애플리케이션 영역에서 사용될 객체를 생성한다.
    JobQueue jobQueue = new FileJobQueue();
    Transcoder transcoder = new FfmpegTranscoder();

    // 각 객체 간의 의존 관계 설정, 고수준 모듈이 저수준 모듈을 사용할 수 있도록 콘크리트 클래스 주입
    // 애플리케이션 영역 실행
    final Worker worker = new Worker(jobQueue, transcoder);
    Thread t = new Thread(worker);
    t.start();
    JobCLI cli = new JobCLI(jobQueue);
    cli.interact();
  }

}
