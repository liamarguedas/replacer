package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entities.error.ReplacerNotFound;
import utils.Cleaning;

public class BaseReader {

	private static final String LOCALE_KEYWORD = "locale";
	private static final String TRIGGER_KEYWORD = "trigger";
	private static final String REPLACER_KEYWORD = "replace";
	private Locale shortcutLocale;

	private String path;
	private Set<Shortcut> shortcuts = new HashSet<>();

	public BaseReader(String path) {
		this.path = path;
		generateShortcuts(this.path);
	}

	public Set<Shortcut> getShortcuts() {
		return shortcuts;
	}

	private void generateShortcuts(String path) {

		try (BufferedReader file = new BufferedReader(new FileReader(path))) {

			List<String> lines = new ArrayList<>(file.lines().toList());

			lines.removeIf(String::isEmpty);
			lines.removeIf(String::isBlank);

			for (int currentLine = 0; currentLine < lines.size(); currentLine++) {

				String line = lines.get(currentLine);

				if (isNewLocale(line)) {

					shortcutLocale = new Locale(lines.get(currentLine + 1).replace(" ", ""));

				} else if (isTrigger(line)) {

					String trigger = Cleaning.trimShortcut(line);

					String replacerLine = lines.get(currentLine + 1);

					if (isReplacer(replacerLine)) {

						String replacer = Cleaning.trimShortcut(replacerLine);

						shortcuts.add(new Shortcut(shortcutLocale, trigger, replacer));

					} else {

						throw new ReplacerNotFound(trigger);

					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ReplacerNotFound e) {
			e.printStackTrace();
		}
	}

	private Boolean isNewLocale(String line) {
		return line.contains(LOCALE_KEYWORD);
	}

	private Boolean isTrigger(String line) {
		return line.contains(TRIGGER_KEYWORD);
	}

	private Boolean isReplacer(String line) {
		return line.contains(REPLACER_KEYWORD);
	}
}
