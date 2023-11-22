package org.example;

import org.graalvm.polyglot.Context;
import org.intellij.lang.annotations.Language;

import java.util.Scanner;

@SuppressWarnings("NonAsciiCharacters")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("計算したい式を入力してください:");
        String 入力された式 = scanner.next();

        try (var context = Context.create()) {
            @Language("JavaScript")
            var script = STR. """
                    \{ 入力された式 }
                    """ ;
            var 計算結果 = context.eval("js", script);

            System.out.println(STR. "計算結果: \{ 計算結果 }" );
        }
    }
}