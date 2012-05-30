package cz.saniga.android.diploma.soul.model.components;

import java.io.File;

import org.simpleframework.xml.Attribute;

public class ImageAnswer {

  // TODO: zakomponovat ziskavani obrazku pomoci app resourcu:
  // file:///C:/developing/android/android_sdk/docs/reference/android/content/res/Resources.html#getIdentifier%28java.lang.String,%20java.lang.String,%20java.lang.String%29

  @Attribute
  private File path;

  public File getPath() {
    return path;
  }

  public void setPath(File path) {
    this.path = path;
  }

}
