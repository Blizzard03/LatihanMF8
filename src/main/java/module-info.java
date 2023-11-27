module com.mariq.rasyid.latihanmf8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mariq.rasyid.latihanmf8 to javafx.fxml;
    exports com.mariq.rasyid.latihanmf8;
}
