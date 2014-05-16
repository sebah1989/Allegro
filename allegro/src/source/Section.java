package source;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Section {
	public abstract void printSection();
	protected abstract void convertCategories();
	
	protected Elements notConvertedCategories;
	protected Element section;
}
