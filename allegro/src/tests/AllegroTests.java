package tests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

import source.*;
import source.Item;
import source.Manager;

public class AllegroTests {
	
	@Test
	public void testPlainItem() {
		Item item = new PlainItem(elementForPlainItem);
		Assert.assertEquals("item should have proper prices difference", 400.0, item.getDifferenceBetweenPrices(),0.01);
	}
	
	@Test
	public void testPromoItem() {
		PromoItem promoItem = new PromoItem(elementForPromoItem);
		Assert.assertEquals("item should have proper prices difference", 300.0, promoItem.getDifferenceBetweenPrices(),0.01);
	}
	
	private String htmlForPlainItem = "<div class='category' data-category-main='false' data-category-id='100008'> " 
				+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>1 499,00 zł</span>"
				+ "<del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div>";
	private Element elementForPlainItem = Jsoup.parse(htmlForPlainItem);
	private String htmlForPromoItem = "&quot;installmentAvailable&quot;:true,&quot;regularPriceFormatted&quot;:&quot;1\\u00a0799,00\\u00a0z\\u0142&quot;,&quot;specialPriceFormatted&quot;:&quot;1\\u00a0499,00"
			+ "\\u00a0z\\u0142&quot;,&quot;priceWithShippingFormatted&quot;:&quot";
	private Element elementForPromoItem = Jsoup.parse(htmlForPromoItem);
	private String htmlForPromoCategory = "<li data-bargain-info=\"[{&quot><li>";
}
