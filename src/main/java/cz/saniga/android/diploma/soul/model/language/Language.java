package cz.saniga.android.diploma.soul.model.language;

import org.simpleframework.xml.Element;

public class Language {

	@Element
	private String name;

	@Element(required = false)
	private String descript;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
