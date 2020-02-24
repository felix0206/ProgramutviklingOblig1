import java.io.File;
import java.io.IOException;

public interface FileOpener {

    File velgFil();

    void lesFil() throws IOException;
}
