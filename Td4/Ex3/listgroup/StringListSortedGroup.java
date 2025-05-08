package listgroup;

public class StringListSortedGroup extends ListSortedGroup<String> {
    @Override
    protected boolean isGreater(String a, String b) {
        return a.compareTo(b) > 0;
    }

    public String concat() {
        StringBuilder sb = new StringBuilder();
        for (String s : content) {
            sb.append(s);
        }
        return sb.toString();
    }
}
