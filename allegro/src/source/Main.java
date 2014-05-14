package source;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
	public static void main(String[] args){
		//String prize = "1 599.00 ";
		//String prize = "1 599.00 ";
		//String prize2 = prize.replaceAll("\\s","").replace("\u00a0","");
		//System.out.println(Allegro.parseStringPriceToDouble(prize));
		//System.out.println(prize2);
		Allegro.getAndPrintDataFromWebsite();
	}

} 
