package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Class for running main method.
 *
 * @author Lukas Kokodic
 */
public class Demo {

    /**
     * @param args command line arguments, will be ignored
     * @throws FileNotFoundException exception
     * @throws IOException exception
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File input = new File("polygon-ok.txt");
        LabeledPolygon.Builder builder = new LabeledPolygon.Builder();
        try (FileInputStream stream = new FileInputStream(input)) {
            builder.addVertex("vrchol x", new Vertex2D(123, 456));
            builder.read(stream);
            LabeledPolygon polygon = builder.build();
            OutputStream oStream = System.out;
            polygon.writeJson(oStream);
            oStream.write("Hello World!".getBytes());
            oStream.write(System.lineSeparator().getBytes());
            oStream.flush();
        }
    }
}
