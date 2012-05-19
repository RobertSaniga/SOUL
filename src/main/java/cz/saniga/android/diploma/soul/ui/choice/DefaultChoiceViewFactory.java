package cz.saniga.android.diploma.soul.ui.choice;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class DefaultChoiceViewFactory implements ChoiceUIComponentFactory {

  @Override
  public ChoiceView createChoiceView(Context context, Choice choice) {
    ChoiceView view = (ChoiceView) View.inflate(context, R.layout.choice_horizontal, null);
    view.setGraphic(choice);
    return view;
  }
}
