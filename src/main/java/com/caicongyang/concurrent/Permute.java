package com.caicongyang.concurrent;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author 姚仲杰#80998699
 * @Date 2022/4/21 13:35
 */
public class Permute {

    static String seed = "abcdefghijklmnopqrstuvwxyz0123456789";
    static String model = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) throws FileNotFoundException {
        char[] chars = model.toCharArray();
        File file = new File("/Users/caicongyang/permute.out");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);
        List<Character> list = model.chars().mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        list.parallelStream().forEach(c->{
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            fullPermute(sb, chars, 6, chars.length);
        });
        //fullPermute(sb,chars,4,chars.length);

    }

    public static void fullPermute(StringBuilder sb, char[] chars, int len,
                                   int end) {
        if (sb.length() == len) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < end; i++) {
            sb.append(chars[i]);
            fullPermute(sb, chars, len, end);
            sb.deleteCharAt(sb.length() - 1);
            if (sb.length()==0){
                return;
            }
        }
    }
}