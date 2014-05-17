package source;

import java.util.Locale;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Category {
	public Category(Element element){
		this.notConvertedItems = element.getElementsByTag("li");
	}
	public abstract double getSumPriceDifferences();
	protected abstract void convertItems();
	
	protected String getCategoryHeader(Element element){
		return element.getElementsByTag("h3").text();
	}
	
	protected void printCategory(){
		System.out.print(getHeader() +": ");
		System.out.format(Locale.FRANCE,"%-10.2f%n",getSumPriceDifferences());
	}
	
	public String getHeader(){
		return header;
	}
	
	protected String header;
	protected Elements notConvertedItems;
}
