package suites;

import Pages.DriverFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.*;

@RunWith(Suite.class)
@SuiteClasses({
		loginTest.class,
		cadastrarClienteTest.class,
		listarClienteTest.class,
        cadastrarTransacaoTest.class,
        listarVendaTest.class
})
public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo(){
		DriverFactory.killDriver();
	}

}
