package task;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 900; i++) {
            System.out.println(RandomPersonFactory.randomPerson().toString());
        }
    }
}

