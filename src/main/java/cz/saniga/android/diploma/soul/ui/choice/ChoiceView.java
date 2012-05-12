package cz.saniga.android.diploma.soul.ui.choice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import cz.saniga.android.diploma.soul.R;

public class ChoiceView extends LinearLayout implements OnClickListener {

	public static final int[] RADIO_BUTTONS_IDS = { R.id.radio0, R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4 };

	private TextView label;
	private RadioButton option1;
	// private TextView optionLabel2;
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

	@Override
	public void onClick(View v) {
		for (int i = 0; i < RADIO_BUTTONS_IDS.length; i++) {
			RadioButton radioButton = (RadioButton) findViewById(RADIO_BUTTONS_IDS[i]);
			if (!radioButton.equals(v)) {
				radioButton.setChecked(false);
			}
		}
	}

}
