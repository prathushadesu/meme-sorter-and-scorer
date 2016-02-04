package com.comcast.service;

import java.util.List;

import com.comcast.dto.Meme;
import com.comcast.service.implementation.MemeSorterServiceImpl;

/**
 * MemeSorterService is the interface specifying the sort operation(s) that can
 * be performed on a List of memes. This interface is implemented by
 * {@link MemeSorterServiceImpl} for meme-sorter-scorer project. As of version
 * 1.0, sort is the only method defined by the interface.
 * 
 * @author Prathusha
 * @since 1.0
 * 
 */
public interface MemeSorterService {

	List<Meme> sort(List<Meme> memes);

}
