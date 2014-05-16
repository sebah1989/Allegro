package source;

import org.jsoup.nodes.Element;

public class PromoItem {
	public PromoItem(Element element){
		this.element = element.toString();
		parseDocumentPricesToString();
		convertBeforePrice();
		convertAfterPrice();
	}
	
	public void parseDocumentPricesToString(){
		int beginRegularPriceindex = element.indexOf("regularPriceFormatted") + 34;
		int endRegularPriceindex = element.indexOf("\\u00a0z\\u0142");
		this.regularPrice = element.substring(beginRegularPriceindex, endRegularPriceindex);
		String tmp = element.substring(endRegularPriceindex+1);
		int beginSpecialPriceindex = tmp.indexOf("specialPriceFormatted") + 34;
		int endSpecialPriceindex = tmp.indexOf("\\u00a0z\\u0142");
		this.specialPrice = tmp.substring(beginSpecialPriceindex, endSpecialPriceindex);
	}
	
	private double parseStringPriceToDouble(String price){
		if(price.isEmpty()){
			return 0;
		}
		//replaceAll("\\u00a0","") doesn't work, so it is done in while manually
		while(price.indexOf("\\u00a0") != -1){
			int index = price.indexOf("\\u00a0");
			price = price.substring(0, index) + price.substring(index+6);
		}
		//removings spacebars, zł and replacing ',' with '.'
		price = price.replaceAll(",", ".").replaceAll("zł", "").replaceAll("\\s+","");
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
	public double getDifferenceBetweenPrices(){
		return getPriceBefore() - getPriceAfter();
	}
	
	private String element;
	private String regularPrice;
	private String specialPrice;
	private double priceBefore;
	private double priceAfter;
}
