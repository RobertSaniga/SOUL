package cz.saniga.android.diploma.soul.model.components;

import java.util.List;

import org.simpleframework.xml.ElementList;

import android.content.Context;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.HasUIComponent;
import cz.saniga.android.diploma.soul.ui.imagechoice.DefaultImageChoiceView;

public class ImageChoice extends AbstractQuestion implements HasUIComponent {

  @ElementList(entry = "answer")
  private List<ImageAnswer> answers;

  private ImageAnswer selected;

  @Override
  public DefaultImageChoiceView getUIComponent(Context context) {
    return new DefaultImageChoiceView(context, this);
  }

  public List<ImageAnswer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<ImageAnswer> answers) {
    this.answers = answers;
  }

  public ImageAnswer getSelected() {
    return selected;
  }

  public void setSelected(ImageAnswer selected) {
    this.selected = selected;
  }

}
