package com.comcast.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.comcast.dto.Meme;
import com.comcast.service.implementation.FileHandlerServiceImpl;

/**
 * FileHandlerService is the interface specifying the file operations that can
 * be performed. This interface is implemented by {@link FileHandlerServiceImpl}
 * for meme-sorter-scorer project. As of version 1.0 parseFile, updateFile are
 * the methods defined by the interface.
 * 
 * @author Prathusha
 * @since 1.0
 * 
 */
public interface FileHandlerService {

	public List<Meme> parseFile(File file);

	public boolean updateFile(String filePath, List<Meme> memes) throws IOException;

}
