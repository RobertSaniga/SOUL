package cz.saniga.android.diploma.soul;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import cz.saniga.android.diploma.soul.model.Test;
import cz.saniga.android.diploma.soul.model.components.Choice;

public class TestActivity extends Activity {
	public static final String DATA = "data";

	LinearLayout content;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		content = (LinearLayout) findViewById(R.id.content);

		String url = getIntent().getStringExtra(DATA);
		Test test = loadTest(url);

		for (Choice ch : test.getSections().get(0).getChoices()) {
			Log.d(this.getClass().getName(), ch.getLabel());
			content.addView(ch.getUIComponent(this));
		}
	}

	private Test loadTest(String url) {
		Serializer serializer = new Persister();
		try {
			return serializer.read(Test.class, getResources().openRawResource(R.raw.test));
			// return serializer.read(Test.class,
			// getClass().getResourceAsStream(url));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
