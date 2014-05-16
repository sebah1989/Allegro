package source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Manager {
	public Manager(){
		getDataFromAllegroWebsite();
	}
	
	private void getDataFromAllegroWebsite(){
		Document doc = null;
		try {
			doc = Jsoup.connect("http://allegro.pl/dzial/strefa-okazji/").get();
		} catch (Exception e) {
			System.out.println("There was an error in connection with allegro!");
		}
		this.document =  doc;
	}
	
	public void start(){
		PromoSection promosection = new PromoSection(document);
		promosection.printSection();
		PlainSection section = new PlainSection(document);
		section.printSection();

	}
	private Document document;
}
