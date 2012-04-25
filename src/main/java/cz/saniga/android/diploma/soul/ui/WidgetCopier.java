package cz.saniga.android.diploma.soul.ui;

import android.view.View;
import android.widget.TextView;

public class WidgetCopier {

	public static <T extends View> T copy(T result, T source) {
		if (source == null) {
			return result;
		}

		// properties to copy
		result.setLayoutParams(source.getLayoutParams());
		result.setPadding(source.getPaddingLeft(), source.getPaddingTop(), source.getPaddingRight(),
				source.getPaddingBottom());
		// ...

		if (result instanceof TextView && source instanceof TextView) {
			copyTextView(TextView.class.cast(result), TextView.class.cast(source));
		}

		return result;
	}

	private static void copyTextView(TextView result, TextView source) {
		// properties to copy
		result.setGravity(source.getGravity());
		// ...
	}
}
