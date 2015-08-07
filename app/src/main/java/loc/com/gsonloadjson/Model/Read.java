package loc.com.gsonloadjson.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by loc on 07/08/2015.
 */


public class Read {

    static public class ListImage {

        @SerializedName("response")
        ArrayList<Data> list;

        public ArrayList<Data> getlist() {
            return list;
        }
    }


    static public class Data {

        @SerializedName("id")
        String id;
        @SerializedName("image")
        public image imagel;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public image getImagel() {
            return imagel;
        }

        public void setImagel(image imagel) {
            this.imagel = imagel;
        }
    }

    static public class image {
        @SerializedName("url")
        String url;

        public image(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

         public image(){};
    }
}
