package com.example.demo;

import com.example.demo.trackcalculator.TrackCalculator;
import com.example.demo.trackrepository.Gradient;
import com.example.demo.trackrepository.Track;
import com.example.demo.trackrepository.TrackId;
import com.example.demo.trackrepository.TrackRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = {TrackCalculator.class, TrackRepository.class }
)
public class DemoApplicationTests {

	private static short NID_C = 23;

	/**
	 * Inject TrackCalculator
	 */
	@Autowired
	private TrackCalculator trackCalculator;

	/**
	 * Mock for TrackRepository
	 */
	@Autowired
	private TrackRepository trackRepository;

	@Test
	public void testInsertFind()
	{
		var trackId = new TrackId(NID_C,1);

		trackRepository.insert(new Track(trackId, 10, Gradient.Downhill));

		var foundTrack = trackRepository.findById(trackId);

		assertNotNull(foundTrack);
		assertEquals(trackId, foundTrack.getTrackId());
		assertEquals(10, foundTrack.getL_sp());
		assertEquals(Gradient.Downhill, foundTrack.getGradient());
	}

	@Test
	public void testTrackCalculator()
	{
		trackRepository.insert(new Track(new TrackId(NID_C,1), 10, Gradient.Downhill));
		trackRepository.insert(new Track(new TrackId(NID_C,2), 20, Gradient.Downhill));

		int computedLengthOfTestTracks = trackCalculator.computeAllTrackLengths();

		assertEquals(30, computedLengthOfTestTracks);
	}
}
