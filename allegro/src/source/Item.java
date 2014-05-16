package source;

import org.jsoup.nodes.Element;

public class Item {
	public Item(Element element){
		parseDocumentPricesToString(element);
		convertBeforePrice();
		convertAfterPrice();
	}
	
	private void parseDocumentPricesToString(Element element){
		this.regularPrice = element.getElementsByTag("del").text();
		this.specialPrice = element.select("span.price.bargains-main-color").text();
	}
	
	private double parseStringPriceToDouble(String price){
		if(price.isEmpty()){
			return 0;
		}
		//removings spacebars, zł and replacing ',' with '.'
		price = price.replaceAll(",", ".").replaceAll("zł", "").replaceAll("\\u00a0","").replaceAll("\\s+","");
		return Double.parseDouble(price);
	}
	public void convertBeforePrice(){
		this.priceBefore = parseStringPriceToDouble(regularPrice);
	}
	public void convertAfterPrice(){
		this.priceAfter = parseStringPriceToDouble(specialPrice);
	}
	public double getPriceBefore() {
		return priceBefore;
	}

	public double getPriceAfter() {
		return priceAfter;
	}
	
	public String getRegularPrice() {
		return regularPrice;
	}

	public String getSpecialPrice() {
		return specialPrice;
	}

	public double getDifferenceBetweenPrices(){
		return getPriceBefore() - getPriceAfter();
	}


	private double priceBefore;
	private double priceAfter;
	private String regularPrice;
	private String specialPrice;
}
