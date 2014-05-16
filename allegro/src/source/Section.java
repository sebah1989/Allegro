package source;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Section {
	public Section(Document document){
		categories = new ArrayList<Category>();
		Element tmp = document.select("section.categories-container.clearfix.transform").first();
		this.notConvertedCategories = tmp.getElementsByClass("category");
		convertCategories();
	}
	public Elements getElements(){
		return notConvertedCategories;
	}
	public void convertCategories(){
		for(Element element : notConvertedCategories){
			categories.add(new Category(element));
		}
	}
	
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void printSection(){
		for(Category category : categories){
			category.printCategory();
		}
	}

	private ArrayList<Category> categories;
	private Elements notConvertedCategories;
	private String header;
}
