package source;

import java.util.ArrayList;
import java.util.Locale;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public abstract class Category {
	
	protected String getCategoryHeader(Element element){
		return element.getElementsByTag("h3").text();
	}
	public abstract double getSumPriceDifferences();
	protected abstract void convertItems();
	protected void printCategory(){
		System.out.print(getHeader() +": ");
		System.out.format(Locale.FRANCE,"%-10.2f%n",getSumPriceDifferences());
	}
	protected String getHeader(){
		return header;
	}
	protected String header;
	protected Elements notConvertedItems;
	

}
