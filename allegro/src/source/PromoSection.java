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
	public void convertCategories(){
		items.add(new PromoCategory(section, "Nowe okazje"));
	}
	public Element getSection(){
		return section;
	}
	public void printSection(){
		for(PromoCategory category : items){
			category.printCategory();
		}
	}
	
	public ArrayList<PromoCategory> getItems() {
		return items;
	}

	private ArrayList<PromoCategory> items;
	
}
