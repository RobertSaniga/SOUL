package cz.saniga.android.diploma.soul.model;

import org.simpleframework.xml.Attribute;

public abstract class AbstractInternationalizedType {

	@Attribute
	private String lang;

	public String getLang() {
		return lang;
	}

}
