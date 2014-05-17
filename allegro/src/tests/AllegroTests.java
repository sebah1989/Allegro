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
		Assert.assertEquals("plain item should have proper prices difference", 400.0, item.getDifferenceBetweenPrices(),0.01);
	}
	
	@Test
	public void testPromoItem() {
		PromoItem item = new PromoItem(promoItem);
		Assert.assertEquals("promo item should have proper prices difference", 300.0, item.getDifferenceBetweenPrices(),0.01);
	}
	
	@Test
	public void testPlainCategory() {
		PlainCategory category = new PlainCategory(plainCategory);
		Assert.assertEquals("plain category with 3 li elements should have 3 items", 3, category.getItems().size());
	}
	@Test
	public void testPromoCategory() {
		PromoCategory category = new PromoCategory(promoCategory, "nowe");
		Assert.assertEquals("promo category with 2 li elements should have 2 items", 2, category.getItems().size());
	}
	@Test
	public void testSummingUpPricesDifferencesInPlainCategory() {
		PlainCategory category = new PlainCategory(plainCategory);
		Assert.assertEquals("summing up items price differences, in plain category, should have proper value", 
				800, category.getSumPriceDifferences(),0.01);
	}
	@Test
	public void testSummingUpPricesDifferencesInPromoCategory() {
		PromoCategory category = new PromoCategory(promoCategory, "nowe");
		Assert.assertEquals("summing up items price differences, in promo category, should have proper value", 
				1000, category.getSumPriceDifferences(),0.01);
	}
	@Test
	public void testPlainCategoryHeader() {
		PlainCategory category = new PlainCategory(plainCategory);
		Assert.assertEquals("plain category should have proper header", "Nowe oferty", category.getHeader());
	}
	
	@Test
	public void testPromoCategoryHeader() {
		PromoCategory category = new PromoCategory(promoCategory, "nowe");
		Assert.assertEquals("promo category should have proper header", "nowe", category.getHeader());
	}
	
	@Test
	public void testPlainSection() {
		PlainSection section = new PlainSection(plainDocument);
		Assert.assertEquals("section with 2 categories should have 2 converted categories", 2, section.getCategories().size());
	}
	@Test
	public void testPromoSection() {
		PromoSection section = new PromoSection(promoDocument);
		Assert.assertEquals("promo section has one category", 1, section.getCategories().size());
	}

	private String plainHtml = "<body><section class='categories-container clearfix transform' data-lang='{'soldItemsCount':'kupionych','currency':'z\u0142','freeShip…ewBargain':'nowo\u015b\u0107'"
			+ ",'lastItems':'ostatnie sztuki'}'><div class='category' data-category-main='false' data-category-id='100008'> " 
			+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>1 499,00 zł</span>"
			+ "<del>1 899,00 zł</del></div></li><li class=''></li><li class=''><span class='price bargains-main-color'>1 199,00 zł</span>"
			+ "<del>1 599,00 zł</del></li></div><div class='category' data-category-main='false' data-category-id='100008'><h3>kolejna</h3></div></section></body>";
	private Document plainDocument  = Jsoup.parse(plainHtml);
	private Element plainCategory = plainDocument.getElementsByClass("category").first();
	private Element plainItem = plainCategory.getElementsByTag("li").first();
	private String promoHtml = "<body><section class='category promotion-category separator-bottom transform'>"
			+ "<ul><li class='selected' data-bargain-info='[{&quot;midiImageUrl&quot;installmentAvailable&quot;:true,"
			+ "&quot;regularPriceFormatted&quot;:&quot;1\\u00a0799,00\\u00a0z\\u0142&quot;,&quot;"
			+ "specialPriceFormatted&quot;:&quot;1\\u00a0499,00\\u00a0z\\u0142&quot;,&quot;"
			+ "priceWithShippingFormatted&quot;ostatnie sztuki&quot;}'></li><li class='selected' data-bargain-info='[{&quot;midiImageUrl&quot;installmentAvailable&quot;:true,"
			+ "&quot;regularPriceFormatted&quot;:&quot;1\\u00a0999,00\\u00a0z\\u0142&quot;,&quot;"
			+ "specialPriceFormatted&quot;:&quot;1\\u00a0299,00\\u00a0z\\u0142&quot;,&quot;"
			+ "priceWithShippingFormatted&quot;ostatnie sztuki&quot;}'></li></ul></section></body>";
	private Document promoDocument = Jsoup.parse(promoHtml);
	//promo section is also promo category
	private Element promoCategory = promoDocument.select("section.category.promotion-category.separator-bottom.transform").first();
	private Element promoItem = promoCategory.getElementsByTag("li").first();
	
}
