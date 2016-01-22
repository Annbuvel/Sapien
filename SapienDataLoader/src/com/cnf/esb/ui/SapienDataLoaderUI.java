package com.cnf.esb.ui;



import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SapienDataLoaderUI extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {
			System.out.println(Thread.currentThread().getContextClassLoader().getResource("SapienLoader.fxml"));
			Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("SapienLoader.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setTitle("SAPIEN Data Loader");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		launch(args);
	}

}
