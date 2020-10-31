package day2;

public class DemoAmazonProject {
	
	public static void main(String[] args) {
		AmazonProject amazonProject = new AmazonProject();
		
		amazonProject.invokeBrowser("edge");
		
		amazonProject.getAllLinksAndUrl();
		
		/*
		 * amazonProject.searchProduct("iPhone", "Electronics");
		 * 
		 * String productDetail = amazonProject.getNthProduct(10);
		 * 
		 * System.out.println(productDetail);
		 * 
		 * amazonProject.getAllProductsViaScrollDownUsingJS();
		 */
	}

}
