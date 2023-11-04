/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;
import cbl.*;
import cbl.project.*;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;

/**
 *
 * @author joao
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        CBL cbl = new CBL();
        Edition edition = new Edition("Nome", LocalDate.now(), LocalDate.now().plusDays(10), "project_template.json", null);

        try {
            edition.addProject("Nome", "nigga", null);
        } catch (IOException | ParseException e) {
            System.out.println("NIgga");
        }
    }
    
}
