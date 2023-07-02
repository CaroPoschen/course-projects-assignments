module gui {
    requires javafx.controls;

    requires javafx.graphics;

    requires java.scripting;

    requires javafx.fxml;

    requires javafx.base;

    requires java.sql;

    requires ojdbc10;

    exports gui to javafx.graphics;

    opens gui.dataEntry;

    opens gui.main;

    opens gui.model;

    opens gui.overview;

    exports gui.model;

    exports gui.main;

    exports gui.overview;

    exports gui.dataEntry;
}