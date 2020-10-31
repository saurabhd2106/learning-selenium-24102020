package day1;

public class DemoMultipleBrowser {

	public static void main(String[] args) {
		MulipleBrowserExamples mb = new MulipleBrowserExamples();

		try {
			mb.invokeBrowser("safari");

			String title = mb.getTitle();

			System.out.println("Title of the page - " + title);

			mb.closeBrowser();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
