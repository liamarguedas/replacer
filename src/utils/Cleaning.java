package utils;

import java.util.Set;

import entities.Shortcut;

public class Cleaning {

	public static String trimShortcut(String line) {
		return line.split(":\\s*")[1];
	}
	
	public static Integer getThreshold(Set<Shortcut> shortcuts) { 
		// Threshold is calculated by the largest trigger in length.
		
		Integer max = 0;
		
		for (Shortcut shortcut : shortcuts) {
			if ( shortcut.getLen() > max ) {
				max = shortcut.getLen();
			}
		}
		
		return max;
	}

}
