package cz.saniga.android.diploma.soul.model.old;

import org.simpleframework.xml.Attribute;

public class AbstractQuestion extends AbstractSimpleLocalizedType {

  @Attribute
  private int id;

  private int result;

  public int getId() {
    return id;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
