public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String collection) {
        super("Element not found in " + collection);
    }

}
