package pack;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
	 
@SuppressWarnings("restriction")
public class GCircular extends Application {
	
	private Defects defects;
	
	public void display(Defects defects){
		this.defects = defects;
		launch();
	}
		 
    @Override 
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Gráfico Circular");
        stage.setWidth(500);
        stage.setHeight(500);
 
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("DCI", 2/*defects.getDCI()*/),
                new PieChart.Data("DII", 2/*defects.getDII()*/),
                new PieChart.Data("ADCI",2/* defects.getADCI()*/),
                new PieChart.Data("ADII", 2/*defects.getADII()*/));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("ola"/*defects.getName()*/);

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
	 
}