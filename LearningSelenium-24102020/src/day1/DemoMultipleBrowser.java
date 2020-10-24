package day1;

public class DemoMultipleBrowser {

	public static void main(String[] args) {
		MulipleBrowserExamples mb = new MulipleBrowserExamples();

		mb.invokeBrowser("edge");

		String title = mb.getTitle();

		System.out.println("Title of the page - " + title);

		mb.closeBrowser();
	}

}
