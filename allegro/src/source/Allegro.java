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
	
	public static Elements getCategoriesFromDocument(Document document){
		return document.getElementsByClass("category");
	}
	
	public static String getCategoryName(Element element){
		return element.getElementsByTag("h3").text();
	}
	
	public static Elements getItemsFromCategory(Element element){
		return element.getElementsByTag("li");
	}
	
	public static String parseDocumentBeforePrizeToString(Element element){
		return element.getElementsByTag("del").text();
	}
	
	public static String parseDocumentAfterPrizeToString(Element element){
		return element.getElementsByClass("bargains-main-color").text();
	}
	
	public static double parseStringPrizeToDouble(String prize){
		if(prize.endsWith("zł")){
			prize = prize.substring(0,prize.length()-2);
		}
		if(prize.indexOf(',') != -1){
			prize = prize.substring(0, prize.indexOf(',')) + "." + prize.substring(prize.indexOf(',')+1,prize.length());
		}
			return Double.parseDouble(prize.replaceAll(" ", ""));
	}
	
	
}
