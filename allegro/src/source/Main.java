package source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
	public static void main(String[] args){
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'>"
				+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>1 499,00 zł</span>"
				+ "<del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div></body></html>";
		Document doc = Jsoup.parse(html);
		Element element = Allegro.getCategoriesFromDocument(doc).first();
		System.out.println(Allegro.parseDocumentAfterPrizeToString(element));
	}

}
