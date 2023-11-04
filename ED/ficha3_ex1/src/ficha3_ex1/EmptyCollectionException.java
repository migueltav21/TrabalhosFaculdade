/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha3_ex1;

/**
 *
 * @author Rui Tavares
 */
public class EmptyCollectionException extends Exception {

    public EmptyCollectionException(String collectionName) {
        super(collectionName + " is empty.");
    }
}
