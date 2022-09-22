package util;


public class JukeboxHome {
    public void displayBanner() {
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
        System.out.println("" +
                "\n\t \t \t\t\t \t \t\t||  WELCOME TO THE JUKEBOX  ||");
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
    }
    public void displayMenu(){
        System.out.println("**** Jukebox Menu ****");
        System.out.println("1:View all songs & Play");
        System.out.println("2:Search Song From list");
        System.out.println("3:Create Your Playlist");
        System.out.println("4:View All Created Playlist");
        System.out.println("5:Exit Jukebox");
    }
    public void songMenu( ){
        System.out.println("**** Songs Menu ****");
        System.out.println("1.Play the song");
        System.out.println("2.Add to Playlist");
        System.out.println("3.To exit from Jukebox");
    }    public void playlistMenu( ){
        System.out.println("**** Playlist Menu ****");
        System.out.println("1.Add Songs to Playlist");
        System.out.println("2.To exit jukebox");
    }
    public void searchMenu( ){
        System.out.println("**** Search Menu ****");
        System.out.println("1.Search Song by Name");
        System.out.println("2.Search song by Genre");
        System.out.println("3.Search Song by Artist");
        System.out.println("4.To exit from jukebox");
    }

}
