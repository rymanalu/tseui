import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartB_2 {

    private Map<String, String> tags;

    private Stack<String> stack;

    public PartB_2() {
        tags = new HashMap<>();
        tags.put("<div>", "</div>");
        tags.put("<b>", "</b>");
        tags.put("<i>", "</i>");
        tags.put("<u>", "</u>");

        stack = new Stack<>();
    }

    public boolean isTagCompleted(String html) {
        pushTag(html);

        popTag(html);

        return stack.isEmpty();
    }

    private void pushTag(String html) {
        stack.clear();

        Pattern pattern = Pattern.compile("<(div|b(?:r)|i|u|b)");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            String tag = matcher.group() + ">";

            if (tags.containsKey(tag)) {
                stack.push(matcher.group() + ">");
            }
        }
    }

    private void popTag(String html) {
        Pattern pattern = Pattern.compile("</(div|b|i|u)");
        Matcher matcher = pattern.matcher(html);
        String openingTagInStack;
        String openingTag;
        String closingTag;

        while (matcher.find()) {
            openingTagInStack = stack.peek();
            closingTag = matcher.group() + ">";

            if (tags.containsValue(closingTag)) {
                openingTag = getOpeningTagByClosingTag(closingTag);

                if (openingTagInStack.equals(openingTag)) {
                    stack.pop();
                }
            }
        }
    }

    private String getOpeningTagByClosingTag(String closingTag) {
        for (Map.Entry<String, String> entry : tags.entrySet()) {
            if (entry.getValue().equals(closingTag)) {
                return entry.getKey();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        List<String> htmls = new ArrayList<>();
        htmls.add("<div>Hello<b>World</b></div>");
        htmls.add("<div>Hello<b>World</div>");
        htmls.add("<div>Hello<b>World</div></b>");
        htmls.add("<div att=\"A\">Hello World</div>");
        htmls.add("<div class=”myclass”>Hello<br/>World</div>");

        PartB_2 partB2 = new PartB_2();

        for (String html : htmls) {
            System.out.println("Input: " + html);
            System.out.println("Output: " + partB2.isTagCompleted(html));
            System.out.println();
        }
    }

}
