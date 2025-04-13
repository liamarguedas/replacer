package services;

import java.util.Set;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import entities.Shortcut;


public class Listener implements NativeKeyListener {
	
	private Set<Shortcut> shortcuts;
	
	public Listener(Set<Shortcut> shortcuts) {
		this.shortcuts = shortcuts;
	}

	public void nativeKeyPressed(NativeKeyEvent e) {
		
		System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
	}
	
}
