package services;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import entities.Shortcut;
import utils.Cleaning;

public class ListenerService implements NativeKeyListener {

	private Set<Shortcut> shortcuts;
	private static final Integer CLEANING_THRESHOLD = 100;
	private static final String ALLOWED_CHARS = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private LinkedList<String> currentInputs = new LinkedList<>();

	public ListenerService(Set<Shortcut> shortcuts) {
		this.shortcuts = shortcuts;
	}

	public void nativeKeyPressed(NativeKeyEvent e) {

		String pressedKey = NativeKeyEvent.getKeyText(e.getKeyCode());

		if (currentInputs.size() < CLEANING_THRESHOLD) {

			currentInputs.add(pressedKey);

			if (!ALLOWED_CHARS.contains(pressedKey)) {
				currentInputs.clear();

			} else {
				triggerMatch();
			}
		}

		else {
			currentInputs.clear();
			currentInputs.add(pressedKey);
		}
	}

	private void triggerMatch() {

		String possibleTrigger = Cleaning.joinList(currentInputs);

		for (Shortcut sc : shortcuts) {

			if (possibleTrigger.length() >= sc.getLen()) {

				String shortcutTrigger = sc.getTrigger();

				Boolean match = possibleTrigger.contains(shortcutTrigger) || shortcutTrigger.contains(possibleTrigger);

				if (match) {

					currentInputs.clear();
					sc.writeReplacer();

				}
			}
		}
	}
}
