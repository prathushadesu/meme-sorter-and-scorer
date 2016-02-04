package com.comcast.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.comcast.dto.Meme;
import com.comcast.service.FileHandlerService;
import com.comcast.service.MemeScorerService;
import com.comcast.service.MemeSorterService;
import com.comcast.service.implementation.FileHandlerServiceImpl;
import com.comcast.service.implementation.MemeScorerServiceImpl;
import com.comcast.service.implementation.MemeSorterServiceImpl;

public class MemeSorterScorer {

	public static final Logger LOGGER = LogManager.getLogger(MemeSorterScorer.class);

	public static void main(String[] args) {
		MemeSorterScorer memeSorterScorer = new MemeSorterScorer();
		memeSorterScorer.run(args, memeSorterScorer);
	}
	
	private void run(String[] args, MemeSorterScorer memeSorterScorer) {

		boolean isProcessingCompletedSuccessfully = false;
		
		String filePath = "";
		String outputFilePath = "./memes.json";

		List<String> filePaths = retrieveFilePaths(args, filePath, outputFilePath);
		filePath = filePaths.get(0);
		outputFilePath = filePaths.get(1);

		List<Meme> memes = memeSorterScorer.readMemesFromFile(filePath);

		if (null != memes && !memes.isEmpty()) {
			memeSorterScorer.sortMemesByName(memes);
			memeSorterScorer.scoreMemes(memes);
			isProcessingCompletedSuccessfully = memeSorterScorer.updateFileWithScores(outputFilePath, memes);
		}
		
		if (isProcessingCompletedSuccessfully) {
			LOGGER.info("Memes have been read, sorted, scored and updated back to the file successfully");
		} else {
			LOGGER.info("Errors halted the processing of memes.");
		}		

	}
	
	@SuppressWarnings("resource")
	private List<String> retrieveFilePaths(String[] args, String filePath, String outputFilePath){
		List<String> filePaths = new ArrayList<String>();
		boolean isMemesFilePathSpecified = false;

		if (args.length > 0 && null != args[0] && !args[0].trim().isEmpty()) {
			isMemesFilePathSpecified = true;
			filePath = args[0];
			outputFilePath = filePath;
		}

		if (!isMemesFilePathSpecified || null == filePath || (null != filePath && filePath.trim().length() == 0)) {
			try {
				@SuppressWarnings("unused")
				FileReader fileReader = new FileReader("./memes.json");
				LOGGER.info("No file is specified as argument. Picking the default memes.json from the current directory.");
				filePath="./memes.json";
			} catch (FileNotFoundException e) {
				LOGGER.info("No file is specified as argument. Picking the default memes.json from the classpath.");
				ClassLoader classLoader = getClass().getClassLoader();
				filePath = classLoader.getResource("memes.json").getFile();
				LOGGER.info("Output can be found in the file memes.json created in the same directory as the execution.");
			}
		}
		filePaths.add(filePath);
		filePaths.add(outputFilePath);
		return filePaths;
	}
	
	private List<Meme> readMemesFromFile(String filePath) {
		List<Meme> memes = new ArrayList<Meme>(0);
		File file = new File(filePath);
		FileHandlerService fileHandlerService = new FileHandlerServiceImpl();
		memes = fileHandlerService.parseFile(file);
		return memes;
	}

	private List<Meme> sortMemesByName(List<Meme> memes){
		MemeSorterService memeSorterService = new MemeSorterServiceImpl();
		return memeSorterService.sort(memes);
	}

	private List<Meme> scoreMemes(List<Meme> memes){
		MemeScorerService memeScorerService = new MemeScorerServiceImpl();
		return memeScorerService.score(memes);
	}

	private boolean updateFileWithScores(String filePath, List<Meme> memes){
		boolean updateSuccessful = false;
		FileHandlerService fileHandlerService = new FileHandlerServiceImpl();
		try {
			updateSuccessful = fileHandlerService.updateFile(filePath, memes);
		} catch (IOException e) {
			LOGGER.error("File could not be updated with the updated memes due to ",e);
			LOGGER.error("These are the final memes: "+memes);
		}
		return updateSuccessful;
	}

}
