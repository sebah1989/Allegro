package source;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws IOException{
		Manager manager = new Manager();
		//manager.start();
		 String htmlForPlain = "<body><section class='categories-container clearfix transform' data-lang='{'soldItemsCount':'kupionych','currency':'z\u0142','freeShip…ewBargain':'nowo\u015b\u0107'"
				+ ",'lastItems':'ostatnie sztuki'}'><div class='category' data-category-main='false' data-category-id='100008'> " 
					+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>1 499,00 zł</span>"
					+ "<del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div><</section></body>";
		 Document dok = Jsoup.parse(htmlForPlain);
		Document doc = Jsoup.connect("http://allegro.pl/dzial/strefa-okazji/").get();
		Element cos = dok.select("section.categories-container.clearfix.transform").first();
		Elements cos2 = cos.getElementsByClass("category");
		System.out.println(cos2);
	}

} 
