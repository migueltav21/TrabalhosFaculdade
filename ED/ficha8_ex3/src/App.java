public class App {
    public static void main(String[] args) throws Exception {
        Contact[] friends = new Contact[8];
        friends[0] = new Contact("Clark", "Kent", "610-555-7384");
        friends[1] = new Contact("Bruce", "Wayne", "215-555-3827");
        friends[2] = new Contact("Peter", "Parker", "733-555-2969");
        friends[3] = new Contact("James", "Howlett", "663-555-3984");
        friends[4] = new Contact("Steven", "Rogers", "464-555-3489");
        friends[5] = new Contact("Britt", "Reid", "322-555-2284");
        friends[6] = new Contact("Matt", "Murdock", "243-555-2837");
        friends[7] = new Contact("Carl", "Ayton", "298-213-6789");

        Contact[] friends2 = new Contact[8];
        friends2[0] = new Contact("Clark", "Kent", "610-555-7384");
        friends2[1] = new Contact("Bruce", "Wayne", "215-555-3827");
        friends2[2] = new Contact("Peter", "Parker", "733-555-2969");
        friends2[3] = new Contact("James", "Howlett", "663-555-3984");
        friends2[4] = new Contact("Steven", "Rogers", "464-555-3489");
        friends2[5] = new Contact("Britt", "Reid", "322-555-2284");
        friends2[6] = new Contact("Matt", "Murdock", "243-555-2837");
        friends2[7] = new Contact("Carl", "Ayton", "298-213-6789");

        Integer[] inteiros = { 4, 64, 77, 1, 44 };
        Integer[] inteiros2 = { 49, 64, 77, 1, 44 };
        Integer[] inteiros3 = { 3, 6, 8, 1, 4 };

        SortingandSearching.selectionSort(friends);
        for (int index = 0; index < friends.length; index++) {
            System.out.println(friends[index]);
        }
        System.out.println("-----------------------");

        SortingandSearching.insertionSort(friends2);
        for (int index = 0; index < friends.length; index++) {
            System.out.println(friends2[index]);
        }
        System.out.println("-----------------------");

        SortingandSearching.bubbleSort(inteiros);
        for (int index = 0; index < inteiros.length; index++)
            System.out.println(inteiros[index]);
        System.out.println("-----------------------");

        SortingandSearching.mergeSort(inteiros2, 0, inteiros2.length - 1);
        for (int index = 0; index < inteiros2.length; index++)
            System.out.println(inteiros2[index]);
        System.out.println("-----------------------");

        SortingandSearching.quickSort(inteiros3, 0, inteiros3.length - 1);
        for (int index = 0; index < inteiros3.length; index++)
            System.out.println(inteiros3[index]);
        System.out.println("-----------------------");

        // ---------------------------------------------------------------------

        Array<Integer> numeros = new Array<>(5);
        numeros.add(20);
        numeros.add(2);
        numeros.add(21);
        numeros.add(45);
        numeros.add(1);
        System.out.println(numeros.toString());
        SortingandSearching.bubbleSort(numeros.getArray());
    }

}
