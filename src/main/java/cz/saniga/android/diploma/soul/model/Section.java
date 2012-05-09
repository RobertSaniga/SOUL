package cz.saniga.android.diploma.soul.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

import cz.saniga.android.diploma.soul.model.components.Choice;

public class Section {

	// @Element(required = false)
	// private Header header;
	//
	// @Element(required = false)
	// private Footer footer;

	@ElementList(inline = true, required = false, entry = "choice")
	private List<Choice> Choices;

	public List<Choice> getChoices() {
		return Choices;
	}

	public void setChoices(List<Choice> choices) {
		Choices = choices;
	}

}
