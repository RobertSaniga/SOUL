package cz.saniga.android.diploma.soul.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

@Order(elements = { "default_text", "another_languages" })
public abstract class AbstractSimpleLocalizedType {

	@Element(name = "default_text")
	private String defaultText;

	@ElementList(name = "another_languages", required = false, entry = "text")
	private List<InternationalizedText> anotherTexts = new ArrayList<InternationalizedText>();

	public String getDefaultText() {
		return defaultText;
	}

	public List<InternationalizedText> getAnotherTexts() {
		return anotherTexts;
	}

}
