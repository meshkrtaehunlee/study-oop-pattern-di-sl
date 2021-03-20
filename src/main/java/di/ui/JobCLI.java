package di.ui;

import di.transcoder.JobData;
import di.transcoder.JobQueue;
import di.transcoder.Locator;
import java.util.Scanner;

public class JobCLI {
  public void interact() {
    printInputSourceMessage();
    String source = getSourceFromConsole();
    printInputTargetMessage();
    String target = getTargetFromConsole();
    JobQueue jobQueue = Locator.getInstance().getJobQueue();
    jobQueue.addJob(new JobData(source, target));
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
    System.out.println("target 입력:");
  }
}