package com.example.step3;

import com.example.step3.trackcalculator.TrackCalculator;
import com.example.step3.trackrepository.Gradient;
import com.example.step3.trackrepository.Track;
import com.example.step3.trackrepository.TrackId;
import com.example.step3.trackrepository.TrackRepository;
import com.example.step3.trackrepositoryapi.TrackRepositoryController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackageClasses = {TrackCalculator.class, TrackRepository.class, TrackRepositoryController.class} )
public class TestWithRepository {

	@Autowired
	private MockMvc mvc;

	private static short NID_C = 23;

	@Autowired
	private TrackRepository trackRepository;

	@Before
	public void setUp() {
		//this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testInsert() throws Exception {
		var trackId = new TrackId(NID_C,1);

		var track = new Track(trackId, 10, Gradient.Downhill);

		String trackJson = serializeToJson(track);

		this.mvc.perform(post("/tracks/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(trackJson))
				.andExpect(status().isOk());


		var foundTrack = trackRepository.findById(trackId);

		assertNotNull(foundTrack);
		assertEquals(trackId, foundTrack.getTrackId());
		assertEquals(10, foundTrack.getL_sp());
		assertEquals(Gradient.Downhill, foundTrack.getGradient());
	}

	@Test
	public void testFindNotFound() throws Exception {
		var trackId = new TrackId(NID_C,1);

		String trackJson = serializeToJson(trackId);

		this.mvc.perform(get("/tracks/find")
				.contentType(MediaType.APPLICATION_JSON)
				.content(trackJson))
				.andExpect(status().isNotFound());

	}

	public static String serializeToJson(Object source) throws JsonProcessingException {
		return serializeToJson(source, true);
	}

	public static String serializeToJson(Object source, boolean prettyPrint) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = prettyPrint ? mapper.writer().withDefaultPrettyPrinter() : mapper.writer();
		String requestJson = ow.writeValueAsString(source);

		return requestJson;
	}
}
