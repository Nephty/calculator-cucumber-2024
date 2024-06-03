package front.scenes;

import back.calculator.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Handles the loading of FXML files to create the Scenes.
 */
public final class SceneLoader {

    private SceneLoader() {
        // Private constructor to hide the implicit public one
        throw new IllegalStateException("Utility class");
    }

    /**
     * Takes the given scene name to find the corresponding FXML file.
     *
     * @param sceneName the name of the scene to load (that is, the name of the FXML file,
     *                  .fxml extension is not mandatory in the string, but it is in the name of the file
     * @return the Scene that was created from the FXML file
     */
    public static Scene load(String sceneName) {
        String updatedSceneName = sceneName;
        if (!updatedSceneName.endsWith(".fxml")) updatedSceneName += ".fxml";
        URL url = App.class.getResource("/xml/scenes/" + updatedSceneName);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        try {
            Parent sceneParent = fxmlLoader.load();
            return new Scene(sceneParent, 500, 500);
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(SceneLoader.class);
            String errorMessage = "FATAL ERROR while trying to load scene " + url;
            logger.error(errorMessage);
        }
        return null;
    }
}
