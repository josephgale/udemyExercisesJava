import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public void addBranch(String name){
        branches.add(Branch.addBranch(name));
    }
    public void showBranches(){
        for(int i=0;i<branches.size();i++){
            System.out.println(branches.get(i).getName() + " Branch");
        }
    }

    public Branch getBranch(String name){
        for(int i=0;i<branches.size();i++){
           if(branches.get(i).getName().equals(name)){
               return branches.get(i);
           }
        }
        return null;
    }

}
