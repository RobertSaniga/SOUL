package cz.saniga.android.diploma.soul;

import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.Activity;
import android.os.Bundle;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.mmpi2.MMPI2;
import cz.saniga.android.diploma.soul.ui.QuestionView;
import cz.saniga.android.diploma.soul.ui.UIComponentFactory;

public class QuestionActivity extends Activity {

	private static String TAG = QuestionActivity.class.getName();

	MMPI2 mmpi2;

	// EvaluationModule evaluationModule;
	//
	// // !!!Pattern Strategy - popsat v DP!!!
	// public QuestionActivity(EvaluationModule evaluationModule) {
	// this.evaluationModule = evaluationModule;
	// }

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState If the activity is being re-initialized after
	 *          previously being shut down then this Bundle contains the data it
	 *          most recently supplied in onSaveInstanceState(Bundle). <b>Note:
	 *          Otherwise it is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		loadModel();

		QuestionView questionView = UIComponentFactory.createQuestionViewWithOptions(this, mmpi2.getQuestions(),
				mmpi2.getAnswers());
		setContentView(questionView);

		// try {
		// Serializer serializer = new Persister();
		// InputStream source = getClass().getResourceAsStream("/language.xml");
		//
		// Languages langs = serializer.read(Languages.class, source);
		// EditText textBox = (EditText) findViewById(R.id.editText1);
		// textBox.setText(langs.getAnotherLangs().get(0).getDescript());
		//
		// Log.i(TAG, "DONE");
		//
		// } catch (Exception e) {
		// Log.e(TAG, "CHYBA");
		// e.printStackTrace();
		// }

		// on screen output
		// ByteArrayOutputStream out = new ByteArrayOutputStream();
		// try {
		// serializer.write(, out);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// EditText textBox = (EditText) findViewById(R.id.editText1);
		// textBox.setText(out.toString());
	}

	@Override
	protected void onPause() {
		// TODO Zaridit ulozeni uzivatelskych dat - castecne vyplneny ale
		// nedokonceny dotaznik aj.
		// Souvisi s "todo" u metody onResume
		super.onPause();
	}

	// TODO je opravdu volano jen kdyz potrebuju (po vymazani prislusnych dat ->
	// musi byt reinicializovana)? Pro Honeycomb (>3.0) by mela byt dostacujici
	// metoda onStart() -
	// http://developer.android.com/reference/android/app/Activity.html#ActivityLifecycle
	@Override
	protected void onResume() {

		super.onStart();
	}

	// public void languageSerialize() {
	// // XML serializing
	// Serializer serializer = new Persister();
	//
	// // root element
	// Languages languages = new Languages();
	// languages.setVersion("0.1");
	//
	// // default
	// Language defaultLang = new Language();
	// defaultLang.setName("Čeština");
	// languages.setDefaultLang(defaultLang);
	//
	// // 2
	// Language language2 = new Language();
	// language2.setName("English");
	// languages.getAnotherLangsMap().put("eng", language2);
	//
	// // 3
	// Language language3 = new Language();
	// language3.setName("Deutsch");
	// languages.getAnotherLangsMap().put("de", language3);
	//
	// // serializing
	// File lang = new File("/sdcard/lang.xml");
	// try {
	// serializer.write(languages, lang);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	private MMPI2 loadModel() {
		Serializer serializer = new Persister();
		// InputStream resourceAsStream =
		// getClass().getResourceAsStream("/mmpi2.xml");
		try {
			mmpi2 = serializer.read(MMPI2.class, getResources().openRawResource(R.raw.mmpi2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mmpi2;
	}

	public void evaluateTest(List<AbstractQuestion> questions) {
		// this.evaluationModule.evaluate();
	}
}
