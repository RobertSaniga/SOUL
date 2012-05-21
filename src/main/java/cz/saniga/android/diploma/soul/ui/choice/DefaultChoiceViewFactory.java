package cz.saniga.android.diploma.soul.ui.choice;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.components.Choice;

/**
 * Singleton
 * 
 * @author Robinek
 * 
 */
public class DefaultChoiceViewFactory implements ChoiceUIComponentFactory {

  private static DefaultChoiceViewFactory uniqueInstance;

  private DefaultChoiceViewFactory() {
  }

  public static synchronized DefaultChoiceViewFactory getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new DefaultChoiceViewFactory();
    }
    return uniqueInstance;
  }

  @Override
  public View createChoiceView(Context context, Choice choice) {
    ChoiceView view = (ChoiceView) View.inflate(context, R.layout.choice_horizontal, null);
    view.setGraphic(choice);
    return view;
  }
}
