public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        String stringData = "01 Car apple 3A yH.hello Yh";
        String[] data = stringData.split(" ");
        for(String s : data) {
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());

    }
}
