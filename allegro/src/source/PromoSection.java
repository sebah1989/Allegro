package source;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

public class PromoSection extends Section {
	public PromoSection(Document document){
		categories = new ArrayList<PromoCategory>();
		this.section = document.select("section.category.promotion-category.separator-bottom.transform").first();
		convertCategories();
	}
	protected void convertCategories(){
		categories.add(new PromoCategory(section, "Okazje dnia"));
	}
	
	public void printSection(){
		for(PromoCategory category : categories){
			category.printCategory();
		}
	}
	
	public ArrayList<PromoCategory> getCategories(){
		return categories;
	}

	private ArrayList<PromoCategory> categories;
}
