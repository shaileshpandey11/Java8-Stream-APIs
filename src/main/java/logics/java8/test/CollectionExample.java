package com.java8.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionExample {

	public static void main(String[] args) throws IOException {

		List<Person1> persons = new ArrayList<Person1>();
		
		Files
			.lines(Paths.get(System.getProperty("user.dir") + "/People.txt"))
			.collect(Collectors.toList())
			.stream()
			.map(line -> {
				String[] s = line.split(" ");
				Person1 p = new Person1(s[0].trim(), Integer.parseInt(s[1]));
				persons.add(p);
				return p;
			})
			.forEach(System.out::println);
		
		Stream<Person1> stream1 = persons.stream();
		
		Optional<Person1> opt = stream1.filter(p -> p.getAge() >= 20)
			.min(Comparator.comparing(Person1::getAge));
		
		System.out.println("The yongest person in the group whose age is greater than 20 is " + opt.get().getName() + " and person's age is " + opt.get().getAge());
		
		Optional<Person1> opt1 = persons.stream().max(Comparator.comparing(Person1::getAge));
		
		System.out.println("The oldest person in the group is " + opt1.get().getName() + " and person's age is " + opt1.get().getAge());
		
		Map<Integer, List<Person1>> map = persons.stream()
				.collect(Collectors.groupingBy(Person1::getAge));
		
		System.out.println(map);
		
		Map<Integer, Long> map1 = persons.stream()
				.collect(Collectors.groupingBy(Person1::getAge, Collectors.counting()));
		
		System.out.println(map1);
		
		Map<Integer, Set<String>> map2 = persons.stream()
				.collect(Collectors.groupingBy(Person1::getAge, Collectors.mapping(Person1::getName, Collectors.toSet())));
		
		System.out.println(map2);
		
		Map<Integer, String> map3 = persons.stream()
				.collect(Collectors.groupingBy(Person1::getAge, Collectors.mapping(Person1::getName, Collectors.joining(", "))));
		
		System.out.println(map3);
		
		Map<String, String> map4 = persons.stream()
				.collect(Collectors.groupingBy(Person1::getName, Collectors.mapping(p -> String.valueOf(p.getAge()), Collectors.joining())));
		
		System.out.println(map4);
		
		map4.forEach((k,v) -> {
			String format = "%-30s%s%n";
			System.out.printf(format, "Person = " + k, "Age = " + v);
		});
		
	}

}
