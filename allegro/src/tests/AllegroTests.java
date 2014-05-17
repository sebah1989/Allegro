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
		PromoItem item = new PromoItem(promoItem);
		Assert.assertEquals("item should have proper prices difference", 300.0, item.getDifferenceBetweenPrices(),0.01);
	}
	
	@Test
	public void testPlainCategory() {
		PlainCategory category = new PlainCategory(categoryForPlain);
		Assert.assertEquals("category with 3 li elements should have 3 items", 3, category.getItems().size());
	}
	@Test
	public void testPlainCategoryHeader() {
		PlainCategory category = new PlainCategory(categoryForPlain);
		Assert.assertEquals("plain category should have proper header", "Nowe oferty", category.getHeader());
	}
	@Test
	public void testPromoCategory() {
		PromoCategory category = new PromoCategory(categoryForPromo, "nowe");
		Assert.assertEquals("category with 1 li elements should have 1 items", 1, category.getItems().size());
	}
	@Test
	public void testPromoCategoryHeader() {
		PromoCategory category = new PromoCategory(categoryForPromo, "nowe");
		Assert.assertEquals("promo category should have proper header", "nowe", category.getHeader());
	}
	
	@Test
	public void testPlainSection() {
		PlainSection section = new PlainSection(documentForPlain);
		Assert.assertEquals("section with 2 categories should have 2 converted categories", 2, section.getCategories().size());
	}
	@Test
	public void testPromoSection() {
		PromoSection section = new PromoSection(documentForPromo);
		Assert.assertEquals("promo section has one category", 1, section.getCategories().size());
	}
	
	private String htmlForPlain = "<body><section class='categories-container clearfix transform' data-lang='{'soldItemsCount':'kupionych','currency':'z\u0142','freeShip…ewBargain':'nowo\u015b\u0107'"
			+ ",'lastItems':'ostatnie sztuki'}'><div class='category' data-category-main='false' data-category-id='100008'> " 
			+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>1 499,00 zł</span>"
			+ "<del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div><div class='category' data-category-main='false' data-category-id='100008'><h3>kolejna</h3></div></section></body>";
	private Document documentForPlain  = Jsoup.parse(htmlForPlain);
	private Element categoryForPlain = documentForPlain.getElementsByClass("category").first();
	private Element plainItem = categoryForPlain.getElementsByTag("li").first();
	private String htmlForPromoItem = "<body><section class='category promotion-category separator-bottom transform'>"
			+ "<ul><li class='selected' data-bargain-info='[{&quot;midiImageUrl&quot;installmentAvailable&quot;:true,"
			+ "&quot;regularPriceFormatted&quot;:&quot;1\\u00a0799,00\\u00a0z\\u0142&quot;,&quot;"
			+ "specialPriceFormatted&quot;:&quot;1\\u00a0499,00\\u00a0z\\u0142&quot;,&quot;"
			+ "priceWithShippingFormatted&quot;ostatnie sztuki&quot;}'></li></ul></section></body>";
	private Document documentForPromo = Jsoup.parse(htmlForPromoItem);
	private Element categoryForPromo = documentForPromo.select("section.category.promotion-category.separator-bottom.transform").first();
	private Element promoItem = categoryForPromo.getElementsByTag("li").first();
	
}
