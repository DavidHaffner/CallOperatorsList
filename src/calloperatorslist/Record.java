/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calloperatorslist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author dhaffner
 */
public class Record {

    /* jméno klienta */
    private String firstName = "";
    /* příjmení klienta */
    private String surname = "";
    /* jeho telefonní číslo */
    private String phoneNumber = "";
    /* případná poznámka */
    private String notice = "";

    public Record() {
    }

    public Record(String firstName, String surname, String phoneNumber, String notice) {
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.notice = notice;
        // vložit metody na kontrolu telefonního čísla vytvořené níže
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     * @param notice the notice to set
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * metoda zkontroluje platnost tel. čísla a příp. umožní opravu
     */
    public String phoneNumberCheck(String phoneNumber) {
        String pNumber = phoneNumber.replaceAll("\\D", "");   // všechny nečíslice pryč
        System.out.println("Po vyhození nečíslic: " + pNumber); //pomocný práskač

        if (pNumber.length() == 9) {     // při 9 číslicích přidá předvolbu ČR
            pNumber = "420" + pNumber;
        }

        if (pNumber.length() != 12) {    // když nesedí délka, umožní opravu 
            pNumber = phoneNumberCorrection();
        }

        return pNumber;
    }

    /**
     * metoda převede tel. číslo na požadovaný formát
     */
    public String phoneNumberFormat(String phoneNumber) {
        char[] chars = phoneNumber.toCharArray();
        phoneNumber = "+" + chars[0] + chars[1] + chars[2] + " " + chars[3]
                + chars[4] + chars[5] + " " + chars[6] + chars[7] + chars[8]
                + " " + chars[9] + chars[10] + chars[11];
        return phoneNumber;
    }

    /**
     * metoda vrátí název souboru pro zápis záznamu
     */
    public String fNameDeclare() {
        return this.getSurname() + "_" + this.getFirstName() + ".TXT";
    }

    /**
     * metoda zapíše do souboru
     */
    public void fileWrite(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(this.getFirstName());
            bw.write(" ");
            bw.write(this.getSurname());
            bw.newLine();
            bw.write(this.getPhoneNumber());
            bw.newLine();
            bw.write(this.getNotice());
            bw.flush();
        } catch (Exception e) {
            System.err.println("Error when trying to write into the file");
        }
    }

    /**
     * metoda umožní opravu telef. čísla (např. když se vyhodnotí, že bylo
     * špatně zadáno
     */
    public String phoneNumberCorrection() {
        System.out.println("The phone number is wrong.");
        System.out.println("Insert it once again, please: ");

        try {
            Scanner sc = new Scanner(System.in); //umožní znovuzadat ...
            phoneNumber = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error when inserting ...");
        }
        phoneNumber = phoneNumberCheck(phoneNumber);        // ... a znovu zkontroluje
        
        return phoneNumber;
    }
}
