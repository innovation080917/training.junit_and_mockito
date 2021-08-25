package org.training.junit_and_mockito.helper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Helper.class)
public class StringServiceTest {
  
  @Test
  public void testConcatString() {
    PowerMockito.mockStatic(Helper.class);
    String expected = "ab";
    PowerMockito.when(Helper.concat("a", "b")).thenReturn(expected);
    
    String actual = new StringService().concatStrings();
    
    Assert.assertEquals(expected, actual);
  }
}
