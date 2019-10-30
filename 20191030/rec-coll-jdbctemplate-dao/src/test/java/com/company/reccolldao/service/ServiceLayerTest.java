package com.company.reccolldao.service;

import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    AlbumDao albumDao;
    ArtistDao artistDao;
    LabelDao labelDao;
    TrackDao trackDao;

    @Before
    public void setUp() throws Exception {
        setUpAlbumDaoMock();
        setUpArtistDaoMock();
        setUpLabelDaoMock();
        setUpTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);
    }

    @Test
    public void saveFindAlbum() {
        AlbumViewModel albumViewModel = new AlbumViewModel();
        albumViewModel.setListPrice(BigDecimal.valueOf(14.99));
        albumViewModel.setReleaseDate(LocalDate.of(1999, 05, 15));
        albumViewModel.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@kidcudi");
        artist.setTwitter("@kidcudi");
        artist.setName("Kid Cudi");
        artist = service.saveArtist(artist);

        albumViewModel.setArtist(artist);

        Label label = new Label();
        label.setName("Death Row");
        label.setWebsite("label.com");
        label = service.saveLabel(label);

        albumViewModel.setLabel(label);

        Track track = new Track();
        track.setRunTime(200);
        track.setTitle("Cudi Zone");
        List<Track> trackList = new ArrayList<>();
        trackList.add(track);

        albumViewModel.setTracks(trackList);

        albumViewModel = service.saveAlbum(albumViewModel);
        AlbumViewModel fromService = service.findAlbum(albumViewModel.getId());

        assertEquals(albumViewModel, fromService);
    }

    @Test
    public void findAllAlbums() {
    }

    @Test
    public void saveFindFindAllArtist() {
    }

    @Test
    public void saveFindFindAllLabel() {
    }

    // Helper methods
    private void setUpAlbumDaoMock() {
        // mock creates a stub or test double of the the AlbumDaoJdbcTemplateImpl
        albumDao = mock(AlbumDaoJdbcTemplateImpl.class);
        // this album represents an album stored in db with id = 1
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999,05,15));
        // this album represents an album we want to save in the db
        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999,05,15));
        List<Album> aList = new ArrayList<>();
        aList.add(album);
        // when the mock albumDao addAlbum method is called with 'album2'
        // do return 'album'
        doReturn(album).when(albumDao).addAlbum(album2);
        // when the mock albumDao getAlbum method is called the 'id = 1'
        // do return 'album'
        doReturn(album).when(albumDao).getAlbum(1);

        // when the mock albumDao getAllAlbum method is called
        // do return 'aList'
        doReturn(aList).when(albumDao).getAllAlbums();
    }

    private void setUpArtistDaoMock() {
        artistDao = mock(ArtistDaoJdbcTemplateImpl.class);

        Artist artist1 = new Artist();
        artist1.setId(1);
        artist1.setName("Kic Cudi");
        artist1.setTwitter("@kidcudi");
        artist1.setInstagram("@kidcudi");

        Artist artist2 = new Artist();
        artist2.setName("Kid Cudi");
        artist2.setTwitter("@kidcudi");
        artist2.setInstagram("@kidcudi");

        List<Artist> artistList = new ArrayList<>();
        artistList.add(artist1);

        doReturn(artist1).when(artistDao).addArtist(artist2);
        doReturn(artist1).when(artistDao).getArtist(1);
        doReturn(artistList).when(artistDao).getAllArtists();
    }

    private void setUpLabelDaoMock() {
        labelDao = mock(LabelDaoJdbcTemplateImpl.class);

        Label label1 = new Label();
        label1.setId(1);
        label1.setWebsite("label.com");
        label1.setName("Death Row");

        Label label2 = new Label();
        label2.setWebsite("label.com");
        label2.setName("Death Row");

        List<Label> labelList = new ArrayList<>();
        labelList.add(label1);

        doReturn(label1).when(labelDao).addLabel(label2);
        doReturn(label1).when(labelDao).getLabel(1);
        doReturn(labelList).when(labelDao).getAllLabels();
    }

    private void setUpTrackDaoMock() {
        trackDao = mock(TrackDaoJdbcTemplateImpl.class);

        Track track1 = new Track();
        track1.setId(1);
        track1.setTitle("Cudi Zone");
        track1.setRunTime(200);
        track1.setAlbumId(1);

        Track track2 = new Track();
        track2.setTitle("Cudi Zone");
        track2.setRunTime(200);
        track2.setAlbumId(1);

        List<Track> trackList = new ArrayList<>();
        trackList.add(track1);

        doReturn(track1).when(trackDao).addTrack(track2);
        doReturn(track1).when(trackDao).getTrack(1);
        doReturn(trackList).when(trackDao).getAllTracks();
//        doReturn(track1).when(trackDao).getTracksByAlbum(1);
    }

}