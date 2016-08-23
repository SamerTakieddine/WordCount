package com.samer.mapreduce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class WordCount {

	public static void main(String[] args) throws Exception {
		
		String text = "Hadoop is an exciting topic and is hot in the market. It was an art created by google to address the growing data and to benefit from the information created by various sources like social media, hand held devices web etc";
		WordCount wc = new WordCount();
		wc.splitWords(text);
		wc.consolidate();
	}
	public void splitWords(String text) throws IOException
	{
		String[] parts = text.split(" ");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/Input/inter.txt")));
		int One = 1;
		for(String val: parts)
		{
			writer.append(val + "," + One + "\n");
		}
		writer.close();
	}
	public void consolidate() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/Input/inter.txt")));
		String line;
		int One = 1;
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		while((line=reader.readLine())!=null)
		{
			String[] parts = line.split(",");
			if(result.containsKey(parts[0]))
			{
				result.put(parts[0], result.get(parts[0]) + One);
			}else
			{
				result.put(parts[0], One);
			}
		}
		reader.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/Output/inter.txt")));
		for(String key: result.keySet())
		{
			writer.append(key + "," + result.get(key) + "\n" );
		}
		writer.close();
	}
}
