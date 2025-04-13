package entities.error;

public class ReplacerNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public ReplacerNotFound(String trigger) {

		super("Couldn't locate replacer for " + trigger
				+ ", make sure that you are following format from: https://github.com/liamarguedas/replacer/blob/main/file/base.yml");
	}

}
