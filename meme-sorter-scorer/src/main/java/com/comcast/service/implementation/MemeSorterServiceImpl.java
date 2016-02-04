package com.comcast.service.implementation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.comcast.dto.Meme;
import com.comcast.service.MemeSorterService;

/**
 * 
 * MemeSorterServiceImpl implements {@link MemeSorterService} interface. For
 * version 1.0 sort method is implemented. A List of memes are passed as input
 * and the List is sorted based on the name of {@link Meme}. Sorted list of
 * memes are returned by the sort method. Default sort parameter is the name of
 * {@link Meme} for version 1.0.
 * 
 * @author Prathusha
 * @since 1.0
 * 
 */
public class MemeSorterServiceImpl implements MemeSorterService {

	public List<Meme> sort(List<Meme> memes) {
		Collections.sort(memes, new Comparator<Meme>() {
			public int compare(Meme meme1, Meme meme2) {
				return meme1.getName().compareTo(meme2.getName());
			}
		});
		return memes;
	}

}
