package com.learner.workshop.examples.session4;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @Author Debu Paul
 */

public class FilesExample {
	public static void main(String[] args) {
		try {
			List<String> allLines = Files.readAllLines(Paths.get("/home/manikandan/file.txt"));

			System.out.println("allLines = " + allLines);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Memory efficient way
		try (Stream<String> stream = Files.lines(Paths.get("/home/manikandan/file.txt"))) {
			stream.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// List files of a given directory
		try (Stream<Path> stream = Files.list(Paths.get("/home/manikandan"))) {

			String joined = stream.map(String::valueOf).filter(path -> !path.startsWith(".")).sorted()
					.collect(Collectors.joining("; "));

			System.out.println("List: " + joined);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
