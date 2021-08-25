package org.training.junit_and_mockito;

public class Calculator {
  public int evaluate(String expression) {
    int sum = 0;
    for (String summand : expression.split("\\+"))
      sum += Integer.valueOf(summand);
    return sum;
  }
  
  public int divide(int a, int b) {
    return a/b;
  }
}