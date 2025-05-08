import core.SortedGroup;
import listgroup.StringListSortedGroup;
import setgroup.StringTreeSortedGroup;

public class Main {
    public static void main(String[] args) {
        SortedGroup<String> listGroup = new StringListSortedGroup();
        SortedGroup<String> treeGroup = new StringTreeSortedGroup();

        for (String s : new String[]{"toto", "titi", "tutu", "toto"}) {
            listGroup.insert(s);
            treeGroup.insert(s);
        }

        System.out.println("List-based version: " + listGroup);
        System.out.println("TreeSet-based version: " + treeGroup);
        System.out.println(((StringListSortedGroup) listGroup).concat());
    }
}
