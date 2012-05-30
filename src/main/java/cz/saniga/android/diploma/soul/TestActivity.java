package cz.saniga.android.diploma.soul;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.CycleStrategy;
import org.simpleframework.xml.strategy.Strategy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.Page;
import cz.saniga.android.diploma.soul.model.Section;
import cz.saniga.android.diploma.soul.model.Test;

public class TestActivity extends Activity {

  public static final String DATA = "data";

  private LinearLayout innerContent;

  private List<Page> pagesContents = new ArrayList<Page>();
  private int pageIndex = 0;
  private int pageIndexMax = 0;

  private Button nextButton;
  private Button backButton;

  private Test test;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    innerContent = (LinearLayout) findViewById(R.id.content);

    String url = getIntent().getStringExtra(DATA);
    test = loadTest(url);
    preparePagesContents(test);

    setPageContent();

    // navigation
    nextButton = (Button) findViewById(R.id.nextButton);
    backButton = (Button) findViewById(R.id.backButton);
    nextButton.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        if (pageIndex < pagesContents.size() - 1) {
          innerContent.removeAllViews();
          pageIndex++;
          setPageContent();
        } else {
          /*
           * TODO: Use another thread to evaluation. Main thread use for
           * "Please wait" bar
           */

          // evaluate test and return Intent with new Activity to draw
          // Intent evaluationResults =
          // test.getEvaluationModule().evaluate(pagesContents);
          // startActivity(evaluationResults);
        }
      }
    });
    backButton.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        if (pageIndex > 0) {
          innerContent.removeAllViews();
          pageIndex--;
          setPageContent();
        }
      }
    });
  }

  private void preparePagesContents(Test t) {
    for (Section section : t.getSections()) {
      pagesContents.addAll(section.getPages());
    }
  }

  private void setPageContent() {
    Page page = pagesContents.get(pageIndex);
    for (AbstractQuestion question : page.getQuestions()) {
      Log.d(this.getClass().getName(), question.toString());
      innerContent.addView(question.getUIComponent(this));
    }
  }

  // private List<QuestionResult> getQuestionsResult() {
  // List<QuestionResult> questionsResults = new ArrayList<QuestionResult>();
  // for (Page page : pagesContents) {
  // for (AbstractQuestion question : page.getQuestions()) {
  // questionsResults.add(new QuestionResult(question,
  // question.getPacientResult()));
  // }
  // }
  // }

  private Test loadTest(String url) {
    Strategy strategy = new CycleStrategy("id", "ref");
    Serializer serializer = new Persister(strategy);
    try {
      // z res/raw (z androidich resources)
      // return serializer.read(Test.class,
      // getResources().openRawResource(R.raw.test));

      // z src/main/resources
      return serializer.read(Test.class, getClass().getResourceAsStream(url));

      // z SD karty (pouzij DDMS)
      // File file = new File("/sdcard/soul-test/test.xml");
      // return serializer.read(Test.class, file);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
