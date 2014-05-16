package source;

import org.jsoup.nodes.Element;

public class PlainItem extends Item {
	public PlainItem(Element element){
		super(element);
	}
	protected void parseDocumentPricesToString(Element element){
		this.regularPrice = element.getElementsByTag("del").text();
		this.specialPrice = element.select("span.price.bargains-main-color").text();
	}
}
