package cz.saniga.android.diploma.soul.evaluation;

import java.util.List;

import android.content.Intent;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.Answer;
import cz.saniga.android.diploma.soul.model.Page;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class MMPI2EvaluationModule implements EvaluationModule {

  // TODO: porozmyslet o vyuziti Visitor!!!

  @Override
  public Intent evaluate(List<Page> pages) {
    for (Page page : pages) {
      for (AbstractQuestion question : page.getQuestions()) {
        if (question instanceof Choice) {
          Choice choice = (Choice) question;
          Answer result = choice.getResult();
          if (result != null) {
            result.getValue();
          }
        }
      }
    }

    return null; // TODO: intent with activity of results
  }

}
