package source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Allegro {
	public static Document getDataFromAllegroWebsite(){
		Document doc = null;
		try {
			doc = Jsoup.connect("http://allegro.pl/dzial/strefa-okazji/").get();
		} catch (Exception e) {
			System.out.println("There was an error in connection with allegro!");
		}
		return doc;
	}
	public static Elements getDayOccasions(Document document){
		return document.select("section.category.promotion-category.separator-bottom.transform");
	}
	
	public static Elements getCategoriesFromDocument(Document document){
		return document.getElementsByClass("category");
	}
	
	public static String getCategoryName(Element element){
		return element.getElementsByTag("h3").text();
	}
	
	public static Elements getItemsFromCategory(Element element){
		return element.getElementsByTag("li");
	}
	
	public static String parseDocumentBeforeReductionPriceToString(Element element){
		return element.getElementsByTag("del").text();
	}
	
	public static String parseDocumentAfterReductionPriceToString(Element element){
		return element.select("span.price.bargains-main-color").text();
	}
	
	public static double parseStringPriceToDouble(String price){
		if(price.isEmpty()){
			return 0;
		}
		//remove space and &nbsp
		price = price.replaceAll("\\s+", "").replace("\u00a0","");
		if(price.endsWith("zł")){
			price = price.substring(0,price.length()-2);
		}
		if(price.indexOf(',') != -1){
			price = price.substring(0, price.indexOf(',')) + "." + price.substring(price.indexOf(',')+1,price.length());
		}
			return Double.parseDouble(price);
	}
	
	public static double getDifferenceBetweenPrices(double first, double second){
		return first-second;
	}
	
	public static double sumUpPricesDifferencesFromCategory(Elements categoryItems){
		double sum = 0;
		for(Element categoryItem : categoryItems){
			if(!categoryItem.text().isEmpty()){
				sum += getDifferenceBetweenPrices(parseStringPriceToDouble(parseDocumentBeforeReductionPriceToString(categoryItem)),
						                          parseStringPriceToDouble(parseDocumentAfterReductionPriceToString(categoryItem)));
				
			}
		}
		return sum;
	}
	public static void getAndPrintDataFromWebsite(){
		//get all categories from allegro
		Elements elements = getCategoriesFromDocument(getDataFromAllegroWebsite());
		Elements elements2 = getDayOccasions(getDataFromAllegroWebsite());
		System.out.println("Okazje dnia: " );
		for(Element element2 : elements2){
			
				System.out.println(sumUpPricesDifferencesFromCategory(getItemsFromCategory(element2)));
			
		}
		//for each category print it header and sum up profits from prices reductions
		for(Element element : elements){
			if(!getCategoryName(element).isEmpty()){
				System.out.print(getCategoryName(element)+": ");
				System.out.println(sumUpPricesDifferencesFromCategory(getItemsFromCategory(element)));
			}
		}
	}
	
	
	
}
