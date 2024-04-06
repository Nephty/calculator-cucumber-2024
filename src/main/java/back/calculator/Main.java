package back.calculator;

import java.util.logging.Logger;

/**
 *  This class is necessary for the compilation of the .jar file. See issue #16 for more information.
 */
public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        App.main(args);
    }
}