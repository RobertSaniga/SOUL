package cz.saniga.android.diploma.soul.model;

import org.simpleframework.xml.Attribute;

public class Question {

	@Attribute
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
