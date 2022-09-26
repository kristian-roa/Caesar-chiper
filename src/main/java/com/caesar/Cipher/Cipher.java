package com.caesar.Cipher;
import java.util.HashMap;

public class Cipher {
    private String text;
    private int shift;
    private boolean revert = false;

    public void setText(String text) {
        this.text = text;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public void setRevert(boolean revert) {
        this.revert = revert;
    }

    public String getText() {
        return text;
    }

    public int getShift() {
        return shift;
    }

    public boolean getRevert() {
        return revert;
    }

    public static HashMap<Character, Character> buildCode(char[] alphabet, int offset) {
        HashMap<Character, Character> code = new HashMap<>();

        int idx;
        for (int i = 0; i < alphabet.length; i++) {
            idx = (i + offset + alphabet.length) % alphabet.length;
            code.put(alphabet[i], alphabet[idx]);
        }

        return code;
    }

    public String encode() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzæøå ".toCharArray();
        HashMap<Character, Character> code = buildCode(alphabet, revert ? -shift : shift);

        StringBuilder output = new StringBuilder();

        for (char c : text.toCharArray()) {
            output.append(code.getOrDefault(c, c));
        }

        System.out.println(output);

        return output.toString();
    }
}
