package com.example.step1;

import com.example.step1.trackcalculator.TrackCalculator;
import com.example.step1.trackrepository.Gradient;
import com.example.step1.trackrepository.Track;
import com.example.step1.trackrepository.TrackId;
import com.example.step1.trackrepository.TrackRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = TrackCalculator.class
)
public class TestWithMock {

	private static short NID_C = 23;

	/**
	 * Inject TrackCalculator
	 */
	@Autowired
	private TrackCalculator trackCalculator;

	/**
	 * Mock for TrackRepository
	 */
	@MockBean
	private TrackRepository trackRepository;

	@Test
	public void testTrackCalculator()
	{
		var testTracks = List.of(
				new Track(new TrackId(NID_C,1), 10, Gradient.Downhill),
				new Track(new TrackId(NID_C,2), 20, Gradient.Downhill)
		);

		// Mock setup
		when(trackRepository.getAll())
				.thenReturn(testTracks);

		int computedLengthOfTestTracks = trackCalculator.computeAllTrackLengths();

		assertEquals(30, computedLengthOfTestTracks);
	}
}
