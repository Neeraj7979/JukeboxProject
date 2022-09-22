package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MusicPlayer {
    static int repeat=0;
    Connection con;
    Clip clip;
    public int songPlay(Connection con,int id) throws UnsupportedAudioFileException,IOException,LineUnavailableException, SQLException{
        Scanner sc=new Scanner(System.in);
        if (repeat==0){
        }
        String sql="select Filepath from songs where songs_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);

        ResultSet rs=ps.executeQuery();
        String Filepath="";
        while (rs.next()){
            Filepath= rs.getString(1);
        }
        File file=new File(Filepath);
        AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(file);
        clip=AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        String response="";
        while (!response.equals("C")){
            System.out.println("P=Play,PP=Pause,R=Reset,N=Next,PV=Previous,S=Stop,E=Exit");
            System.out.println("Enter Your Choice");
            response=sc.next();
            response=response.toUpperCase();
            switch (response){
                case ("P"):clip.start();
                break;
                case ("PP"):
                    clip.stop();
                    break;
                case ("N"):
                   clip.setMicrosecondPosition(0);
                   break;
                case ("PV"):
                    id--;
                    clip.close();
                    break;

                case ("R"):
                    clip.setMicrosecondPosition(500);
                    break;
                case ("E"):
                    System.exit(0);
                    break;
                case ("S"):
                    clip.close();
                    break;

            }

        }
        return id;

    }

}
