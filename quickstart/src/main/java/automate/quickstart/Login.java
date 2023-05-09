package automate.quickstart;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;

//package automate.quickstart;
//
public class Login extends Registration {
	@Test
	public void LoginComponent() {

	}

	@Test
	public void MobileFieldIsEnabled() {

	}

//	@Test
	public void LoginLessThanTen() throws IOException, CsvException

	{
		registrationLessThanTen();

	}

	// @Test
	public void LoginNegativeTestCaseZeroInput() throws IOException, CsvException, InterruptedException

	{
		registrationNegativeTestCaseZeroInput();

	}

	// @Test
	public void LoginTermandConditionNegativeTestCase() throws IOException, CsvException, InterruptedException {
		RegistrationTermandConditionNegativeTestCase();
	}

	// @Test
	public void LoginPositveTestCase() throws IOException, CsvException, InterruptedException {
		RegistrationPositveTestCase();
	}

}