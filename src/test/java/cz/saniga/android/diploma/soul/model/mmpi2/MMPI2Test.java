package cz.saniga.android.diploma.soul.model.mmpi2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class MMPI2Test {

  private static final String MMPI2_RESOURCE_NAME = "mmpi2.xml";

  @Test
  public void testDeserialize() throws Exception {
    Serializer serializer = new Persister();
    MMPI2 mmpi2 = serializer.read(MMPI2.class, getSource());

    assertThat(mmpi2.getAnswers().size(), is(3));
    Assert.assertEquals(mmpi2.getAnswers().get(0).getValue(), 1);
  }

  private InputStream getSource() {
    return getClass().getResourceAsStream(MMPI2_RESOURCE_NAME);
  }

}
