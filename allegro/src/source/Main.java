package source;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
	public static void main(String[] args) throws IOException{
		Manager manager = new Manager();
		//manager.start();
		Document doc = Jsoup.connect("http://allegro.pl/dzial/strefa-okazji/").get();
		String cos = doc.select("section.category.promotion-category.separator-bottom.transform").first().toString();
		System.out.println(cos);
	}

} 
