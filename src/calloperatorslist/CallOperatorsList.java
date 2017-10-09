/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calloperatorslist;

import java.util.Scanner;

/**
 *
 * @author dhaffner
 */
public class CallOperatorsList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // pomocné proměnné
        String pomocna = "";
        String fileName = "";
        
        while (true) {     //cyklus poběží, dokud uživatel nezadá e jako end
        
            System.out.println("Insert your option:");
            System.out.println("1 - new record");
            System.out.println("e - end");
        
            try {
                Scanner sc = new Scanner(System.in);
                String option = sc.nextLine();
                    
                if (option.equals("e")) break;
        
                switch (option) {         //připraveno na event. dopsání dalších voleb
                    case "1":
                        Record record = new Record();  //založí nový záznam
                    
                        System.out.printf("Insert first name: ");  //vkládáme jedn. atributy
                        pomocna = sc.nextLine();
                        record.setFirstName(pomocna);
                    
                        System.out.printf("Insert surname: ");
                        pomocna = sc.nextLine();
                        record.setSurname(pomocna);
                    
                        System.out.printf("Insert phone number: ");
                        pomocna = sc.nextLine();
                        record.setPhoneNumber(pomocna);
                    
                        //kontrola správnosti tel. čísla 
                        record.setPhoneNumber(record.phoneNumberCheck(record.getPhoneNumber()));
                        //přepsání na požad. formát
                        record.setPhoneNumber(record.phoneNumberFormat(record.getPhoneNumber()));
                    
                        System.out.printf("Insert your notice: ");
                        pomocna = sc.nextLine();
                        record.setNotice(pomocna);
                    
                        //vytvoří správný název souboru
                        fileName = record.fNameDeclare();
                    
                        //uloží záznam do souboru
                        record.fileWrite(fileName);
                    
                        break;
                    
                    default:
                        System.out.println("Error when inserting your option.");
                        break;
                }
            }    
            catch (Exception e) {
                System.out.println("Error when inserting ...");
            }
        }
        
        System.out.println("Thank you for using of our application.");   
    }   
}
