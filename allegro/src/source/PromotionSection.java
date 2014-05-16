package source;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PromotionSection {
	public PromotionSection(Document document, String header){
		items = new ArrayList<PromoItem>();
		this.header = header;
		Element tmp = document.select("section.category.promotion-category.separator-bottom.transform").first();
		this.notConvertedItems = tmp.getElementsByTag("li");
		convertItems();
	}
	
	private void convertItems(){
		for(Element element : notConvertedItems){
			items.add(new PromoItem(element));
		}
	}
	public double getSumOfPromoItemsPriceDifferences(){
		double sum = 0;
		for(PromoItem item : items){
			sum += item.getDifferenceBetweenPrices();
		}
		return sum;
	}
	public String getHeader(){
		return header;
	}
	public void printCategory(){
		System.out.println(getHeader() +": " + getSumOfPromoItemsPriceDifferences() );
	}
	
	private ArrayList<PromoItem> items;
	private Elements notConvertedItems;
	private String header;
}
