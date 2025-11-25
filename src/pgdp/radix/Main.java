package pgdp.radix;

import static pgdp.radix.Radix.radixSort;

import pgdp.PinguLib.StringList;

public class Main {

	public static void main(String[] args) {

		StringList library = new StringList();

		library.add("Game of thrones");
		library.add("Arcane");
		library.add("Magicians");
		library.add("Squid Game");
		library.add("The Walking Dead");
		library.add("The Witcher");
		library.add("Haus des Geldes");
		library.add("Loki");
		library.add("Vikings");
		library.add("Peaky Blinders");
		library.add("Bodyguard");
		library.add("Cursed");
		library.add("The Office");
		library.add("Brooklyn Nine-Nine");
		library.add("What if");
		library.add("Clone Wars");
		library.add("Sex Education");
		library.add("Prison Break");
		library.add("Breaking Bad");
		library.add("House of Cards");
		library.add("The Expanse");
		library.add("Gotham");
		library.add("Suits");
		library.add("The Queens Gambit");
		library.add("Chernobyl");
		library.add("Lucifer");
		library.add("The Boys");
		library.add("Taboo");
		library.add("Cloak and Dagger");
		library.add("Sherlock");

		radixSort(library);

		System.out.println(library);
	}
}
