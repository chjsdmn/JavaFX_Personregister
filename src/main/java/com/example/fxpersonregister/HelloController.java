package com.example.fxpersonregister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

class Person{
    public String navn;
    public String nummer;

    public Person(String navn, String nummer){
        this.navn = navn;
        this.nummer = nummer;
    }
}

class Register{
    public ArrayList<Person> liste = new ArrayList<>();

    public void registert(String navn, String nummer){
        Person en = new Person(navn, nummer);
        if(liste.isEmpty()){
            liste.add(en);
        }
        if(!liste.isEmpty()){
            for (Person person : liste) {
                if (person.nummer.equals(nummer)) {
                    return;  //同样，在for-loop里我们也不能直接add til listen！！！！
                }
            }
            liste.add(en);
        }

    }

    public void slett(String nummer){
        Person person = null;  //løp igjennom arrayet for å finne personen, dersom den finnes, slett den
        if(liste.isEmpty()){
            return;
        }
        else {
            for (Person en : liste) {
                if (en.nummer.equals(nummer)) {
                    person = en; //kan ikke fjerne personen direkte inne i for løkka, det er IKKE lov til å endre på listen
                    break;
                }
            }
            if(person != null){
                liste.remove(person);
            }
        }
    }

    public String toString(){
        String ut = "";
        for(Person person : liste){
            if(!liste.isEmpty()){
                ut += "Navn: " + person.navn + "     Nr.: " + person.nummer + "\n";
            }
        }
        return ut;
    }
}

public class HelloController {

    Register register = new Register();

    @FXML
    private Label lblUt;

    @FXML
    private TextField navn;

    @FXML
    private TextField personnr;

    @FXML
    void btnReg(ActionEvent event) {
        register.registert(navn.getText(), personnr.getText());
        lblUt.setText(register.toString());
    }

    @FXML
    void btnSlett(ActionEvent event) {
        register.slett(personnr.getText());
        lblUt.setText(register.toString());
    }

}
