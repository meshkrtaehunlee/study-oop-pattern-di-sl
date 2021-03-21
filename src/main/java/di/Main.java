package di;

import di.transcoder.Worker;
import di.ui.JobCLI;

public class Main {

  public static void main(String[] args) {
    Assembler assembler = new Assembler();
    assembler.createAndWire();
    Worker worker = assembler.getWorker();
    JobCLI jobCLI = assembler.getJobCLI();
    new Thread(worker).start();
    jobCLI.interact();
  }

}
