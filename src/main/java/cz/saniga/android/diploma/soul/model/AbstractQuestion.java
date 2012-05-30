package cz.saniga.android.diploma.soul.model;

import org.simpleframework.xml.Attribute;

public abstract class AbstractQuestion implements HasUIComponent {

  @Attribute(required = false)
  private String label;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
