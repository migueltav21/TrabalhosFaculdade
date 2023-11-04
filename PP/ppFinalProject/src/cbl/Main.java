package cbl;

import cbl.participant.*;
import cbl.participants.InstituitionType;

public class Main {

    public static void main(String[] args) {
        Contact contact = new Contact("niggaStreet", "niggaCity", "niggaState", "niggaZipCode",
                "niggaCountry", "niggaPhone");
        Instituition instituition = new Instituition("niggaName", "niggaEmail", InstituitionType.COMPANY,
                contact, "niggaSite", "niggaDescription");

        System.out.println(instituition.toString());

        int numbers[] = {1, 2, 3, 4, 5, 6, 7};
        Edition edicao1 = new Edition("qwqwqw", numbers);
        Edition edicao2 = new Edition("bkasls", numbers);
        Edition edicao3 = new Edition("aaaaa", numbers);
        System.out.println(edicao1.toString());
        

        Edition.add(edicao1);
        Edition.add(edicao2);
        int n = Edition.numeroDeEdicoesCBL();
        System.out.println(n);
        Edition.ativar(edicao1);
        Edition.ativar(edicao2);
        Edition.printEdicoes();
        System.out.println(Edition.procurarEdicao("aa"));
        System.out.println(Edition.procurarEdicao("qwqwqw"));
        Edition.remove(edicao3);
        Edition.remove(edicao2);
        Edition.printEdicoes();
        n = Edition.numeroDeEdicoesCBL();
        System.out.println(n);
    }
}
