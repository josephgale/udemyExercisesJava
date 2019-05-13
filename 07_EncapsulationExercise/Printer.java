public class Printer {
    private double tonerLevel;
    private int paperLevel;
    private boolean isDuplex;


    public Printer(boolean isDuplex) {
        this.tonerLevel = 100;
        this.paperLevel = 50;
        this.isDuplex = isDuplex;
    }

    public void printPages(int pages) {
        if (!enoughToner(pages)) {
            System.out.println("Not enough toner");
        } else {
            if (!enoughPaper(pages)) {
                System.out.println("Not enough paper");
            } else {
                updatePrinter(pages);
                System.out.println("Printing " + pages + " page(s)");
            }
        }
    }



    //verify and update paper and ink
    private boolean enoughToner(int pages) {
        double tonerUsed = pages * .10;
        return tonerUsed < tonerLevel;
    }

    private boolean enoughPaper(int pages){
        if(isDuplex){
            return (Math.round(pages/2))<paperLevel;
        }
        return pages<paperLevel;
    }

    private void updatePrinter(int pages){
        tonerLevel -= pages * .10;
        if(isDuplex){
            paperLevel -= Math.round(pages/2);
        } else {
            paperLevel -= pages;
        }
    }

    //fill up methods

    public void addPaper(int pages){
        if(pages+paperLevel>500){
            paperLevel = 500;
            System.out.println("Paper is filled up");
        } else {
            paperLevel += pages;
        }
    }

    public void addToner(double percentage){
        if(percentage + tonerLevel>100){
            tonerLevel = 100;
            System.out.println("Toner all filled up");
        } else {
            tonerLevel += percentage;
        }
    }


    //basic getters
    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getPaperLevel() {
        return paperLevel;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
