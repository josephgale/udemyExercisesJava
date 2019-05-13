public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(true);

        printer.printPages(20000);//expected result: Not enough paper

        printer.addPaper(1000);
        printer.printPages(500); //expected: Printing 500 page(s)

        System.out.println(printer.getTonerLevel());//expected result: 50
        System.out.println(printer.getPaperLevel());//expected result: 250

    }
}
