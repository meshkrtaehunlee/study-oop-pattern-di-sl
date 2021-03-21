package di.ui;

import di.transcoder.JobData;
import di.transcoder.JobQueue;
import di.transcoder.Locator;
import java.util.Scanner;

public class JobCLI {
  private static final String EXIT_CODE = "exit";
  public void interact() {
    while(true) {
      printInputSourceMessage();
      String source = getSourceFromConsole();
      if(EXIT_CODE.equals(source)) return;
      printInputTargetMessage();
      String target = getTargetFromConsole();
      JobQueue jobQueue = Locator.getInstance().getJobQueue();
      jobQueue.addJob(new JobData(source, target));
    }
  }

  private String getTargetFromConsole() {
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }

  private String getSourceFromConsole() {
    System.out.printf("종료 시 \"%s\" 입력", EXIT_CODE);
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }

  private void printInputTargetMessage() {
    System.out.println("source 입력:");
  }

  private void printInputSourceMessage() {
    System.out.println("target 입력:");
  }
}