package source;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PlainSection extends Section{
	public PlainSection(Document document){
		categories = new ArrayList<PlainCategory>();
		this.section = document.select("section.categories-container.clearfix.transform").first();
		this.notConvertedCategories = section.getElementsByClass("category");
		convertCategories();
	}
	public void convertCategories(){
		for(Element element : notConvertedCategories){
			categories.add(new PlainCategory(element));
		}
	}
	
	public ArrayList<PlainCategory> getCategories() {
		return categories;
	}
	public void printSection(){
		for(PlainCategory category : categories){
			category.printCategory();
		}
	}

	private ArrayList<PlainCategory> categories;
	private Elements notConvertedCategories;
}
