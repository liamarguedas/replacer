package application;

import java.awt.event.KeyEvent;
import java.util.Set;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import entities.BaseReader;
import entities.Shortcut;
import services.ListenerService;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BaseReader base = new BaseReader("C:\\Users\\liams\\eclipse-workspace\\replacer\\file\\base.yml");
		
		Set<Shortcut> shortcuts = base.getShortcuts();
		
		try {
			GlobalScreen.registerNativeHook();
		}
		
		catch(NativeHookException e) {
			System.out.println(e.getMessage());
		}
		
		GlobalScreen.addNativeKeyListener(new ListenerService(shortcuts));
			
	}

}
