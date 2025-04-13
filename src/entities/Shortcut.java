package entities;

public class Shortcut {

	public Locale locale;
	public String trigger;
	public String replacer;

	public Shortcut(Locale locale, String trigger, String replacer) {
		this.locale = locale;
		this.trigger = trigger;
		this.replacer = replacer;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getTrigger() {
		return trigger;
	}

	public String getReplacer() {
		return replacer;
	}

}
