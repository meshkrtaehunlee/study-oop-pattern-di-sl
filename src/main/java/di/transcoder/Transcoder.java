package di.transcoder;

import java.io.File;

public interface Transcoder {
  void transcode(File source, File target);
}
