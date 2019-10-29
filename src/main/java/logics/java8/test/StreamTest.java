package com.learning.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		// Create Stream using of()
		@SuppressWarnings("unused")
		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
		@SuppressWarnings("unused")
		Stream<Integer> stream2 = Stream.of(new Integer[] { 1, 2, 3, 4 });

		// Create sequential and parallel streams
		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> sequentialStream = myList.stream();
		System.out.print("The sequential stream is: ");
		sequentialStream.forEach(s -> System.out.print(s + " "));

		Stream<Integer> parallelStream = myList.parallelStream();
		System.out.print("\nThe parallel stream is: ");
		parallelStream.forEach(s -> System.out.print(s + " "));

		// Create stream using generate and iterate
		// Stream<String> stream3 = Stream.generate(() -> { return "abc"; });
		// Creates a infinite sequential stream
		// Stream<String> stream4 = Stream.iterate("abc", i -> i); Creates a
		// infinite sequential stream

		LongStream ls = Arrays.stream(new long[] { 1, 2, 3, 4 });
		System.out.print("\nThe Long stream is: ");
		ls.forEach(s -> System.out.print(s + " "));

		IntStream is = "abc".chars();
		System.out.print("\nThe Integer stream is: ");
		is.forEach(s -> System.out.print(s + " "));

		// Collect the stream to a collection
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println("\nThe list using collect is: " + intList);
		intStream = Stream.of(1, 2, 3, 4);
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i * i));
		System.out.println("The map using collect is: " + intMap);

		Stream<Integer> intStream1 = Stream.of(1, 2, 3, 4);
		Integer[] intArray = intStream1.toArray(Integer[]::new);
		System.out.println("The integer array is: " + Arrays.toString(intArray));

		// Filter example
		sequentialStream = myList.stream();
		Stream<Integer> highNums = sequentialStream.filter(p -> p > 5);
		System.out.print("The numbers greater than 5 are: ");
		highNums.forEach(s -> System.out.print(s + " "));

		// Map example
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.print("\nThe stream in Upper Case is: ");
		names.map(String::toUpperCase).forEach(s -> System.out.print(s + " "));

		// Sort example
		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		System.out.print("\nThe sorted stream in reverse order is: ");
		names2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
		names2 = Stream.of("aBc", "d", "ef", "123456");
		System.out.print("\nThe sorted stream is: ");
		names2.sorted().forEach(s -> System.out.print(s + " "));

		// FlatMap example
		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Sujay", "Sawant"),
				Arrays.asList("Vilas", "Sawant"), Arrays.asList("Supriya", "Sawant"));
		Stream<String> flatStream = namesOriginalList.flatMap(s -> s.stream());
		System.out.print("\nAll the elements in the list are: ");
		flatStream.forEach(s -> System.out.print(s + " "));

		// Reduce example
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> intOptional = numbers.reduce(Math::multiplyExact);
		intOptional.ifPresent(s -> System.out.print("\nThe multiplication of all the elements is: " + s));

		// Count example
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("\nThe total number of elements are " + numbers1.count());

		// Match example
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains 4? Answer: " + numbers2.anyMatch(n -> n == 4));

		Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream does not contains 4? Answer: " + numbers3.noneMatch(n -> n == 4));

		Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains all elements less than 4? Answer: " + numbers4.allMatch(n -> n < 4));

		//find first example
		Stream<String> names3 = Stream.of("Sujay", "Vilas", "Basker", "Arjun", "Stuti");
		Optional<String> firstNameWithA = names3.filter(name -> name.startsWith("P")).findFirst();
		System.out.println("The first Name with P is " + firstNameWithA.orElse("not there"));

	}

}
