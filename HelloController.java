package com.example.javafxproject1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private TextField xPara;

    @FXML
    private TextField yPara;

    @Override
    public void initialize(URL Url, ResourceBundle resourceBundle) {
    }

    XYChart.Series seriesReal = new XYChart.Series();

    @FXML
    public void onAddDataClick() {
        String x = xPara.getText();
        int y = Integer.parseInt(yPara.getText());
        seriesReal.getData().add(new XYChart.Data(x, y));

        chart.getData().add(seriesReal);
    }
}
