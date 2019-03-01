package com.example.step2;

import com.example.step2.trackcalculator.TrackCalculator;
import com.example.step2.trackrepository.Gradient;
import com.example.step2.trackrepository.Track;
import com.example.step2.trackrepository.TrackId;
import com.example.step2.trackrepository.TrackRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackageClasses = {TrackCalculator.class, TrackRepository.class} )
public class TestWithRepository {

	private static short NID_C = 23;

	/**
	 * Inject TrackCalculator
	 */
	@Autowired
	private TrackCalculator trackCalculator;

	/**
	 * Inject TrackRepository
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
