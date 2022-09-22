package dao;

import data.AddToPlaylist;
import data.Playlist;
import data.Songs;
import data.ViewPlaylist;
import util.ConnectionDB;
import util.JukeboxHome;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistDAO {
    public void createPlaylist(Playlist playlist){

            int rows=0;
            try {
                Connection connection = ConnectionDB.getConnection();
                String sql= "Insert into playlist(playlist_id,playlist_name)values(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,playlist.getPlaylistId());
                preparedStatement.setString(2,playlist.getPlaylistName());
                rows=preparedStatement.executeUpdate();
                if (rows==1){
                    System.out.println("Playlist created successfully");
                }
                else {
                    System.out.println("Playlist Not created");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    public List<Playlist> viewPlaylist(){
        List<Playlist> pl=new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            Statement st =connection.createStatement();
            String sql= "Select * from playlist";
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()){
                int pid= rs.getInt(1);
                String pName =rs.getString(2);
                pl.add(new Playlist(pid,pName));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return pl;
    }
    public List<ViewPlaylist> viewSongFromPlaylist(int playlistId){
        Connection connection=ConnectionDB.getConnection();
        List<ViewPlaylist> viewList=new ArrayList<>();
        try {
            String sql = "select songs.songs_id,songs.Song_Name,addtoplaylist.playlist_id From Songs inner join addtoplaylist on songs.Songs_id=addtoplaylist.songs_id where playlist_id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,playlistId);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                viewList.add(new ViewPlaylist(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return viewList;
    }

    public static void printPlaylist(List<Playlist>allSongs) {
        System.out.format("%-10s %-30s  \n", " Id","Playlist Name");
        for (Playlist songs : allSongs) {
            System.out.format("%-10s %-30s\n", songs.getPlaylistId(),songs.getPlaylistName());
        }
    }
    public static void printSongList(List<ViewPlaylist>viewPlaylists) {
        System.out.format("%-10s %-20s %-20s  \n", " SongId","Song Name","Playlist Id");
        for (ViewPlaylist viewPlaylist :viewPlaylists ) {
            System.out.format("%-10s %-20s  %-20s\n", viewPlaylist.getSongId(),viewPlaylist.getSongName(),viewPlaylist.getPlaylistId());
        }
    }

}
