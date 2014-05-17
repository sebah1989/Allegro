package source;

import java.util.ArrayList;

import org.jsoup.nodes.Element;

public class PlainCategory extends Category {
	public PlainCategory(Element element){
		super(element);
		items = new ArrayList<PlainItem>();
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
	
	public ArrayList<PlainItem> getItems(){
		return items;
	}

	private ArrayList<PlainItem> items;
}
