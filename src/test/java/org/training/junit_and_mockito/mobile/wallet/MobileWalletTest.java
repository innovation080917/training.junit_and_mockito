package org.training.junit_and_mockito.mobile.wallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MobileWalletTest {

  // @InjectMocks annotation is used to create and inject the mock object
  @InjectMocks
  private MobileWallet wallet;

  // @Mock annotation is used to create the mock object to be injected
  @Mock
  private BankingService service;

  @Test
  public void testWithDraw_success() {
    int amount = 1_000_000;
    
    //mock case success
    Mockito.when(service.withDraw(amount)).thenReturn(amount);

    // test the functionality
    int actual = wallet.withDraw(amount);
    Assert.assertEquals(amount, actual);
  }
  
  @Test
  public void testWithDraw_failed() {
    int amount = 1_000_000;
    
    //mock case failed
    Mockito.when(service.withDraw(amount)).thenReturn(0);

    // test the functionality
    int actual = wallet.withDraw(amount);
    Assert.assertEquals(0, actual);
  }
  
  @Test
  public void testTopUp_sucess() throws Exception {
    int amount = 1_000_000;
    
    // test the functionality
    wallet.topUp(amount);
    
    //ensure that the transaction has finished without exception
    Mockito.verify(service).topUp(amount);
  }
  
  @Test
  public void testTopUp_failed() throws Exception {
    int amount = 1_000_000;
    
    Mockito.doThrow(Exception.class).when(service).topUp(amount);
    
    // test the functionality
    wallet.topUp(amount);
    
    //ensure that the problem is reported if transaction failed
    Mockito.verify(service).reportProblem("The transaction has failed!");
  }
  
  @Test
  public void testTopUp_failed_andRealReport() throws Exception {
    int amount = 1_000_000;
    
    MobileWallet.BankingServiceImpl svcImpl = new MobileWallet.BankingServiceImpl();
    BankingService svcSpy = Mockito.spy(svcImpl);
    
    Mockito.doThrow(Exception.class).when(svcSpy).topUp(amount);
    
    MobileWallet mb = new MobileWallet(svcSpy);
    // test the functionality
    mb.topUp(amount);
    
    //ensure that the problem is reported if transaction failed
    Mockito.verify(svcSpy).reportProblem(Mockito.anyString());
  }

}
