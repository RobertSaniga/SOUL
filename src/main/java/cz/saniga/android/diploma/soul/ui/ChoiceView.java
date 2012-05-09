package cz.saniga.android.diploma.soul.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ChoiceView extends LinearLayout /* implements UIComponent */{

	private TextView label;
	private RadioButton option1;
	private RadioButton option2;
	private RadioButton option3;
	private RadioButton option4;
	private RadioButton option5;

	public ChoiceView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TextView getLabel() {
		return label;
	}

	public void setLabel(TextView label) {
		this.label = label;
	}

}
