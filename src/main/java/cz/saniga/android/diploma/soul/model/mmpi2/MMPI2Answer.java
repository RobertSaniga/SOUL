package cz.saniga.android.diploma.soul.model.mmpi2;

import org.simpleframework.xml.Attribute;

import cz.saniga.android.diploma.soul.model.AbstractSimpleLocalizedType;
import cz.saniga.android.diploma.soul.model.Valueable;

public class MMPI2Answer extends AbstractSimpleLocalizedType implements Valueable {

	@Attribute
	private int value;

	@Override
	public int getValue() {
		return value;
	}

}
