package source;

import java.util.ArrayList;
import org.jsoup.nodes.Element;

public class PromoCategory extends Category {
	public PromoCategory(Element element, String header){
		super(element);
		items = new ArrayList<PromoItem>();
		this.header = header;
		convertItems();
	}
	protected void convertItems(){
		for(Element element : notConvertedItems){
			items.add(new PromoItem(element));
		}
	}
	public double getSumPriceDifferences(){
		double sum = 0;
		for(PromoItem item : items){
			sum += item.getDifferenceBetweenPrices();
		}
		return sum;
	}
	
	public ArrayList<PromoItem> getItems(){
		return items;
	}

	private ArrayList<PromoItem> items;
}
