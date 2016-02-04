package com.comcast.service.implementation;

import java.util.List;
import java.util.Random;

import com.comcast.dto.Meme;
import com.comcast.service.MemeScorerService;

/**
 * 
 * MemeScorerServiceImpl implements {@link MemeScorerService} interface. For
 * version 1.0 score method is implemented. A List of memes are passed as input
 * and each List element, which is a {@link Meme} is associated a lulzScore
 * ranging from 1-10. Scored list of memes are returned by the score method.
 * Default score criteria is random 1-10 for version 1.0.
 * 
 * @author Prathusha
 * @since 1.0
 * 
 */
public class MemeScorerServiceImpl implements MemeScorerService {

	private static final int LULZ_SCORE_UPPER_LIMIT = 10;
	private static final int LULZ_SCORE_LOWER_LIMIT = 1;

	public List<Meme> score(List<Meme> memes) {
		for(Meme meme:memes){
			meme.setLulzScore(computeLulzScore());
		}
		return memes;
	}

	private int computeLulzScore() {
		Random random = new Random();
		int lulzScore = random.nextInt(LULZ_SCORE_UPPER_LIMIT- LULZ_SCORE_LOWER_LIMIT) + LULZ_SCORE_LOWER_LIMIT;
		return lulzScore;
	}

}
