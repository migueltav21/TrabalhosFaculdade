package pp_fp11;

import pp_fp11.Enums.Extensao;

public class main {

    public static void main(String[] args) {
        Ficheiro a = new Ficheiro("a", Extensao.MP3, 100, 200);
        Ficheiro b = new Ficheiro("b", Extensao.MP3, 100, 200);
        Ficheiro c = new Ficheiro("c", Extensao.MP3, 100, 200);
        Ficheiro[] z = {a};
        PPod ppod = new PPod(z);
       ppod.addFile(b);
       ppod.addFile(c);
       ppod.deleteFile(100);
       ppod.playTrack(0);
       ppod.nextTrack();
   
    }
    
}
