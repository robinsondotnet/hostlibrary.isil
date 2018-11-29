package proy.util;

import java.util.ResourceBundle;

public class Util {
    public static final int JDBC=0;
    public static final int JPA=1;
    public static int opc;

        static {
        try {
            ResourceBundle properties = ResourceBundle.getBundle("proy.util.datos");

            opc= Integer.parseInt(properties.getString("opcion"));


        } catch (Exception e) {
        }
        }
}
