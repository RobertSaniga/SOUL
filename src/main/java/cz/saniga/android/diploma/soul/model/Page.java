package cz.saniga.android.diploma.soul.model;

import java.util.Collection;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import cz.saniga.android.diploma.soul.model.components.Choice;

public class Page {

	// TODO add all components
	@ElementListUnion({
	    @ElementList(entry = "question", inline = true, type = Question.class),
	    @ElementList(entry = "choice", inline = true, type = Choice.class)
	})
	private Collection<Question> questions;

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

}
