package utils;

import java.util.LinkedList;
import java.util.Set;

import entities.Shortcut;

public class Cleaning {

	public static String trimShortcut(String line) {
		return line.split(":\\s*")[1];
	}
	
	public static <T> String joinList(LinkedList<T> list) {
		
		StringBuilder builder = new StringBuilder();
		
		for (T letter: list) {
			builder.append(letter);
		}
			
		return builder.toString();
			
	}

}
