package cz.saniga.android.diploma.soul;

import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cz.saniga.android.diploma.soul.model.Test;
import cz.saniga.android.diploma.soul.model.old.AbstractQuestion;

public class MainActivity extends Activity {

  private static String TAG = MainActivity.class.getName();

  Test test;

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

    Intent i = new Intent(this, TestActivity.class);
    i.putExtra(TestActivity.DATA, "url");
    startActivity(i);
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

  private void loadModel() {
    Serializer serializer = new Persister();
    // InputStream resourceAsStream =
    // getClass().getResourceAsStream("/mmpi2.xml");
    try {
      test = serializer.read(Test.class, getResources().openRawResource(R.raw.test));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void evaluateTest(List<AbstractQuestion> questions) {
    // this.evaluationModule.evaluate();
  }
}
