package setgroup;

import core.SortedGroup;
import java.util.*;

public class TreeSortedGroup<T> extends SortedGroup<T> {
    private TreeSet<T> content;

    public TreeSortedGroup(Comparator<T> comparator) {
        this.content = new TreeSet<>(comparator);
    }

    @Override
    public void insert(T element) {
        content.add(element);
    }

    @Override
    public T getElement(int index) {
        int i = 0;
        for (T element : content) {
            if (i == index) return element;
            i++;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

    @Override
    protected Collection<T> getContent() {
        return content;
    }
}
