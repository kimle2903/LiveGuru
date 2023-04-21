package factoryBrowsers;

public class BrowserNoSupportedException extends IllegalStateException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BrowserNoSupportedException(String browser) {
		super(String.format("browser is not supported: %s", browser));
	}
}
