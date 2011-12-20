package cz.saniga.android.diploma.soul.model.mmpi2;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "mmpi2")
public class MMPI2 {

	@ElementList(entry = "answer")
	private List<MMPI2Answer> answers = new ArrayList<MMPI2Answer>();

	@ElementList(entry = "question")
	private List<MMPI2Question> questions = new ArrayList<MMPI2Question>();

	public List<MMPI2Answer> getAnswers() {
		return answers;
	}

	public List<MMPI2Question> getQuestions() {
		return questions;
	}

}
