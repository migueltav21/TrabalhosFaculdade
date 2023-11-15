public class App {
    public static void main(String[] args) throws Exception {
        SmackStack<String> stack = new SmackStack<>(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        stack.push("Miguel");
        stack.push("Joao");
        stack.push("Pedro");
        stack.push("Sandra");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.toString());
        String nome = stack.smack();
        System.out.println(nome);
        System.out.println(stack.toString());
    }
}
