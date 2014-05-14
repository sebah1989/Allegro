package tests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'> + "
				+ "<h3>Nowe oferty</h3></div><div class='category' data-category-main='false' data-category-id='100008'> + "
				+ "<h3>Nowe oferty</h3></div></body></html>";
		Document doc = Jsoup.parse(html);
		Assert.assertEquals("method should return proper number of categories", 2, Allegro.getCategoriesFromDocument(doc).size());
	}

}
