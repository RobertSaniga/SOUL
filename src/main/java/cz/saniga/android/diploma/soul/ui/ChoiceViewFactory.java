package cz.saniga.android.diploma.soul.ui;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.model.components.Choice;

public interface ChoiceViewFactory {

	public View createChoiceView(Context context, Choice choice);

}
