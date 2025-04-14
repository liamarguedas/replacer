package services;

import java.util.Set;
import java.util.TreeSet;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import entities.Shortcut;
import utils.Cleaning;


public class ListenerService implements NativeKeyListener {
	
	private Set<Shortcut> shortcuts;
	private static Integer cleaningThreshold; 
	private Set<String> currentInputs = new TreeSet<>();
	
	
	public ListenerService(Set<Shortcut> shortcuts) {
		this.shortcuts = shortcuts;
		this.cleaningThreshold = Cleaning.getThreshold(this.shortcuts);
	}

	public void nativeKeyPressed(NativeKeyEvent e) {
		
		String pressedKey = NativeKeyEvent.getKeyText(e.getKeyCode());
	
		
		
		
		
	}
	
}
