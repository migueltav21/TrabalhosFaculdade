import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        OrderedList<Integer> lista = new OrderedList<>();
        System.out.println(lista.isEmpty());
        lista.add(10);
        lista.add(3);
        lista.add(33);
        System.out.println(lista.toString());
        Integer a = lista.first();
        Integer b = lista.last();
        System.out.println(a);
        System.out.println(b);
        lista.removeLast();
        lista.add(7);
        lista.add(21);
        System.out.println(lista.toString());
        System.out.println("------------------------");
        System.out.println(lista.contains(7));
        System.out.println("------------------------");
        Integer c = lista.removeLast();
        System.out.println(c);
        System.out.println(lista.toString());
        System.out.println(lista.contains(21));
        System.out.println(lista.remove(7));
        lista.add(300);
        System.out.println("------------------------");
        System.out.println(lista.toString());
        System.out.println("------------------------");
        Iterator<Integer> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
        }

        System.out.println("////////UNORDEREDLIST////////");
        UnorderedList<Integer> list = new UnorderedList<>();

        // Adicionar elementos
        list.addToFront(1);
        list.addToRear(2);
        list.addToRear(22);
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());
        list.addToFront(1);
        list.addToRear(2);
        list.addToRear(22);
        list.addAfter(4, 2);
        System.out.println(list.toString());
        Iterator<Integer> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Integer element = iterator2.next();
            System.out.println(element);
        }

        System.out.println("EXERCICIO 4 PT 2");
        UnorderedList<String> lista2 = new UnorderedList<>();
        lista2.addToFront("miguel");
        lista2.addToFront("joao");
        lista2.addToFront("rui");
        lista2.addToFront("Pedro");
        System.out.println(lista2.toString());
        System.out.println("--------------------");
        // Criação do array
        Iterator<String> iterator3 = lista2.iterator();
        String[] array = new String[lista2.size()];
        int index = 0;
        while (iterator3.hasNext()) {
            array[index] = iterator3.next();
            index++;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
