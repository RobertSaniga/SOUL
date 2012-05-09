package cz.saniga.android.diploma.soul.ui.old;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import cz.saniga.android.diploma.soul.MainActivity;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.old.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.old.Option;

public class UIComponentFactory {

	// TODO 2012-2-5: add i18n handling

	public static QuestionView createQuestionViewWithOptions(MainActivity activity,
			List<AbstractQuestion> questions, List<Option> answers) {
		LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		QuestionView questionView = (QuestionView) layoutInflater.inflate(R.layout.question_view, null);
		questionView.setActivity(activity);
		questionView.setQuestionById(questions, R.id.questionText);
		questionView.setOptionComponentsById(answers, R.id.radioGroup1, new int[] { R.id.radio0, R.id.radio1 });

		return questionView;
	}
}
