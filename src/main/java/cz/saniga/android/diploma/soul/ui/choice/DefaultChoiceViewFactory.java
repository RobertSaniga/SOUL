package cz.saniga.android.diploma.soul.ui.choice;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.Answer;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class DefaultChoiceViewFactory implements ChoiceUIComponentFactory {

  private static final int[] RADIO_LABELS_IDS = { R.id.textView1, R.id.radioText2, R.id.textView3 };

  @Override
  public ChoiceView createChoiceView(Context context, Choice choice) {
    ChoiceView view = (ChoiceView) View.inflate(context, R.layout.choice_horizontal, null);

    TextView label = (TextView) view.findViewById(R.id.label);
    label.setText(choice.getLabel());
    view.setLabel(label);

    int index = 0;
    TextView optionLabel;
    RadioButton option;
    List<Answer> answers = choice.getAnswers();
    for (; index < answers.size(); index++) {
      Answer answer = answers.get(index);

      optionLabel = (TextView) view.findViewById(RADIO_LABELS_IDS[index]);
      optionLabel.setText(answer.getText());
      // option = (RadioButton) view.findViewById(RADIO_BUTTONS_IDS[index]);
      view.findViewById(ChoiceView.RADIO_BUTTONS_IDS[index]).setOnClickListener(view);
    }

    for (int i = index; i < RADIO_LABELS_IDS.length; i++) {
      view.findViewById(RADIO_LABELS_IDS[i]).setVisibility(View.INVISIBLE);
    }
    for (int i = index; i < ChoiceView.RADIO_BUTTONS_IDS.length; i++) {
      view.findViewById(ChoiceView.RADIO_BUTTONS_IDS[i]).setVisibility(View.INVISIBLE);
    }

    return view;
  }
}
