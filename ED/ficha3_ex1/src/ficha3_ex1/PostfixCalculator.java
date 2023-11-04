/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficha3_ex1;
/**
 *
 * @author Rui Tavares
 */
public class PostfixCalculator {

    private ArrayStack<Float> stack;

    public PostfixCalculator() {
        stack = new ArrayStack<>();
    }

    private static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String caracter) {
        return caracter.equals("+") || caracter.equals("-") || caracter.equals("*") || caracter.equals("/");
    }

    private float conta(float a, float b, String operador) {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operador);
        }
    }

    public float conta(String expressao) {
        String[] token = expressao.split(" ");
        for (String num : token) {
            if (isFloat(num) == true) {
                float n = Float.parseFloat(num);
                stack.push(n);
                System.out.println(stack.toString());
                System.out.println("--------------");
            } else if (isOperator(num)) {
                float num1 = stack.pop();
                float num2 = stack.pop();
                float resultado = conta(num1, num2, num);
                stack.push(resultado);
                System.out.println(stack.toString());
                System.out.println("--------------");
            }
        }
        
        if (stack.size() == 1) {
            return stack.peek();
        } else {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
    }
}
