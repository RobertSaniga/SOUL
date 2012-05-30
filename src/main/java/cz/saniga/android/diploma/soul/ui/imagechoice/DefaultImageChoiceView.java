package cz.saniga.android.diploma.soul.ui.imagechoice;

import java.io.InputStream;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import cz.saniga.android.diploma.soul.MainActivity;
import cz.saniga.android.diploma.soul.R;
import cz.saniga.android.diploma.soul.model.components.Choice;
import cz.saniga.android.diploma.soul.model.components.ImageChoice;
import cz.saniga.android.diploma.soul.ui.choice.AbstractChoiceView;

public class DefaultImageChoiceView extends AbstractChoiceView {

  public static final int[] RADIO_BUTTONS_IDS = { R.id.radio0, R.id.radio1, R.id.radio2, R.id.radio3, R.id.radio4 };

  public DefaultImageChoiceView(Context context, ImageChoice choice) {
    super(context);
    inflate(context);
    initGraphic(choice);
  }

  private void inflate(Context context) {
    View.inflate(context, R.layout.image_choice, this);
  }

  public void initGraphic(ImageChoice choice) {
    ImageView option0 = (ImageView) findViewById(R.id.option0);

    String path = MainActivity.PATH + choice.getAnswers().get(0).getPath().getPath();
    InputStream inputStream = getClass().getResourceAsStream(path);
    option0.setImageDrawable(Drawable.createFromStream(inputStream, ""));
  }

  @Override
  public void initGraphic(Choice choice) {
    // TODO Auto-generated method stub

  }

}
