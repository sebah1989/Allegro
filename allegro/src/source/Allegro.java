package source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
	
}
