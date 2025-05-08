package setgroup ;

import java.util.Comparator;

public class StringTreeSortedGroup extends TreeSortedGroup<String> {
    public StringTreeSortedGroup() {
        super(Comparator.naturalOrder());
    }
}
