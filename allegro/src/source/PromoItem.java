package source;

import org.jsoup.nodes.Element;

public class PromoItem extends Item {
	public PromoItem(Element element){
		super(element);
	}
	public void parseDocumentPricesToString(Element elementIncome){
		String element = elementIncome.toString();
		int beginRegularPriceindex = element.indexOf("regularPriceFormatted") + 34;
		int endRegularPriceindex = element.indexOf("\\u00a0z\\u0142");
		this.regularPrice = element.substring(beginRegularPriceindex, endRegularPriceindex);
		String tmp = element.substring(endRegularPriceindex+1);
		int beginSpecialPriceindex = tmp.indexOf("specialPriceFormatted") + 34;
		int endSpecialPriceindex = tmp.indexOf("\\u00a0z\\u0142");
		this.specialPrice = tmp.substring(beginSpecialPriceindex, endSpecialPriceindex);
	}
}
