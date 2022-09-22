package dao;

import data.Songs;
import util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SongsDAO {
    public List<Songs> getAllSongs()  {
        List<Songs> allSongs = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            Statement st = connection.createStatement();
            String sql = "Select * From songs";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int songId = rs.getInt(1);
                String songName = rs.getString(2);
                String genre = rs.getString(3);
                String artistName = rs.getString(4);
                String duration = rs.getString(5);
                String releaseDate = rs.getString(6);
                allSongs.add(new Songs(songId,songName,genre,artistName,duration,releaseDate));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return allSongs;
    }
    public List<Songs> searchByName(String songs){
        Connection connection=ConnectionDB.getConnection();
        List<Songs> list=new ArrayList<>();
        try {
            String sql = "select * from songs where Song_Name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,songs);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                list.add(new Songs(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6)));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<Songs> searchByGenre(String genre){
        Connection connection=ConnectionDB.getConnection();
        List<Songs> genreList=new ArrayList<>();
        try {
            String sql = "select * from songs where Genre =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,genre);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                genreList.add(new Songs(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return genreList;
    }
    public List<Songs> searchByArtist(String artist){
        Connection connection=ConnectionDB.getConnection();
        List<Songs> artistList=new ArrayList<>();
        try {
            String sql = "select * from songs where Artist_Name =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,artist);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                artistList.add(new Songs(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return artistList;
    }


    public static void printAllSongs(List<Songs> allSongs) {
        System.out.format("%-10s %-17s %-17s %-15s  %-15s  %-15s \n", "SongsId", "SongsName", "Genre", "ArtistName",
                "Duration", "ReleaseDate");
        for (Songs songs : allSongs) {
            System.out.format("%-10s %-17s %-17s %-15s  %-15s  %-15s   \n",songs.getSongId(),
                    songs.getSongName(), songs.getGenre(), songs.getArtistName(),songs.getDuration(),
                    songs.getReleaseDate());
        }

    }




}
