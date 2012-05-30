package cz.saniga.android.diploma.soul.ui.choice;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.Answer;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class DefaultChoiceView extends AbstractChoiceView implements OnClickListener {

  public static final int[] RADIO_BUTTONS_IDS = { R.id.radio0, R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4 };
  private static final int[] RADIO_LABELS_IDS = { R.id.radioText0, R.id.radioText1, R.id.radioText2, R.id.radioText3,
      R.id.radioText4 };

  private Choice choice;

  public DefaultChoiceView(Context context, Choice choice) {
    super(context);
    inflate(context);
    initGraphic(choice);
  }

  private void inflate(Context context) {
    View.inflate(context, R.layout.choice_horizontal, this);
  }

  public void initGraphic(Choice choice) {
    this.choice = choice;

    TextView label = (TextView) findViewById(R.id.choiceHorizontalLabel);
    label.setText(choice.getLabel());

    int index = 0;
    List<Answer> answers = choice.getAnswers();
    for (; index < answers.size(); index++) {
      Answer answer = answers.get(index);

      // set radio button label
      TextView optionLabel = (TextView) findViewById(RADIO_LABELS_IDS[index]);
      optionLabel.setText(answer.getText());

      // set radio button
      RadioButton optionButton = (RadioButton) findViewById(DefaultChoiceView.RADIO_BUTTONS_IDS[index]);
      optionButton.setOnClickListener(this);
      if (answer.equals(choice.getResult())) {
        optionButton.setSelected(true);
      }
    }

    for (int i = index; i < RADIO_LABELS_IDS.length; i++) {
      findViewById(RADIO_LABELS_IDS[i]).setVisibility(View.INVISIBLE);
    }
    for (int i = index; i < DefaultChoiceView.RADIO_BUTTONS_IDS.length; i++) {
      findViewById(DefaultChoiceView.RADIO_BUTTONS_IDS[i]).setVisibility(View.INVISIBLE);
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
