package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongsDAOTest {
    SongsDAO songsDAO;
    int songList=0;


    @BeforeEach
    void setUp() {
        songsDAO=new SongsDAO();
    }

    @AfterEach
    void tearDown() {
        songsDAO=null;
    }

    @Test
    void getAllSongs() {
        int actual=songsDAO.getAllSongs().size();
        int expected=10;
        assertEquals(expected,actual);
    }
}