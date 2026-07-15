package utilities;

public final class JavascriptExecutorUtils {

    private JavascriptExecutorUtils() {}

    public static final String CLICK = "arguments[0].click();";

    public static final String SCROLL_INTO_CENTER = "arguments[0].scrollIntoView({block:'center'});";

    public static final String SCROLL_INTO_VIEW_TRUE = "arguments[0].scrollIntoView(true);";

    public static final String SCROLL_TO_BOTTOM = "window.scrollTo(0,document.body.scrollHeight);";

    public static String ScrollBy(int x, int y) {
        return "window.scrollBy(" + x + ", " + y + ");";
    }
}