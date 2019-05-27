public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
        //rightLink set as null in ListItem abstract class during construction
        //this function iterates to an item's rightLink
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
        //rightLink is created when an item, node, or new something is inserted
        //thus every item gets a record of the item next to it
    }

    @Override
    ListItem previous() {
        return this.leftLink;
        //this method iterates or returns value of an items' leftLink
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
        //this method sets an item's leftLink and "iterates" to the previous link
    }

    @Override
    int compareTo(ListItem item) {
        if(item!=null) {
            //null is an acceptable value of a generic Object
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }

    }
}
