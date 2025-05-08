package listgroup;

import core.SortedGroup;
import java.util.*;

public abstract class ListSortedGroup<T> extends SortedGroup<T> {
    protected List<T> content = new ArrayList<>();

    protected abstract boolean isGreater(T a, T b);

    @Override
    public void insert(T element) {
        if (content.contains(element)) return;

        int i = 0;
        while (i < content.size() && isGreater(content.get(i), element) == false) {
            i++;
        }
        content.add(i, element);
    }

    @Override
    public T getElement(int index) {
        return content.get(index);
    }

    @Override
    protected Collection<T> getContent() {
        return content;
    }
}
