package source;

import java.io.ObjectInputStream.GetField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args){
		//String prize = '1 599.00 ';
		//String prize = '1 599.00 ';
		//String prize2 = prize.replaceAll('\\\\\\s','').replace('\\u00a0','');
		//System.out.println(Allegro.parseStringPriceToDouble(prize));
		//System.out.println(prize2);
		
//		String html = "<li data-bargain-info='[{&quot;midiImageUrl&quot;:&quot;http:\\/\\/thumbnails02.okazje.allegro.pl\\/13B379A0\\/5360bad81e3511398848216.jpg\\/400x300\\/fixed_canvas_ffffff&quot;,&quot;percentage&quot;:22,&quot;discountValue&quot;:70,&quot;offerId&quot;:&quot;5360bad8030917f81a000001&quot;,&quot;title&quot;:&quot;Kamera obrotowa WiFi 1 Mpix HD 720 CoolCam P2P&quot;,&quot;regularPrice&quot;:319,&quot;specialPrice&quot;:249,&quot;promotionStatus&quot;:0,&quot;shippingPrice&quot;:0,&quot;smallImageCategoryUrl&quot;:&quot;http:\\/\\/thumbnails02.okazje.allegro.pl\\/99EB7A60\\/5360bad81e3511398848216.jpg\\/220x270&quot;,&quot;smallImageDailyUrl&quot;:&quot;http:\\/\\/thumbnails02.okazje.allegro.pl\\/6DCAB40B\\/5360bad81e3511398848216.jpg\\/200x170&quot;,&quot;allegroUrl&quot;:&quot;http:\\/\\/allegro.pl\\/show_item.php?item=4197028076&amp;sh_dwh_token=d0b6dd74a8394345128e20d296cb1c5e&quot;,&quot;availableItemsCount&quot;:131,&quot;endDate&quot;:1401400799,&quot;soldItemsCount&quot;:18,&quot;shortDescription&quot;:&quot;Kamera obrotowa WiFi 1 Mpix HD 720 CoolCam P2P&quot;,&quot;imageAlt&quot;:&quot;Kamera obrotowa WiFi 1 Mpix HD 720 CoolCam P2P&quot;,&quot;sectionId&quot;:3,&quot;friendlyLink&quot;:&quot;kamera-obrotowa-wifi-1-mpix-hd-720-coolcam-p2p-14360&quot;,&quot;imageThumbUrl&quot;:&quot;http:\\/\\/thumbnails02.okazje.allegro.pl\\/EE18E6E2\\/5360bad81e3511398848216.jpg\\/170x135&quot;,&quot;soldOut&quot;:false,&quot;additionalCategoriesIds&quot;:[100011],&quot;isDaily&quot;:true,&quot;installmentAvailable&quot;:false,&quot;regularPriceFormatted&quot;:&quot;319,00\\u00a0z\\u0142&quot;,&quot;specialPriceFormatted&quot;:&quot;249,00\\u00a0z\\u0142&quot;,&quot;priceWithShippingFormatted&quot;:&quot;249,00\\u00a0z\\u0142&quot;,&quot;hasFreeDelivery&quot;:true,&quot;isLastItem&quot;:false,&quot;isSoldOut&quot;:false,&quot;priceWithShipping&quot;:249,&quot;isInstalmentAvailable&quot;:false}]'>";
//		int index1 = html.indexOf("regularPriceFormatted");
//		int index2 = index1 + 34;
//		int index3 = html.indexOf("\\u00a0z\\u0142");
		//System.out.println(html.substring(index2,index3));
	
		//System.out.println(doc.select("section.category.promotion-category.separator-bottom.transform"));
		//PlainSection promo = new PlainSection(Allegro.getDataFromAllegroWebsite());
		Manager manager = new Manager();
		manager.start();
		PromoSection promo = new PromoSection(Allegro.getDataFromAllegroWebsite());
		//System.out.println(promo.getCategories().get(6).getItems().size());
		
		promo.printSection();
		//System.out.println(promo.getSection().getElementsByTag("li"));
		String html = "<html><head><title>Some title</title></head><body><div class='category' data-category-main='false' data-category-id='100008'>"
				+ "<h3>Nowe oferty</h3><li class=''><div class='price-container clearfix'><span class='price bargains-main-color'>"
				+ "1 499,00 zł</span><del>1 899,00 zł</del></div></li><li class=''></li><li class=''></li></div></body></html>";
		Document doc = Jsoup.parse(html);
		//Element element = Allegro.getCategoriesFromDocument(doc).first();
		//Item item = new Item(element);
		//System.out.println(item.getPriceBefore() +" "+  item.getPriceAfter());
		//System.out.println(promo.getElements().size());
		//Document document = Allegro.getDataFromAllegroWebsite();
		//Element tmp = document.select("section.category.promotion-category.separator-bottom.transform").first();
		//Elements elements = tmp.getElementsByTag("li");
		//System.out.println(elements);
		//String str = "3\u00a0399.00";
		//System.out.println(str.replaceAll("\u00a0",""));
//		Element element = document.select("section.category.promotion-category.separator-bottom.transform").first();
//		System.out.println(element.getElementsByTag("li"));
//		System.out.println(promo.getNotConvertedItems().size());
		
////		
		
	}

} 
