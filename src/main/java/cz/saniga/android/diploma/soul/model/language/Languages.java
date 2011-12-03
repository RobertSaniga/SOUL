package cz.saniga.android.diploma.soul.model.language;

import java.util.HashMap;
import java.util.Map;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import cz.saniga.android.diploma.soul.model.AbstractVersionType;

@Root
@Order(elements = { "default_language", "another" })
public class Languages extends AbstractVersionType {

	@Element(name = "default_language")
	private Language defaultLang;

	@ElementMap(entry = "another", key = "lang_id", attribute = true, inline = true)
	private Map<String, Language> anotherLangsMap = new HashMap<String, Language>();

	public Language getDefaultLang() {
		return defaultLang;
	}

	public void setDefaultLang(Language defaultLang) {
		this.defaultLang = defaultLang;
	}

	public Map<String, Language> getAnotherLangsMap() {
		return anotherLangsMap;
	}

}
