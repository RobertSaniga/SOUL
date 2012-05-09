package cz.saniga.android.diploma.soul.ui;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class AnotherChoiceViewFactory implements ChoiceViewFactory {

	@Override
	public View createChoiceView(Context context, Choice choice) {
		ChoiceView view = (ChoiceView) View.inflate(context, R.layout.choice_horizontal, null);

		TextView label = (TextView) view.findViewById(R.id.label);
		label.setText(choice.getLabel());
		view.setLabel(label);

		RadioButton option1 = (RadioButton) view.findViewById(R.id.radio0);
		// option1.
		return view;
	}

}
