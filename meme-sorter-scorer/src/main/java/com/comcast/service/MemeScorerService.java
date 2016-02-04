package com.comcast.service;

import java.util.List;

import com.comcast.dto.Meme;

/**
 * MemeScorerService is the interface specifying the scoring operation(s) that
 * can be performed on a List of memes. This interface is implemented by
 * {@link MemeScorerServiceImpl} for meme-sorter-scorer project. As of version
 * 1.0, score is the only method defined by the interface.
 * 
 * @author Prathusha
 * @since 1.0
 * 
 */
public interface MemeScorerService {

	List<Meme> score(List<Meme> memes);

}
