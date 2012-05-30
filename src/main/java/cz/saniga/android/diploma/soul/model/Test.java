package cz.saniga.android.diploma.soul.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import cz.saniga.android.diploma.soul.evaluation.EvaluationModule;

/**
 * Basic object to create test
 * 
 * @author Robinek
 * 
 */
@Root
public class Test {

  @Attribute
  private String name;

  @Element(name = "eval-module")
  private EvaluationModule evaluationModule;

  @Element(required = false)
  private String description;

  @ElementList(inline = true, entry = "section")
  private List<Section> sections;

  @ElementList(required = false, entry = "answer")
  private List<Answer> answers;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Section> getSections() {
    return sections;
  }

  public void setSections(List<Section> sections) {
    this.sections = sections;
  }

  public EvaluationModule getEvaluationModule() {
    return evaluationModule;
  }

}
