package entities;

import java.util.Objects;

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
	
	public void writeReplacer() {
		
		//logic to write it
		System.out.println(replacer);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(trigger);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shortcut other = (Shortcut) obj;
		return Objects.equals(trigger, other.trigger);
	}

}
