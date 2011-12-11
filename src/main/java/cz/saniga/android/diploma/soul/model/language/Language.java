package cz.saniga.android.diploma.soul.model.language;

import org.simpleframework.xml.Element;

public class Language {

	@Element
	private String label;

	@Element(required = false)
	private String descript;

	public String getLabel() {
		return label;
	}

	public String getDescript() {
		return descript;
	}

}
