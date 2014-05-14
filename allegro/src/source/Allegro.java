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
	
	
}
