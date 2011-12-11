package cz.saniga.android.diploma.soul;

import java.io.InputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import cz.saniga.android.diploma.soul.model.language.Languages;

public class HelloAndroidActivity extends Activity {

	private static String TAG = HelloAndroidActivity.class.getName();

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
		setContentView(R.layout.main);

		try {
			Serializer serializer = new Persister();
			InputStream source = getClass().getResourceAsStream("/language.xml");

			Languages langs = serializer.read(Languages.class, source);
			EditText textBox = (EditText) findViewById(R.id.editText1);
			textBox.setText(langs.getAnotherLangs().get(0).getDescript());

			Log.i(TAG, "DONE");

		} catch (Exception e) {
			Log.e(TAG, "CHYBA");
			e.printStackTrace();
		}

		// on screen output
		// ByteArrayOutputStream out = new ByteArrayOutputStream();
		// try {
		// serializer.write(, out);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// EditText textBox = (EditText) findViewById(R.id.editText1);
		// textBox.setText(out.toString());
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
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
