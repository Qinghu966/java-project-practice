package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

import java.util.Arrays;
import java.util.List;
import java.util.zip.CheckedInputStream;

public class Launcher {

    public static void main(String[] args) {
        Shape t1 = new Triangle(20, 30, 25, 10);

        Shape c1 = new Circle(20);

        Shape s1 = new Square(10);

        List<Shape> shapes = Arrays.asList(t1, c1, s1);

        for (Shape shape : shapes){

            System.out.println(shape.calculateArea());
        }

        System.out.println(t1.calculatePerimeter());
        System.out.println(c1.calculatePerimeter());
        System.out.println(s1.calculatePerimeter());


    }
}
