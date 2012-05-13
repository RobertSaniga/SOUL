package cz.saniga.android.diploma.soul.model.old;

import org.simpleframework.xml.Text;

public class InternationalizedText extends AbstractInternationalizedType {

  @Text
  private String text;

  public String getText() {
    return text;
  }

}
