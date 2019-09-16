package myspring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ResourceUrl implements Resource {
    URL url;
    public ResourceUrl(URL url){
        this.url = url;
    }
    @Override
    public InputStream getInputStream() {
        URLConnection urlConnection = null;
        try {
            urlConnection = this.url.openConnection();
            urlConnection.connect();
            return urlConnection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
