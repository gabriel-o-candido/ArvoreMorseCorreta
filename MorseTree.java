class MorseTree {
    private Node root;

    public MorseTree() {
        root = new Node('\0');
    }


    public void insert(char character, String morse) {
        Node current = root;
        for (char symbol : morse.toCharArray()) {
            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new Node('\0');
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new Node('\0');
                }
                current = current.right;
            }
        }
        current.character = character;
    }


    public String decode(String morse) {
        StringBuilder result = new StringBuilder();
        String[] letters = morse.split(" ");

        for (String letter : letters) {
            Node current = root;
            for (char symbol : letter.toCharArray()) {
                if (symbol == '.') {
                    current = current.left;
                } else if (symbol == '-') {
                    current = current.right;
                }
                if (current == null) {
                    return "Error: Invalid Morse code.";
                }
            }
            result.append(current.character);
        }
        return result.toString();
    }


    public void displayTree() {
        displayTreeRecursive(root, "");
    }

    private void displayTreeRecursive(Node current, String space) {
        if (current != null) {
            displayTreeRecursive(current.right, space + " --  ");
            System.out.println(space + current.character);
            displayTreeRecursive(current.left, space + "  --  ");
        }
    }
}