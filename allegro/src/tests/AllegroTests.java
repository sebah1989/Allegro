package tests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import source.*;

public class AllegroTests {
	
	@Test
	public void testPlainItem() {
		PlainItem item = new PlainItem(plainItem);
		Assert.assertEquals("item should have proper prices difference", 400.0, item.getDifferenceBetweenPrices(),0.01);
	}
	
	@Test
	public void testPromoItem() {
		PromoItem promoItem = new PromoItem(elementForPromoItem);
		Assert.assertEquals("item should have proper prices difference", 300.0, promoItem.getDifferenceBetweenPrices(),0.01);
	}
	
	@Test
	public void testPlainCategory() {
		PlainCategory category = new PlainCategory(categoryForPlain);
		Assert.assertEquals("category with 3 li elements should have 3 items", 3, category.getItems().size());
	}
	
	@Test
	public void testPlainSection() {
		PlainSection section = new PlainSection(documentForPlain);
		Assert.assertEquals("section with 2 categories should have 2 converted categories", 2, section.getCategories().size());
	}
	private String htmlForPlain = "<body><section class='categories-container clearfix transform' data-lang='{'soldItemsCount':'kupionych','currency':'z\u0142','freeShip…ewBargain':'nowo\u015b\u0107'"
			+ ",'lastItems':'ostatnie sztuki'}'><div class='category' data-category-main='false' data-category-id='100008'> " 
			+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>1 499,00 zł</span>"
			+ "<del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div><div class='category' data-category-main='false' data-category-id='100008'><h3>kolejna</h3></div></section></body>";
	private Document documentForPlain  = Jsoup.parse(htmlForPlain);
	private Element categoryForPlain = documentForPlain.getElementsByClass("category").first();
	private Element plainItem = categoryForPlain.getElementsByTag("li").first();
	private String htmlForPromoItem = "&quot;installmentAvailable&quot;:true,&quot;regularPriceFormatted&quot;:&quot;1\\u00a0799,00\\u00a0z\\u0142&quot;,&quot;specialPriceFormatted&quot;:&quot;1\\u00a0499,00"
			+ "\\u00a0z\\u0142&quot;,&quot;priceWithShippingFormatted&quot;:&quot";
	private Element elementForPromoItem = Jsoup.parse(htmlForPromoItem);
	
}
