package day4;

import org.testng.annotations.DataProvider;

public class TestDataSource {

	@DataProvider
	public String[][] getData() {

		String[][] data = new String[3][2];

		data[0][0] = "mngr291840";
		data[0][1] = "dYnusAv";

		data[1][0] = "mngr291841";
		data[1][1] = "dYnusAv";

		data[2][0] = "mngr291840";
		data[2][1] = "dYnusAv";

		return data;

	}

}
