package com.comcast.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.comcast.dto.Meme;
import com.comcast.service.MemeSorterService;
import com.comcast.service.implementation.MemeSorterServiceImpl;

public class MemeSorterServiceImplTest {

	private List<Meme> sourceMemes = new ArrayList<Meme>();
	private List<Meme> expectedMemes = new ArrayList<Meme>();
	
	MemeSorterService memeSorterService = new MemeSorterServiceImpl();
	
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
		List<Meme> sortedListOfMemes = memeSorterService.sort(sourceMemes);
		Assert.assertArrayEquals(expectedMemes.toArray(), sortedListOfMemes.toArray());
	}
}
