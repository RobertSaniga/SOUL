package cz.saniga.android.diploma.soul.model.components;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.model.Question;
import cz.saniga.android.diploma.soul.ui.ChoiceViewFactory;
import cz.saniga.android.diploma.soul.ui.DefaultChoiceViewFactory;

public class Choice extends Question /* implements hasUIComponent */{

	public View getUIComponent(Context context) {
		ChoiceViewFactory factory = new DefaultChoiceViewFactory();
		return factory.createChoiceView(context, this);
	}
}
