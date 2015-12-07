package ahhhlvin.c4q.nyc.itunesproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alvin2 on 12/6/15.
 */
public class Music {
        @SerializedName("artworkUrl100")
        @Expose
        private String musicPictureURL;


        @SerializedName("artistName")
        @Expose
        private String songArtistName;


        @SerializedName("trackCensoredName")
        @Expose
        private String songName;


        @SerializedName("primaryGenreName")
        @Expose
        private String songGenreName;


        @SerializedName("releaseDate")
        @Expose
        private String songReleaseDate;



        public String getSongArtistName() {
            return songArtistName;
        }

        public void setSongArtistName(String songArtistName) {
            this.songArtistName = songArtistName;
        }

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public String getSongGenreName() {
            return songGenreName;
        }

        public void setSongGenreName(String songGenreName) {
            this.songGenreName = songGenreName;
        }

        public String getSongReleaseDate() {
            return songReleaseDate;
        }

        public void setSongReleaseDate(String songReleaseDate) {
            this.songReleaseDate = songReleaseDate;
        }

        public String getMusicPictureURL() {
            return musicPictureURL;
        }

        public void setMusicPictureURL(String musicPictureURL) {
            this.musicPictureURL = musicPictureURL;
        }
}
