package interfaces;

public class AbstractPageUI {
	public static final String DYNAMIC_PAGES = "//a[contains(text(),'%s')]";
	public static final String DYNAMIC_BTN = "//input[@name='%s']";
	public static final String DATEOFBIRTH_DATE = "//input[@id='dob']";
	public static final String DYNAMIC_TXT = "//*[contains(@name,'%s')]";
	public static final String DYNAMIC_DROPDOWN = "//*[contains(@name,'%s')]";
	public static final String CREATED_EDITED_MSG = "//*[contains(text(),'%s')]";
	public static final String DYNAMIC_LBL = "//*[contains(text(),'%s')]/following-sibling::td";
}
