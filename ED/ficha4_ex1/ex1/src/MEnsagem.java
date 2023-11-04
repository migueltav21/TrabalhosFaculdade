public class MEnsagem {
        private String mensagem;
        private Queue<Character> queue;
        int num;

        public MEnsagem(String mess) {
            mensagem = mess;
            queue = new Queue<Character>();
            num = 0;
            addToQueue();
        }

        private void addToQueue() {
            char[] caracteres = mensagem.toCharArray();

            for (char c : caracteres) {
                queue.enqueue(c);
            }
        }

        public void printMensagem() {
            System.out.println(queue.toString());
        }

        private char encodeChar(char c, int shift) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            return (char) ((c - base + shift) % 26 + base);
        }

        private char decodeChar(char c, int shift) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            int decodedChar = (c - base - shift) % 26;
            if (decodedChar < 0) {
                decodedChar += 26;
            }
            return (char) (decodedChar + base);
        }

        public void codificarMensagem(int n) {
            num = n;
            char caracter;
            for (int i = 0; i < queue.size(); i++) {
                caracter = queue.dequeue();
                if (Character.isLetter(caracter)) {
                    char caracterCriptografado = encodeChar(caracter, n);
                    queue.enqueue(caracterCriptografado);
                } else {
                    queue.enqueue(caracter);
                }
            }

        }

        public void descodificarMensagem() {
            char caracter;
            for (int i = 0; i < queue.size(); i++) {
                caracter = queue.dequeue();
                if (Character.isLetter(caracter)) {
                    char caracterCriptografado = decodeChar(caracter, num);
                    queue.enqueue(caracterCriptografado);
                } else {
                    queue.enqueue(caracter);
                }
            }

        }

    }

