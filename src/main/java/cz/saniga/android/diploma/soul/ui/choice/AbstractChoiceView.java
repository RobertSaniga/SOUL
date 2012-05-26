package cz.saniga.android.diploma.soul.ui.choice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import cz.saniga.android.diploma.soul.model.components.Choice;

public abstract class AbstractChoiceView extends FrameLayout {

  public AbstractChoiceView(Context context) {
    super(context);
  }

  public AbstractChoiceView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public AbstractChoiceView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public abstract void initGraphic(Choice choice);
}
