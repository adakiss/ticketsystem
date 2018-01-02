package hu.adakiss.ticketsystem.persistence.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import hu.adakiss.ticketsystem.persistence.customerservice.CustomerServiceIntegrationTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CustomerServiceIntegrationTests.class
})
public class IntegrationTest {

}
