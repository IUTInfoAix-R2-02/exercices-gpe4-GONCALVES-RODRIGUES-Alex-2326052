module tp.intro.javafx {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    exports com.example.partie2;
    opens com.example.partie3 to javafx.fxml;
    exports com.example.partie3;
}
