package cz.saniga.android.diploma.soul.model.language;

import org.simpleframework.xml.Attribute;

public class AnotherLanguage extends Language {

	@Attribute(name = "lang_id")
	private String langId;

	public String getLangId() {
		return langId;
	}

}
