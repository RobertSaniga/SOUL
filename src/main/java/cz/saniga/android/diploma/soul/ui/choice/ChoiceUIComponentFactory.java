package cz.saniga.android.diploma.soul.ui.choice;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.model.components.Choice;

public interface ChoiceUIComponentFactory {

  public View createChoiceView(Context context, Choice choice);

}
