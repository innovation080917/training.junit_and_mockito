package org.training.junit_and_mockito.mobile.wallet;

public class MobileWallet {
  private BankingService service;
  
  public MobileWallet(BankingService svc) {
    this.service = svc;
  }
  
  /**
   * Perform transaction to user account. 
   * Subtracting user balance
   * @param amount of money to withdraw
   * @return the amount of money or 0 if failed
   */
  public int withDraw(int amount) {
    System.out.println("MobileWallet.withDraw " + amount);
    return service.withDraw(amount);
  }
  
  /**
   * Perform transaction to user account. 
   * Adding user balance
   * @param amount of money to top up
   */
  public void topUp(int amount) {
    System.out.println("MobileWallet.toUp " + amount);
    try {
      //transaction success
      service.topUp(amount);
    } catch (Exception e) {
      //transaction failed
      service.reportProblem("The transaction has failed!");
    }
  }
  
  protected static class BankingServiceImpl implements BankingService {
    @Override
    public int withDraw(int amount) {
      throw new UnsupportedOperationException();
    }
    
    @Override
    public void topUp(int amount) throws Exception {
      throw new UnsupportedOperationException();
    }
    
    @Override
    public void reportProblem(String string) {
      System.out.println(string);
    }
  }
}
