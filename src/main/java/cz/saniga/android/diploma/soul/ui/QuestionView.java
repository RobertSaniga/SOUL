package cz.saniga.android.diploma.soul.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import cz.saniga.android.diploma.soul.QuestionActivity;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.Option;

public class QuestionView extends LinearLayout implements OnClickListener {

	List<AbstractQuestion> questions;
	private List<Option> options;
	int index = 0;

	private TextView questionTextView;
	private List<RadioButton> optionsRadioButtons;

	private Button nextButton;
	private RadioGroup radioGroup;
	private QuestionActivity activity;

	public QuestionView(Context context) {
		super(context);
	}

	// public QuestionView(Context context, AttributeSet attrs, AbstractQuestion
	// question, List<Option> options) {
	public QuestionView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		nextButton = (Button) findViewById(R.id.button1);
		// nextButton.setOnClickListener(this);
		super.onFinishInflate();
	}

	//
	// public QuestionView(Context context, AbstractQuestion question,
	// List<Option> answers) {
	// QuestionView questionView = (QuestionView)
	// LayoutInflater.from(getContext()).inflate(R.layout.question_view, null);
	// questionView.setQuestionById(R.id.questionText);
	// questionView.setOptionComponentsById(answers, R.id.radioGroup1, new int[] {
	// R.id.radio0, R.id.radio1 });
	//
	// // to trim white characters and escape sequences
	// String trimmedQuestionText = question.getDefaultText().trim();
	// questionView.getQuestion().setText(trimmedQuestionText);
	// }

	public void setQuestionById(List<AbstractQuestion> questions, int id) {
		this.questions = questions;
		questionTextView = (TextView) findViewById(id);

		setQuestionText(questions.get(0));
	}

	private void setQuestionText(AbstractQuestion abstractQuestion) {
		// to trim white characters and escape sequences
		String trimmedQuestionText = abstractQuestion.getDefaultText().trim();
		questionTextView.setText(trimmedQuestionText);
	}

	public TextView getQuestion() {
		return questionTextView;
	}

	public void setOptionComponentsById(List<Option> options, int radioGroupId, int[] radioButtonsIds) {
		this.options = options;
		optionsRadioButtons = new ArrayList<RadioButton>(options.size());
		RadioButton radioButton = null;
		radioGroup = (RadioGroup) findViewById(radioGroupId);

		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getDefaultText().trim();
			if (i >= radioButtonsIds.length) {
				RadioButton clonedRadioButton = WidgetCopier.copy(new RadioButton(getContext()), radioButton);
				clonedRadioButton.setId(i);
				clonedRadioButton.setText(text);
				optionsRadioButtons.add(clonedRadioButton);
				radioGroup.addView(clonedRadioButton);
			} else {
				radioButton = (RadioButton) findViewById(radioButtonsIds[i]);
				radioButton.setId(i);
				radioButton.setText(text);
				optionsRadioButtons.add(radioButton);
			}
		}
	}

	@Override
	public void onClick(View v) {
		if (v.equals(nextButton)) {
			if (validate()) {
				evaluateQuestion();

				if (index < questions.size()) {
					setQuestionText(questions.get(index));
					radioGroup.clearCheck();
				} else {
					// ukonci, uloz, zobraz vysledky
					activity.evaluateTest(questions);
				}
			}
		}
	}

	private void evaluateQuestion() {
		Option option = options.get(radioGroup.getCheckedRadioButtonId());
		questions.get(index++).setResult(option.getValue());
	}

	private boolean validate() {
		if (radioGroup.getCheckedRadioButtonId() == -1) {
			Toast.makeText(getContext(), "Musite vybrat nejakou hodnotu", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	public void setActivity(QuestionActivity activity) {
		this.activity = activity;
	}
}
