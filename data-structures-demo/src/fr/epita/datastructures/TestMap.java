package fr.epita.datastructures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map<String, Student> studentByEmail = new LinkedHashMap<>();
        studentByEmail.put("echoye@gmail.com", new Student("Echo"));
        studentByEmail.put("quentin@quentin.com", new Student("quentin"));
        studentByEmail.put("romainn@romain.com", new Student("romain"));
        System.out.println(studentByEmail);

    }
}
