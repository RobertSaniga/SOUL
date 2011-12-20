package cz.saniga.android.diploma.soul.model;

import org.simpleframework.xml.Text;

public class InternationalizedText extends AbstractInternationalizedType {

	@Text
	private String text;

	public String getText() {
		return text;
	}

}
