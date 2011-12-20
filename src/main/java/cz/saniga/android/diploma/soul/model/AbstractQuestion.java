package cz.saniga.android.diploma.soul.model;

import org.simpleframework.xml.Attribute;

public abstract class AbstractQuestion extends AbstractSimpleLocalizedType {

	@Attribute
	private int id;

	public int getId() {
		return id;
	}

}
