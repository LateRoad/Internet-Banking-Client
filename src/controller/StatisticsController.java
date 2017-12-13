package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable{
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data<>("12/10/17", 10));
        series.getData().add(new XYChart.Data<>("13/10/17", 40));
        series.getData().add(new XYChart.Data<>("14/10/17", 70));
        series.getData().add(new XYChart.Data<>("15/10/17", 65));
        series.getData().add(new XYChart.Data<>("16/11/17", 69));
        series.getData().add(new XYChart.Data<>("20/11/17", 100));
        series.getData().add(new XYChart.Data<>("25/11/17", 120));

        series.setName("График переводов");

        lineChart.getData().addAll(series);
    }
}
