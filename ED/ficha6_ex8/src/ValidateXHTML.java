public class ValidateXHTML {

    public boolean validadorXHTML(String input) {
        Stack<String> stack = new Stack<>();
        String[] palavras = input.split(" ");

        for (String palavra : palavras) {
            if (palavra.startsWith("<") && palavra.endsWith(">")) {
                String tag = palavra.substring(1, palavra.length() - 1);
                if (tag.startsWith("/")) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    String openingTag = stack.pop();
                    if (!openingTag.equals(tag.substring(1))) {
                        return false;
                    }
                } else {
                    stack.push(tag);
                }
            }
        }
        return stack.isEmpty();
    }
}
