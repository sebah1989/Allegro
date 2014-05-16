package source;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Section {
	protected abstract void printSection();
	
	protected Elements notConvertedCategories;
	protected Element section;
}
