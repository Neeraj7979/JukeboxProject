package dao;



import data.AddToPlaylist;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToPlaylistDAO {
    public void addToPlaylist(AddToPlaylist addSongToPlaylist) {
        int rows=0;
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "Insert into addToPlaylist(playlist_id,songs_id)"+ "values(?,?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1,addSongToPlaylist.getPlaylist_id());
            preparedStatement.setInt(2,addSongToPlaylist.getSong_id());
            rows=preparedStatement.executeUpdate();
            if (rows==1){
                System.out.println("Songs Added");
            }
            else {
                System.out.println("Songs not added");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
