package myspring.io;

import java.io.InputStream;

public class ResourceLoader {
    public InputStream getResource(Resource resource){
        return resource.getInputStream();
    }
}
