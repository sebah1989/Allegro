package source;

import org.jsoup.nodes.Element;

public abstract class Item {
	public Item(Element element){
		parseDocumentPricesToString(element);
		convertBeforePrice();
		convertAfterPrice();
	}
	protected abstract void parseDocumentPricesToString(Element element);
	
	public double getDifferenceBetweenPrices(){
		return getPriceBefore() - getPriceAfter();
	}
	public double getPriceBefore() {
		return priceBefore;
	}
	public double getPriceAfter() {
		return priceAfter;
	}
	protected void convertBeforePrice(){
		this.priceBefore = parseStringPriceToDouble(regularPrice);
	}
	protected void convertAfterPrice(){
		this.priceAfter = parseStringPriceToDouble(specialPrice);
	}
	protected double parseStringPriceToDouble(String price){
		if(price.isEmpty()){
			return 0;
		}
		//replaceAll("\\u00a0","") sometimes doesn't work, so it is done in while manually
		while(price.indexOf("\\u00a0") != -1){
			int index = price.indexOf("\\u00a0");
			price = price.substring(0, index) + price.substring(index+6);
		}
		//removings spacebars, zł and replacing ',' with '.'
		price = price.replaceAll(",", ".").replaceAll("zł", "").replaceAll("\\s+","").replaceAll("\\u00a0","");
		return Double.parseDouble(price);
	}
	protected double priceBefore;
	protected double priceAfter;
	protected String regularPrice;
	protected String specialPrice;
}
