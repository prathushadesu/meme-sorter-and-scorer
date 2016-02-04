package com.comcast.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.comcast.dto.Meme;
import com.comcast.service.MemeScorerService;

public class MemeScorerServiceImplTest {
	private List<Meme> sourceMemes = new ArrayList<Meme>();
	private List<Meme> expectedMemes = new ArrayList<Meme>();

	MemeScorerService memeScorerService = new MemeScorerServiceImpl();

	@Before
	public void initMemes() {

		for (int i = 9; i >= 0; i--) {
			Meme meme = new Meme();
			meme.setName(i + ":meme");
			meme.setLulzScore(5);
			sourceMemes.add(meme);
		}

		for (int i = 0; i < 10; i++) {
			Meme meme = new Meme();
			meme.setName(i + ":meme");
			meme.setLulzScore(5);
			expectedMemes.add(meme);
		}

	}

	@Test
	public void testSort() {
		/**
		 * Since scoring is based on random integers, in this first test case,
		 * the size of list is asserted.
		 */
		List<Meme> scoredListOfMemes = memeScorerService.score(sourceMemes);
		Assert.assertSame(expectedMemes.size(), scoredListOfMemes.size());
	}

}
