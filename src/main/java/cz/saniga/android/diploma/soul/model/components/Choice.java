package cz.saniga.android.diploma.soul.model.components;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import android.content.Context;
import android.util.Log;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.Answer;
import cz.saniga.android.diploma.soul.ui.choice.AbstractChoiceView;
import cz.saniga.android.diploma.soul.ui.choice.DefaultChoiceView;

public class Choice extends AbstractQuestion {

  @Attribute(required = false)
  private String uiClass;

  @ElementList(required = false, entry = "answer")
  private List<Answer> answers = new ArrayList<Answer>();

  private Answer result;

  // UI
  private AbstractChoiceView choiceView;

  public AbstractChoiceView getUIComponent(Context context) {
    // TODO: popremyslet o Object pool(ingu)
    if (choiceView == null) {
      if (uiClass != null) {
        try {
          choiceView = (AbstractChoiceView)
              Class.forName(uiClass).getConstructor(Context.class, Choice.class).newInstance(context, this);
          return choiceView;

        } catch (Exception e) {
          Log.w(getClass().getName(), "Problem s vytvorenim UI komponenty", e);
        }
      }

      // in another cases create choice with default UI
      choiceView = new DefaultChoiceView(context, this);
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
