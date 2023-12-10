package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Menu {
    private String title;
    private ArrayList<String> choices;
    private HashMap<String, ArrayList<String>> choiceGroups;
    
    public Menu(){
        
    }
    
    public Menu(String title, String[] mchon){
        this.title=title;
        this.choices= new ArrayList<>();
        this.choices.addAll(Arrays.asList(mchon));
        this.choiceGroups = new HashMap<>();
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public ArrayList<String> getChoices() {
        return choices;
    }
            
    public void setChoices(String[] mchon){
        this.choices.clear();
        this.choices.addAll(Arrays.asList(mchon));
    }
    
    public void addChoices(String[] choices) {
        this.choices.addAll(Arrays.asList(choices));
    }

    public void removeChoices(String[] choices) {
        for (String m : choices) {
            this.choices.remove(m);
        }
    }

    public boolean containsChoice(String choice) {
        return choices.contains(choice);
    }

    public int getChoiceCount() {
        return choices.size();
    }
    
    public void addChoiceToGroup(String groupName, String choice) {
        ArrayList<String> m = this.choiceGroups.get(groupName);
        if (m == null) {
            m = new ArrayList<>();
            this.choiceGroups.put(groupName, m);
        }

        m.add(choice);
    }

    public void removeChoiceFromGroup(String groupName, String choice) {
        ArrayList<String> m = this.choiceGroups.get(groupName);
        if (m != null) {
            m.remove(choice);
        }
    }

    public boolean containsChoiceInGroup(String groupName, String choice) {
        ArrayList<String> m = this.choiceGroups.get(groupName);
        if (m != null) {
            return m.contains(choice);
        }

        return false;
    }

    public ArrayList<String> getChoicesInGroup(String groupName) {
        return this.choiceGroups.get(groupName);
    }
    
    static void display(String title,ArrayList<String> al){
        System.out.println(title);
        System.out.println("--------------------------------------");
        for(int i=0;i<al.size();i++){
            System.out.println((i+1)+". "+al.get(i));
        }
        System.out.println("--------------------------------------");
    }
    
    public void run(){
        while(true){
            int choice = getSelected();
            if(choice <= choices.size())
                execute(choice);
            else
                break;
        }
    }
    
    public abstract void execute(int choice);
    
    public int getSelected(){
        display(title,choices);
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter selection..");
        return sc.nextInt();
    }
    
//    public static void main(String[] args){
//        String[] mc={"Add Item","Remove Item","Check out","Quit"};
//        Menu m= new Menu("Shopping online",mc) {
//            @Override
//            public void execute(int choice) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//        };
//        m.run();
//    }
}
