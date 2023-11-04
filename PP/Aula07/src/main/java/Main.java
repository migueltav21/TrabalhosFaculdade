public class Main {

    public static void main(String[] args) {
        Lutador l[] = new Lutador[6];
        l[0] = new Lutador("Pretty Boy", "França", 31, 1.75f, 68.9f, 11, 2, 1);
        l[1] = new Lutador("Putscript", "Brasil", 29, 1.68f, 57.8f, 14, 2, 3);
        l[2] = new Lutador("Pulisic", "EUA", 35, 1.65f, 80.9f, 12, 2,1);
        l[3] = new Lutador("Mcgregor", "Irlanda", 28, 1.93f, 81.6f, 13, 0, 2);
        l[4] = new Lutador("VarVar", "Itália", 37, 1.70f, 119.3f, 5, 4, 3);
        l[5] = new Lutador("Nerdeland", "Brasil", 30, 1.8f, 105.7f, 12, 2, 4);
        
        
        
       /* 
        l[0].apresentar();
        l[3].apresentar();
        l[3].ganharLuta();
        l[3].status();
        l[0].status();
        */
        
        Luta luta1 = new Luta();
       luta1.marcarLuta(l[0], l[1]);
       luta1.lutar();
       l[0].status();
       l[1].status();
       
       Luta luta2 = new Luta();
       luta2.marcarLuta(l[4], l[5]);
       luta2.lutar();
        
        
    }
    
}
