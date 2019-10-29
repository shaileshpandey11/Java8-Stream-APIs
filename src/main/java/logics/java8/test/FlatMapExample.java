package com.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String... args) {
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(2, 4, 6);
		List<Integer> list3 = Arrays.asList(3, 5, 7);
		
		List<List<Integer>> list = Arrays.asList(list1, list2, list3);
		
		System.out.println("The list is:\n" + list);
		
		//Fuction for normal map
		Function<List<?>, Integer> size = List::size; // same as l -> l.size()
		
		//Function for flatMap
		Function<List<Integer>, Stream<Integer>> flatMap = List::stream;
		
		System.out.println("Size of each list:");
		list.stream()
			.map(size)
			.forEach(System.out::println);
		
		System.out.println("Content of each list:");
		list.stream()
			.flatMap(flatMap)
			.forEach(System.out::println);
		
	}

}
