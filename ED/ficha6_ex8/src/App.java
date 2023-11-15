public class App {
    public static void main(String[] args) throws Exception {
        String validXHTML = "<body> <h1> Titulo </h1> <p> Corpo com <a> link </a> </p> </body>";
        String invalidXHTML1 = "<body> <h1> Titulo </h1> <p> Corpo com <a>link</p></a> </body>";
        String invalidXHTML2 = "<body> <h1> Titulo </h1> <p> Corpo com <a>link</a></p>";


        ValidateXHTML validador = new ValidateXHTML();

        System.out.println(validador.validadorXHTML(validXHTML)); 
        System.out.println(validador.validadorXHTML(invalidXHTML1)); 
        System.out.println(validador.validadorXHTML(invalidXHTML2)); 
    
      
    }
}
