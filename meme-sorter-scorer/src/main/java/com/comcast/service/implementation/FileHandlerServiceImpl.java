package com.comcast.service.implementation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.comcast.dto.Meme;
import com.comcast.service.FileHandlerService;

/**
 * 
 * FileHandlerServiceImpl implements {@link FileHandlerService} interface. For
 * version 1.0 parseFile and updateFile methods are implemented.
 * 
 * For parseFile, filePath is passed as an argument. The file is read and the
 * content is parsed to a List of Meme objects. This List of Meme objects is
 * returned. For version 1.0 parseFile logs the exceptions to the log file, if
 * file is found and the content cannot be read. An empty List is returned in
 * the error case.
 * 
 * For updateFile, filePath
 * 
 * @author Prathusha
 * @since 1.0
 * 
 */
public class FileHandlerServiceImpl implements FileHandlerService {

	public static final Logger LOGGER = LogManager.getLogger(FileHandlerServiceImpl.class);

	public List<Meme> parseFile(File file) {
		List<Meme> memes = new ArrayList<Meme>(0);
		try {
			LOGGER.info("Reading the memes from " + file.getAbsolutePath());
			FileReader fileReader = new FileReader(file);

			JSONParser parser = new JSONParser();
			JSONArray jsonMemes = (JSONArray) parser.parse(fileReader);

			for (Object meme : jsonMemes) {
				try {
					String name = String.valueOf(((JSONObject) meme).get("name"));
					Integer lulzScore = Integer.valueOf(((JSONObject) meme).get("lulzScore").toString());
					memes.add(new Meme(name, lulzScore));
				} catch (Exception ex) {
					LOGGER.error("Error extracting one of the memes. For version 1.0, skipping it and proceeding further.", ex);
					continue;
				}
			}
		} catch (ParseException ex) {
			LOGGER.error("Unable to parse the memes from the file provided due to ", ex);
		} catch (Exception ex) {
			LOGGER.error("Unable to read the memes from the file provided due to ",	ex);
		}
		return memes;
	}

	@SuppressWarnings("unchecked")
	public boolean updateFile(String filePath, List<Meme> memes) throws IOException {
		File outputFile = new File(filePath);
		FileWriter fooWriter = new FileWriter(outputFile, false); 
		JSONArray jsonArray = new JSONArray();
		for (Meme meme:memes) {
			JSONObject memeObject = new JSONObject();
			memeObject.put("name", meme.getName());
			memeObject.put("lulzScore", meme.getLulzScore());
			jsonArray.add(memeObject);
		}
		fooWriter.write(jsonArray.toJSONString());
		LOGGER.info("Updated the results to "+outputFile.getAbsolutePath());
		fooWriter.close();
		return true;
	}

}
