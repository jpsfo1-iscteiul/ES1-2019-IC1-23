package pack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class GBarras extends Application {
	
	private Defects defects;
	public void display(Defects defects){
		this.defects = defects;
		launch();

	}
	
	@Override public void start(Stage stage) {
		
		stage.setTitle("Gráfico de Barras");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String,Number> bc = 
				new BarChart<String,Number>(xAxis,yAxis);
		bc.setTitle(/*defects.getName()*/"ola");   
		yAxis.setLabel("Value");
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("PMD");       
		series1.getData().add(new XYChart.Data<String, Integer>("DCI",2 /*defects.getDCI()*/));
		series1.getData().add(new XYChart.Data<String, Integer>("DII", 3/*defects.getDII()*/));
		series1.getData().add(new XYChart.Data<String, Integer>("ADCI",4 /*defects.getADCI()*/));
		series1.getData().add(new XYChart.Data<String, Integer>("ADII",5 /*defects.getADII()*/));  

		Scene scene  = new Scene(bc,800,600);
		bc.getData().addAll(series1);
		stage.setScene(scene);
		stage.show();
	}
	

}