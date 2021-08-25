package org.training.junit_and_mockito.mobile.wallet;

/**
 * Perform transaction to user account. 
 * Adding/Subtracting user balance and report information
 */
public interface BankingService {
  public int withDraw(int amount);
  
  public void topUp(int amount) throws Exception;

  public void reportProblem(String string);
}
