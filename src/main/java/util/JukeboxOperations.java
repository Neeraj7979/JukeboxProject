package util;

import dao.AddToPlaylistDAO;
import dao.PlaylistDAO;
import dao.SongsDAO;
import data.AddToPlaylist;
import data.Playlist;
import data.Songs;
import data.ViewPlaylist;

import java.util.List;
import java.util.Scanner;

public class JukeboxOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JukeboxHome j1 = new JukeboxHome();
        j1.displayBanner();
        j1.displayMenu();
        boolean flag = false;
        while (!flag) {
            int choice = sc.nextInt();
            j1.displayMenu();
            if (choice == 1) {
                j1.displayBanner();
                List<Songs> s1 = new SongsDAO().getAllSongs();
                SongsDAO.printAllSongs(s1);
                j1.songMenu();
                int ip1 = sc.nextInt();
                switch (ip1) {
                    case 1:
                        MusicPlayer m1 = new MusicPlayer();
                        System.out.println("Enter the song id to play the song");
                        int i = sc.nextInt();
                        try {
                            m1.songPlay(ConnectionDB.getConnection(), i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        List<Playlist> plist = new PlaylistDAO().viewPlaylist();
                        PlaylistDAO.printPlaylist(plist);
                        System.out.println("Enter Playlist id");
                        PlaylistDAO pd1 = new PlaylistDAO();
                        int pId = sc.nextInt();
                        List<Songs> sg = new SongsDAO().getAllSongs();
                        SongsDAO.printAllSongs(sg);
                        System.out.println("Enter Song id");
                        SongsDAO sd1 = new SongsDAO();
                        sd1.getAllSongs();
                        int sId = sc.nextInt();
                        AddToPlaylist ad = new AddToPlaylist(pId, sId);
                        AddToPlaylistDAO adp = new AddToPlaylistDAO();
                    case 3:
                        System.exit(0);
                }
            }
            if (choice == 2) {
                j1.displayBanner();
                j1.searchMenu();
                int ip2 = sc.nextInt();
                switch (ip2) {
                    case 1:
                        System.out.println("Enter Song Name");
                        sc.nextLine();
                        String sName = sc.nextLine();
                        List<Songs> s2 = new SongsDAO().searchByName(sName);
                        SongsDAO.printAllSongs(s2);
                        MusicPlayer m1 = new MusicPlayer();
                        System.out.println("Enter the song id to play the song");
                        int i = sc.nextInt();
                        try {
                            m1.songPlay(ConnectionDB.getConnection(), i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.println("Enter Genre Name");
                        sc.nextLine();
                        String gName = sc.nextLine();
                        List<Songs> s3 = new SongsDAO().searchByGenre(gName);
                        SongsDAO.printAllSongs(s3);
                        MusicPlayer m3 = new MusicPlayer();
                        System.out.println("Enter the song id to play the song");
                        int k = sc.nextInt();
                        try {
                            m3.songPlay(ConnectionDB.getConnection(), k);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
            if (choice == 3) {
                System.out.println("Enter playlist id to create");
                int pid = sc.nextInt();
                System.out.println("Enter Playlist Name to Create");
                sc.nextLine();
                String pList = sc.nextLine();
                Playlist p1 = new Playlist(pid, pList);
                PlaylistDAO pd = new PlaylistDAO();
                pd.createPlaylist(p1);
                j1.playlistMenu();
                int ip3 = sc.nextInt();
                switch (ip3) {
                    case 1:
                        List<Playlist> plist = new PlaylistDAO().viewPlaylist();
                        PlaylistDAO.printPlaylist(plist);
                        System.out.println("Enter Playlist id");
                        PlaylistDAO pd1 = new PlaylistDAO();
                        int pId = sc.nextInt();
                        List<Songs> sg = new SongsDAO().getAllSongs();
                        SongsDAO.printAllSongs(sg);
                        System.out.println("Enter Song id");
                        SongsDAO sd1 = new SongsDAO();
                        sd1.getAllSongs();
                        int sId = sc.nextInt();
                        AddToPlaylist ad = new AddToPlaylist(pId, sId);
                        AddToPlaylistDAO adp = new AddToPlaylistDAO();
                        adp.addToPlaylist(ad);
                        while (!false) {
                            System.out.println(" 1.To Add More Song\n 2.Play Songs \n 3.View Playlist");
                            int choice1 = sc.nextInt();
                            if (choice1 == 1) {
                                List<Playlist> plist1 = new PlaylistDAO().viewPlaylist();
                                PlaylistDAO.printPlaylist(plist1);
                                System.out.println("Enter Playlist id");
                                int pId1 = sc.nextInt();
                                List<Songs> sg1 = new SongsDAO().getAllSongs();
                                SongsDAO.printAllSongs(sg1);
                                System.out.println("Enter Song id");
                                int sId1 = sc.nextInt();
                                AddToPlaylist ad1 = new AddToPlaylist(pId1, sId1);
                                AddToPlaylistDAO adp1 = new AddToPlaylistDAO();
                                adp1.addToPlaylist(ad1);
                            } else if (choice == 2) {
                                MusicPlayer m1 = new MusicPlayer();
                                System.out.println("Enter the song id to play the song");
                                int i = sc.nextInt();
                                try {
                                    m1.songPlay(ConnectionDB.getConnection(), i);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            } else if (choice == 3) {
                                List<Playlist> plist1 = new PlaylistDAO().viewPlaylist();
                                PlaylistDAO.printPlaylist(plist1);
                                System.out.println("Enter Playlist id to view song");
                                int pId1 = sc.nextInt();
                                List<ViewPlaylist> s5 = new PlaylistDAO().viewSongFromPlaylist(pId1);
                                PlaylistDAO.printSongList(s5);

                            } else {
                                System.exit(0);
                            }
                        }
                        break;
                    case 2:
                        System.exit(0);

                }
            }
            List<Playlist>plist1=new PlaylistDAO().viewPlaylist();
            PlaylistDAO.printPlaylist(plist1);
            System.out.println("Enter Playlist id to view song");
            int pId1 =sc.nextInt();
            List<ViewPlaylist> s5=new PlaylistDAO().viewSongFromPlaylist(pId1);
            PlaylistDAO.printSongList(s5);
            System.out.println("1.Play Song\n2.Add song to Playlist\n3.Exit Jukebox");

            int choice2= sc.nextInt();
            if (choice2==1){
                MusicPlayer m1=new MusicPlayer();
                System.out.println("Enter the song id to play the song");
                int i=sc.nextInt();
                try{
                    m1.songPlay(ConnectionDB.getConnection(),i);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;

            } else if (choice==2) {
                List<Playlist>plist=new PlaylistDAO().viewPlaylist();
                PlaylistDAO.printPlaylist(plist);
                System.out.println("Enter Playlist id");
                PlaylistDAO pd1=new PlaylistDAO();
                int pId =sc.nextInt();
                List<Songs> sg=new SongsDAO().getAllSongs();
                SongsDAO.printAllSongs(sg);
                System.out.println("Enter Song id");
                SongsDAO sd1=new SongsDAO();
                sd1.getAllSongs();
                int sId=sc.nextInt();
                AddToPlaylist ad = new AddToPlaylist(pId,sId);
                AddToPlaylistDAO adp= new AddToPlaylistDAO();
                adp.addToPlaylist(ad);
                while (!false){
                    System.out.println(" 1.To Add More Song\n 2.Play Songs \n 3.To Exit Jukebox");
                    int choice1=sc.nextInt();
                    if (choice1==1){
                        List<Playlist>plist2=new PlaylistDAO().viewPlaylist();
                        PlaylistDAO.printPlaylist(plist2);
                        System.out.println("Enter Playlist id");
                        int pId2 =sc.nextInt();
                        List<Songs> sg2=new SongsDAO().getAllSongs();
                        SongsDAO.printAllSongs(sg2);
                        System.out.println("Enter Song id");
                        int sId2=sc.nextInt();
                        AddToPlaylist ad2 = new AddToPlaylist(pId2,sId2);
                        AddToPlaylistDAO adp2= new AddToPlaylistDAO();
                        adp2.addToPlaylist(ad2);
                    }
                    else if (choice==2){
                        MusicPlayer m1=new MusicPlayer();
                        System.out.println("Enter the song id to play the song");
                        int i=sc.nextInt();
                        try{
                            m1.songPlay(ConnectionDB.getConnection(),i);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        break;
                    }
                    else {
                        System.exit(0);
                    }
                }

            }

        }
    }
}
