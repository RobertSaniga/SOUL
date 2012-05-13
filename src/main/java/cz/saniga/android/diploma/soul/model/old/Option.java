package cz.saniga.android.diploma.soul.model.old;

import org.simpleframework.xml.Attribute;

public class Option extends AbstractSimpleLocalizedType implements Valueable {

  @Attribute
  private int value;

  @Override
  public int getValue() {
    return value;
  }
}
