package day1;

public class DemoGuru99Application {

	public static void main(String[] args) {
		Guru99Project guru = new Guru99Project();

		guru.invokeBrowser("chrome");

		guru.loginToApplication("mngr291840", "dYnusAv");

		guru.closeBrowser();
	}

}
