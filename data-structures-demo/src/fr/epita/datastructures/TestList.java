package fr.epita.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList{
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList = Arrays.asList("test","of","init");

        System.out.println((stringList));
    }
}
