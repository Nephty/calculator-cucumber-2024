package front.scenes;

import javafx.scene.Scene;

/**
 * Holds every required Scene for the Application.
 **/
public final class Scenes {
    private static Scene mainScene;

    private Scenes() {
        // Private constructor to hide the implicit public one
        throw new IllegalStateException("Utility class");
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public static void setMainScene(Scene mainScene) {
        Scenes.mainScene = mainScene;
    }
}
