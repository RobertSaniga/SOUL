package cz.saniga.android.diploma.soul.ui.choice;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.Answer;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class ChoiceView extends LinearLayout implements OnClickListener {

  public static final int[] RADIO_BUTTONS_IDS = { R.id.radio0, R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4 };
  private static final int[] RADIO_LABELS_IDS = { R.id.textView1, R.id.radioText2, R.id.textView3 };

  private Choice choice;

  // default constructor for inflation (of xml layout)
  public ChoiceView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void setGraphic(Choice choice) {
    this.choice = choice;

    TextView label = (TextView) findViewById(R.id.label);
    label.setText(choice.getLabel());

    int index = 0;
    List<Answer> answers = choice.getAnswers();
    for (; index < answers.size(); index++) {
      Answer answer = answers.get(index);

      TextView optionLabel = (TextView) findViewById(RADIO_LABELS_IDS[index]);
      optionLabel.setText(answer.getText());

      findViewById(ChoiceView.RADIO_BUTTONS_IDS[index]).setOnClickListener(this);
    }

    for (int i = index; i < RADIO_LABELS_IDS.length; i++) {
      findViewById(RADIO_LABELS_IDS[i]).setVisibility(View.INVISIBLE);
    }
    for (int i = index; i < ChoiceView.RADIO_BUTTONS_IDS.length; i++) {
      findViewById(ChoiceView.RADIO_BUTTONS_IDS[i]).setVisibility(View.INVISIBLE);
    }
  }

  @Override
  public void onClick(View v) {
    for (int i = 0; i < RADIO_BUTTONS_IDS.length; i++) {
      RadioButton radioButton = (RadioButton) findViewById(RADIO_BUTTONS_IDS[i]);
      if (!radioButton.equals(v)) {
        // check out other radio buttons
        radioButton.setChecked(false);
      } else {
        // set selected answer
        choice.setResult(choice.getAnswers().get(i));
      }
    }
  }

}
