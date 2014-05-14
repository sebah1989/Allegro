package tests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

import source.Allegro;

public class AllegroTests {
	
	@Test
	public void testgetDataFromAllegroWebsite() {
		Assert.assertNotNull("response from website shouldn't be null", Allegro.getDataFromAllegroWebsite());
	}
	
	@Test
	public void testGetCategoriesFromDocument(){
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'>"
				+ "<h3>Nowe oferty</h3></div><div class='category' data-category-main='false' data-category-id='100008'> + "
				+ "<h3>Nowe oferty</h3></div></body></html>";
		Document doc = Jsoup.parse(html);
		Assert.assertEquals("method should return proper number of categories", 2, Allegro.getCategoriesFromDocument(doc).size());
	}
	
	@Test
	public void testGetCategoryName(){
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'>"
				+ "<h3>Nowe oferty</h3></div></body></html>";
		Document doc = Jsoup.parse(html);
		Element element = Allegro.getCategoriesFromDocument(doc).first();
		Assert.assertEquals("method should return proper category name", "Nowe oferty", Allegro.getCategoryName(element));
	}
	
	@Test
	public void testGetItemsFromCategory(){
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'>"
				+ "<h3>Nowe oferty</h3><li class=''></li><li class=''></li><li class=''></li></div><div class='category' data-category-main='false' data-category-id='100008'> + "
				+ "<h3>Nowe oferty</h3><li class=''></li><li class=''></li><li class=''></li></div></body></html>";
		Document doc = Jsoup.parse(html);
		Element element = Allegro.getCategoriesFromDocument(doc).first();
		Assert.assertEquals("method should return proper number of li elements", 3, Allegro.getItemsFromCategory(element).size());
	}
	@Test
	public void testParsingDocumentBeforeReductionpriceToString(){
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'>"
				+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'> +"
				+ "1 499,00 zł</span><del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div></body></html>";
		Document doc = Jsoup.parse(html);
		Element element = Allegro.getCategoriesFromDocument(doc).first();
		Assert.assertEquals("method should return proper before reduction price", "1 899,00 zł",Allegro.parseDocumentBeforeReductionPriceToString(element));
	}
	
	@Test
	public void testParsingDocumentAfterReductionpriceToString(){
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'> + "
				+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>1 499,00 zł</span>"
				+ "<del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div></body></html>";
		Document doc = Jsoup.parse(html);
		Element element = Allegro.getCategoriesFromDocument(doc).first();
		Assert.assertEquals("method should return proper after reduction price", "1 499,00 zł", Allegro.parseDocumentAfterReductionPriceToString(element));
	}
	@Test
	public void testParsingStringpriceToDouble(){
		String price = "1 499,00 zł";
		Assert.assertEquals("method should parse String price to double", 1499.00, Allegro.parseStringPriceToDouble(price), 0.1);
		
	}
	@Test
	public void testCheckingDifferenceBeewtenTwoprices(){
		double priceBefore = 1899.0;
		double priceAfter = 1499.0;
		Assert.assertEquals("method should return proper difference", 400.00, Allegro.getDifferenceBetweenPrices(priceBefore, priceAfter), 0.1);
		
	}

}
