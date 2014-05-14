package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import source.Allegro;

public class AllegroTests {

	@Test
	public void testIsThereResponseFromWebsite() {
		Assert.assertNotNull("response from website shouldn't be null", Allegro.getDataFromAllegroWebsite());
	}

}
