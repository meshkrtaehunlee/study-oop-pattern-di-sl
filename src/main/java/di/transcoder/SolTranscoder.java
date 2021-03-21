package di.transcoder;

import java.io.File;

public class SolTranscoder implements Transcoder {
  private static final String id = "solution";

  @Override
  public void transcode(File source, File target) {
    System.out.printf("%s를 이용하여 %s파일을 %s파일로 변환합니다", id, source.getName(), target.getName());
  }
}
