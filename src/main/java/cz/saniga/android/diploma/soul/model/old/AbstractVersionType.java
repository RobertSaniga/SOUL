package cz.saniga.android.diploma.soul.model.old;

import org.simpleframework.xml.Attribute;

public abstract class AbstractVersionType {

  @Attribute
  private String version;

  public String getVersion() {
    return version;
  }

}
