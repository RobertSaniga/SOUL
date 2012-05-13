package cz.saniga.android.diploma.soul.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

public class Answer {

  @Attribute
  private int value;

  @Text
  private String text;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}
