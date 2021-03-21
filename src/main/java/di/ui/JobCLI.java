package di.ui;

import di.transcoder.JobData;
import di.transcoder.JobQueue;
import di.transcoder.Locator;
import java.util.Scanner;

public class JobCLI {
  private static final String EXIT_CODE = "exit";
  private JobQueue jobQueue;

  public JobCLI(JobQueue jobQueue) {
    this.jobQueue = jobQueue;
  }

  public void setJobQueue(JobQueue jobQueue) {
    this.jobQueue = jobQueue;
  }

  public void interact() {
    while(true) {
      printInputSourceMessage();
      String source = getSourceFromConsole();
      if(EXIT_CODE.equalsIgnoreCase(source)) return;
      printInputTargetMessage();
      String target = getTargetFromConsole();
      // 기존의 Locator에서는 Transcoder 타입의 의존까지 존재했기 때문에 불필ㄷ요한 의존이 발생했지만
      // 편-안
      // JobQueue jobQueue = Locator.getInstance().getJobQueue();
      jobQueue.addJob(new JobData(source, target));
    }
  }

  private String getTargetFromConsole() {
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }

  private String getSourceFromConsole() {
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }

  private void printInputTargetMessage() {
    System.out.println("source 입력:");
  }

  private void printInputSourceMessage() {
    System.out.printf("target 입력:(종료 시 \"%s\" 입력)\n", EXIT_CODE);
  }
}