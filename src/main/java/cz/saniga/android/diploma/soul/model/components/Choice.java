package cz.saniga.android.diploma.soul.model.components;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.Answer;
import cz.saniga.android.diploma.soul.ui.choice.DefaultChoiceViewFactory;

public class Choice extends AbstractQuestion {

  // @Element(required = false)
  // private ChoiceUIComponentFactory uiFactory = new
  // DefaultChoiceViewFactory();

  @ElementList(required = false, entry = "answer")
  private List<Answer> answers = new ArrayList<Answer>();

  private Answer result;

  // UI
  private View choiceView;

  public View getUIComponent(Context context) {
    if (choiceView == null) {
      choiceView =
          DefaultChoiceViewFactory.getInstance().createChoiceView(context, this);
    }
    return choiceView;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public Answer getResult() {
    return result;
  }

  public void setResult(Answer result) {
    this.result = result;
  }

}
