package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<String>[] checkModifications(Integer[] originalArray, Integer[] updatedArray) {
        List<Integer> originalList = Arrays.asList(originalArray);
        List<Integer> updatedList = Arrays.asList(updatedArray);

        List<Integer> newElements = new ArrayList<>(updatedList);
        newElements.removeAll(originalList);

        List<Integer> removedElements = new ArrayList<>(originalList);
        removedElements.removeAll(updatedList);

        return new List[]{ newElements, removedElements };
    }
    public static void main(String[] args) {
        Integer[] originalArray = {34, 56, 75};
        Integer[] updatedArray = {56, 48, 38};

        List<String>[] result = checkModifications(originalArray, updatedArray);

        System.out.println("New elements: " + result[0]);
        System.out.println("Removed elements: " + result[1]);
    }
}