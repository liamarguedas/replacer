package entities;

public class Shortcut {

	private Locale locale;
	private String trigger;
	private String replacer;
	private Integer len;	
		
		

	public Shortcut(Locale locale, String trigger, String replacer) {
		this.locale = locale;
		this.trigger = trigger.toUpperCase();
		this.replacer = replacer;
		this.len = trigger.length();
	}

	public Integer getLen() {
		return len;
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
