package source;

import java.text.NumberFormat;
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
		NumberFormat formator = NumberFormat.getInstance(Locale.FRANCE);
		formator.setGroupingUsed(true);
		formator.setMinimumFractionDigits(2);
		System.out.println(formator.format(getSumPriceDifferences()));
	}
	
	public String getHeader(){
		return header;
	}
	
	protected String header;
	protected Elements notConvertedItems;
}
