package cz.saniga.android.diploma.soul.model.mmpi2;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import cz.saniga.android.diploma.soul.model.AbstractQuestion;
import cz.saniga.android.diploma.soul.model.Option;
import cz.saniga.android.diploma.soul.model.Test;

@Root(name = "mmpi2")
public class MMPI2 extends Test {

	@ElementList(entry = "answer")
	private List<Option> answers = new ArrayList<Option>();

	@ElementList(entry = "question")
	private List<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();

	public List<Option> getAnswers() {
		return answers;
	}

	public List<AbstractQuestion> getQuestions() {
		return questions;
	}

}
