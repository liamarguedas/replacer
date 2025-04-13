package entities;

import entities.enums.Locales;

public class Locale {

	private static final Locales DEFAULT_LOCALE = Locales.EN;
	public Locales locale;

	public Locale(String language) {
		this.locale = readLocal(language);
	}

	private Locales readLocal(String stringLocale) {

		if ( stringLocale == null ) {return DEFAULT_LOCALE;}
		return Locales.valueOf(stringLocale.toUpperCase());

	}
	
	public Locales getLocale() {
		return locale;
	}
}
