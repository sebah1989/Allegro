package source;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Category {
	public Category(Element element){
		this.header = getCategoryHeader(element);
		items = new ArrayList<Item>();
		this.notConvertedItems = element.getElementsByTag("li");
		convertItems();
	}
	private String getCategoryHeader(Element element){
		return element.getElementsByTag("h3").text();
	}
	private void convertItems(){
		for(Element element : notConvertedItems){
			items.add(new Item(element));
		}
	}
	public double getSumPriceDifferences(){
		double sum = 0;
		for(Item item : items){
			sum += item.getDifferenceBetweenPrices();
		}
		return sum;
	}
	public String getHeader(){
		return header;
	}
	public void printCategory(){
		System.out.println(getHeader() +": "+ getSumPriceDifferences());
	}

	private String header;
	private ArrayList<Item> items;
	private Elements notConvertedItems;
}
