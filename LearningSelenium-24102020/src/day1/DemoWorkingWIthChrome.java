package day1;

public class DemoWorkingWIthChrome {
	
	public static void main(String[] args) {
		
		WorkingWithChrome wc = new WorkingWithChrome();
		
		wc.invokeBrowser();
		
		String title = wc.getTitle();
		
		System.out.println("Title of the page is - "+ title);
		
		wc.navigateCommands();
		
		wc.closeBrowser();
	}

}
