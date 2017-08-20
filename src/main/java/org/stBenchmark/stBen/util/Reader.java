package org.stBenchmark.stBen.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.stBenchmark.stBen.util.Logging;

public class Reader {
	private final static String DATA_DIRECTORY = "/Users/roseanealves/Rep/stBen/src/main/resources/data/";
	
	public JSONArray readFromJson(String docName) {
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		
		try {
			array = (JSONArray) parser.parse(new FileReader(DATA_DIRECTORY + docName));
			
		} catch (FileNotFoundException e) {
			Logging.getLogger(this.getClass()).info("Arquivo não encontrado!");
		} catch (IOException e) {
			Logging.getLogger(this.getClass()).info("Erro ao tentar ler o arquivo!");
		} catch (ParseException e) {
			Logging.getLogger(this.getClass()).info("Erro ao tentar converter o arquivo!");
		}
		return array;
	}
	
	public ListIterator<JSONArray> readAllDataFromDirectory() {
		List<JSONArray> files = new LinkedList<>();
		for (String name : getFileNamesFromDirectory()) {
			files.add(readFromJson(name));
		}
		return files.listIterator();
	}
	
	public List<String> getFileNamesFromDirectory() {
		List<String> fileNames = new ArrayList<>();
		try (Stream<Path> paths = Files.walk(Paths.get(DATA_DIRECTORY))) {
			paths
				.filter(Files::isRegularFile)
				.forEach(path -> fileNames.add(path.getFileName().toString()));
	
		} catch (IOException e) {
			Logging.getLogger(this.getClass()).info("Erro ao tentar ler arquivos do diretório!");
		} 
		return fileNames;
	}

}
