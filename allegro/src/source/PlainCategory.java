package source;

import java.util.ArrayList;

import org.jsoup.nodes.Element;

public class PlainCategory extends Category {
	public PlainCategory(Element element){
		items = new ArrayList<PlainItem>();
		this.notConvertedItems = element.getElementsByTag("li");
		this.header = getCategoryHeader(element);
		convertItems();
		
		
	}
	
	protected void convertItems(){
		for(Element element : notConvertedItems){
			items.add(new PlainItem(element));
		}
	}
	public double getSumPriceDifferences(){
		double sum = 0;
		for(PlainItem item : items){
			sum += item.getDifferenceBetweenPrices();
		}
		return sum;
	}
	
	private ArrayList<PlainItem> items;
}
