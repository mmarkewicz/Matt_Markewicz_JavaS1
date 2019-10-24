package com.company.reccolldao.dao;

import com.company.reccolldao.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TrackDaoJdbcTemplateImpl implements TrackDao {

    // prepared statements
    private static final String INSERT_TRACK_SQL =
            "INSERT INTO track (album_id, label, runtime) VALUES (?, ?, ?)";

    private static final String SELECT_TRACK_SQL =
            "SELECT * FROM track WHERE track_id = ?";

    private static final String SELECT_ALL_TRACKS_SQL =
            "SELECT * FROM track";

    private static final String UPDATE_TRACK_SQL =
            "UPDATE track SET album_id = ?, label = ?, runtime = ? WHERE track_id = ?";

    private static final String DELETE_TRACK_SQL =
            "DELETE FROM track WHERE track_id = ?";

    JdbcTemplate jdbcTemplate;

    public TrackDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Track addTrack(Track track) {
        jdbcTemplate.update(INSERT_TRACK_SQL,
                track.getAlbumId(),
                track.get(),
                track,get)
        return null;
    }

    @Override
    public Track getTrack(int id) {
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public List<Track> getTracksByAlbum(int albumId) {
        return null;
    }

    @Override
    public void updateTrack(Track track) {

    }

    @Override
    public void deleteTrack(int id) {

    }

    private Track mapRowToTrack(ResultSet rs, int rowNum) throws SQLException {
        Track track = new Track();
        track.setId(rs.getInt("track_id"));
        track.setAlbumId(rs.getInt("album_id"));
        track.setRunTime(rs.getInt("runtime"));
        track.setTitle(rs.getString("title"));
        return track;
    }
}
