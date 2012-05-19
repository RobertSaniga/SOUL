package cz.saniga.android.diploma.soul.evaluation;

import java.util.List;

import android.content.Intent;
import cz.saniga.android.diploma.soul.model.Page;

public interface EvaluationModule {

  public Intent evaluate(List<Page> pages);
}
