package source;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PromoSection extends Section {
	public PromoSection(Document document){
		items = new ArrayList<PromoCategory>();
		this.section = document.select("section.category.promotion-category.separator-bottom.transform").first();
		convertCategories();
	}
	protected void convertCategories(){
		items.add(new PromoCategory(section, "Nowe okazje"));
	}
	
	public void printSection(){
		for(PromoCategory category : items){
			category.printCategory();
		}
	}
	private ArrayList<PromoCategory> items;
}
