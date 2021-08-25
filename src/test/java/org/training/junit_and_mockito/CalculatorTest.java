package org.training.junit_and_mockito;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void evaluatesExpression() {
    Calculator calculator = new Calculator();
    int sum = calculator.evaluate("1+2+3");
    assertEquals(6, sum);
  }

  @Test(expected = ArithmeticException.class)
  public void testDevide() {
    Calculator calculator = new Calculator();
    int actual = calculator.divide(4, 2);
    assertEquals(2, actual);
    
    //this will cause an exception
    calculator.divide(2, 0);
  }
}