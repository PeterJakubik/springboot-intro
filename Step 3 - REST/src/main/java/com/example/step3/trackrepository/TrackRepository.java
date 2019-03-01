package com.example.step3.trackrepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrackRepository {

    private static final Logger logger = LoggerFactory.getLogger(TrackRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @return all tracks or empty collection
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Collection<Track>  getAll()
    {
        Query qry = entityManager.createQuery(String.format("SELECT t FROM %s t", com.example.step3.trackrepository.model.Track.class.getSimpleName()));

        var dbList = (List<com.example.step3.trackrepository.model.Track>)qry.getResultList();

        return dbList.stream()
                .map(com.example.step3.trackrepository.model.Track::toTrack)
                .collect(Collectors.toList());
    }

    /**
     * Find Track by its TrackId
     * @param trackId Unique Track id
     * @return Track if or {@code null} if not found
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Track findById(TrackId trackId)
    {
        var primaryKey = new com.example.step3.trackrepository.model.TrackId(trackId.getNid_c(), trackId.getNid_sp());

        var foundTrack = entityManager.find(com.example.step3.trackrepository.model.Track.class, primaryKey );

        if(foundTrack != null)
        {
            return foundTrack.toTrack();
        }

        return null;
    }

    /**
     * Insert new Track
     * @param track Track to insert
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public void insert(Track track)
    {
        var newTrack = com.example.step3.trackrepository.model.Track.fromTrack(track);

        entityManager.persist(newTrack);
    }

    /**
     * Remove all Tracks
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public void removeAll()
    {
        Query qry = entityManager.createQuery(String.format("DELETE FROM %s", com.example.step3.trackrepository.model.Track.class.getSimpleName()));

        int rowsDeleted = qry.executeUpdate();

        logger.info("Deleted {} tracks", rowsDeleted);
    }
}
