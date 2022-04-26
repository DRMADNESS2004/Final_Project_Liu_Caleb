module com.example.final_project_liu_caleb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.final_project_liu_caleb to javafx.fxml;
    exports com.example.final_project_liu_caleb;
}