/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class aaa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char l = 'l';
        char p = 'p';
        int q = 2, d = 4;
        System.out.println(l);
        System.out.println(p);
        System.out.println(q);
        System.out.println(d);
        System.out.println(l + p + 2);
        System.out.println(' ' + l + p + 2);
        System.out.println(q + d);
        
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(array[0]);
        
        boolean a;
        int myBalance = 5;
        int hisBalance = 4;
        hisBalance += 8;
        a = hisBalance > myBalance;
        a = a & (hisBalance >= 3);
        System.out.println(a);
        
        int v = 0;
        v++;
        int amount = v++;
        System.out.println(++v + " " + amount);
        System.out.println(v);
     
        long num = 7;
        System.out.println(num);
        num = 3;
        System.out.println(num);
        boolean z = false;
        System.out.println(z);
     
        int n=1;
        double nn=2;
        System.out.println(n);
        System.out.println(nn);
    }

}
