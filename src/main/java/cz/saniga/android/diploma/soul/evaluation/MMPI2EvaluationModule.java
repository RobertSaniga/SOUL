package cz.saniga.android.diploma.soul.evaluation;

import java.util.List;

import android.content.Intent;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.Page;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class MMPI2EvaluationModule implements EvaluationModule {

  @Override
  public Intent evaluate(List<Page> pages) {
    for (Page page : pages) {
      for (AbstractQuestion question : page.getQuestions()) {
        if (question instanceof Choice) {
          Choice choice = (Choice) question;
          choice.getResult().getValue();
        }
      }
    }

    return null; // TODO: intent with activity of results
  }

}
