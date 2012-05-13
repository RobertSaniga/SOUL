package cz.saniga.android.diploma.soul.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class Section {

  // @Element(required = false)
  // private Header header;
  //
  // @Element(required = false)
  // private Footer footer;
  //
  // @Element(required = false)
  // private Navigation navigation;

  @ElementList(inline = true, entry = "page")
  private List<Page> pages;

  public List<Page> getPages() {
    return pages;
  }

  public void setPages(List<Page> pages) {
    this.pages = pages;
  }

}
