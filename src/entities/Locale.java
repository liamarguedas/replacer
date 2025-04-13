package entities;

import entities.enums.Locales;

public class Locale {

	public Locales local;

	public Locale(String language) {
		this.local = readLocal(language);
	}

	private Locales readLocal(String stringLocale) {
		return Locales.valueOf(stringLocale.toUpperCase());
	}
}
