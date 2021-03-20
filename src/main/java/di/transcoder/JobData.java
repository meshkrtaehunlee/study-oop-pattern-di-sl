package di.transcoder;

import java.io.File;

public class JobData {
  private File source;
  private File target;

  public JobData(String source, String target) {
    this.source = new File(source);
    this.target = new File(target);
  }

  public File getSource() {
    return source;
  }

  public File getTarget() {
    return target;
  }
}
