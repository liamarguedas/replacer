package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseReader {

	private static final String LOCALE_KEYWORD = "locale";
	private static final String TRIGGER_KEYWORD = "trigger";
	private static final String REPLACER_KEYWORD = "replace";

	public String path;
	public Map<String, String> shortcuts;

	public BaseReader(String path) {
		this.path = path;
		generate(this.path);
	}

	public void generate(String path) {

		try (BufferedReader file = new BufferedReader(new FileReader(path))) {

			List<String> lines = new ArrayList<>(file.lines().toList());

			lines.removeIf(String::isEmpty);
			lines.removeIf(String::isBlank);

			for (int currentLine = 0; currentLine < lines.size(); currentLine++) {

				String line = lines.get(currentLine);

				if (isNewLocale(line)) {

					Locale shortcutsLocal = new Locale(lines.get(currentLine + 1).replace(" ", ""));

				} else if (isTrigger(line)) {

					String replace = lines.get(currentLine + 1);

					if (isReplacer(replace)) {

						
						

					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	private String trimShortcut(String line) {
		return line.split(":\\s*")[1];
	}
}
