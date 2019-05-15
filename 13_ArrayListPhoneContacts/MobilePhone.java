package com.java21days;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private long number;
    private ArrayList<Contact> contacts;
    Scanner scanner = new Scanner(System.in);

    private MobilePhone(long number) {
        this.number = number;
        this.contacts = new ArrayList<>();

    }

    //functions for contacts:
    private boolean searchContact(String name){
        boolean found=false;
        for(int i=0;i<contacts.size();i++){
           if(contacts.get(i).getName().toLowerCase()
                   .equals(name.toLowerCase())){
               found=true;
           }
        }
      return found;
    }

    private boolean searchNumber(Long number){
        boolean found=false;
        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getNumber()==number){
                found=true;
            }
        }
        return found;
    }


    private void addContact(String name,long number){
        if(searchContact(name)){
            System.out.println("Contact already exists");
        }else if(searchNumber(number)){
            System.out.println("Number already exists");
        }
        else{
            contacts.add(new Contact(name,number));
            System.out.println("Contact has been added");
        }
    }

    private void updateContact(String name){
        if(!searchContact(name)){
            System.out.println("No such contact exists");
        }else{
            int index = 0;
            System.out.println("Enter updated name");
            String newName = scanner.nextLine();
            for(int i=0;i<contacts.size();i++){
                if(contacts.get(i).getName().equals(name)){
                    index=i;
                    contacts.get(i).changeName(newName);
                }
            }
            System.out.println("Contact has been updated");
            System.out.println("Would you like to update number?" +
                    "\n1. yes" + "\n2. no");
            int changeNumber = scanner.nextInt();
            scanner.nextLine();
            if(changeNumber==2){
                System.out.println("Returning to main menu");
            }else{
                System.out.println("Enter new number:");
                long newNumber = scanner.nextLong();
                scanner.nextLine();
                contacts.get(index).changeNumber(newNumber);
                System.out.println("Number has been updated");
            }
        }

    }

   private void deleteContact(String name){
        if(!searchContact(name)){
            System.out.println("No such contact exists");
        }else{
            for(int i=0;i<contacts.size();i++){
                if(contacts.get(i).getName().toLowerCase()
                        .equals(name.toLowerCase())){
                    contacts.remove(i);
                    System.out.println("Contact deleted");
                }
            }

        }
    }

    private void printContacts(){
        for(int i=0;i<contacts.size();i++){
            System.out.println(contacts.get(i).getName() + " " +
                           contacts.get(i).getNumber() );
        }
    }

    private void pushContactsButton(){
        optionsMenu();
        boolean quit = false;
        while(!quit){
            //menu appears with options
            System.out.println("Press 5 to see menu");
            int option = scanner.nextInt();
            scanner.nextLine();

            //validate options
            if(option<0||option>7){
                System.out.println("Invalid Option");
            }else{
                switch(option){
                    case 1:
                        System.out.println("Enter contact name:");
                        String possibleContact = scanner.nextLine();
                        if(searchContact(possibleContact)){
                            System.out.println(possibleContact + " exists");
                        } else{
                            System.out.println("Contact does not exist");
                        }
                        break;
                    case 2:
                        System.out.println("Enter name");
                        String contactName = scanner.nextLine();
                        System.out.println("Enter number");
                        long contactNumber = scanner.nextLong();
                        scanner.nextLine();
                        addContact(contactName,contactNumber);
                        break;
                    case 3:
                        System.out.println("Enter name to update");
                        String oldName = scanner.nextLine();
                        updateContact(oldName);
                        break;
                    case 4:
                        System.out.println("Enter name to be deleted");
                        String deleteMe = scanner.nextLine();
                        deleteContact(deleteMe);
                    case 5:
                        optionsMenu();
                        break;
                    case 6:
                        printContacts();
                        break;
                    case 7:
                        quit = true;
                }
            }

        }
    }

    private void optionsMenu(){
        System.out.println("MENU \n1: Search Contact" +
                            "\n2: Add Contact" +
                            "\n3: Update Contact" +
                            "\n4: Delete Contact" +
                            "\n5: See Menu" +
                            "\n6: Print Contacts"+
                            "\n7: Quit");
    }
}
