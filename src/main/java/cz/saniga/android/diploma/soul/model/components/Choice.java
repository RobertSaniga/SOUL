package cz.saniga.android.diploma.soul.model.components;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import android.content.Context;
import android.view.View;
import cz.saniga.android.diploma.soul.model.Answer;
import cz.saniga.android.diploma.soul.model.Question;
import cz.saniga.android.diploma.soul.ui.choice.ChoiceUIComponentFactory;
import cz.saniga.android.diploma.soul.ui.choice.DefaultChoiceViewFactory;

public class Choice extends Question {

	@Element(required = false)
	private ChoiceUIComponentFactory uiFactory = new DefaultChoiceViewFactory();

	@ElementList(required = false, entry = "answer")
	private List<Answer> answers = new ArrayList<Answer>();

	// UI
	private View choiceView;

	public View getUIComponent(Context context) {
		if (choiceView == null) {
			choiceView = uiFactory.createChoiceView(context, this);
		}
		return choiceView;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
