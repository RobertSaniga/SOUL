package cz.saniga.android.diploma.soul.model.language;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import cz.saniga.android.diploma.soul.model.AbstractVersionType;

@Root
@Order(elements = { "default", "another" })
public class Languages extends AbstractVersionType {

	@Element(name = "default")
	private Language defaultLang;

	@ElementList(inline = true, required = false, entry = "another")
	private List<AnotherLanguage> anotherLangs = new ArrayList<AnotherLanguage>();

	public Language getDefaultLang() {
		return defaultLang;
	}

	public List<AnotherLanguage> getAnotherLangs() {
		return anotherLangs;
	}

}
