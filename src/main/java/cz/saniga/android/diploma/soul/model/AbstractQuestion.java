package cz.saniga.android.diploma.soul.model;

import org.simpleframework.xml.Attribute;

import cz.saniga.android.diploma.soul.model.components.HasUIComponent;

public abstract class AbstractQuestion implements HasUIComponent {

  @Attribute
  private String label;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
