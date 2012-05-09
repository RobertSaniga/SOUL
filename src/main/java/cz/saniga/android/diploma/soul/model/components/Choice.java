package cz.saniga.android.diploma.soul.model.components;

import org.simpleframework.xml.Element;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.model.Question;
import cz.saniga.android.diploma.soul.ui.ChoiceViewFactory;
import cz.saniga.android.diploma.soul.ui.DefaultChoiceViewFactory;

public class Choice extends Question /* implements hasUIComponent */{

	@Element(required = false)
	ChoiceViewFactory uiFactory = new DefaultChoiceViewFactory();

	public View getUIComponent(Context context) {
		return uiFactory.createChoiceView(context, this);
	}
}
