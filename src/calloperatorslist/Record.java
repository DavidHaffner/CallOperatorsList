/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calloperatorslist;

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
    
    
    public Record (String firstName, String surname, String phoneNumber, String notice) {
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
    
    
    /* metoda zkontroluje .... */
    
    /* metoda zapíše daný záznam do souboru */
    
    
    
    
    
}
