package cz.saniga.android.diploma.soul.ui;

import android.content.Context;
import cz.saniga.android.diploma.soul.model.Question;

public interface UIComponent {

	public abstract UIComponent newInstance(Context context, Class<? extends Question> question);
}
