
package com.cnf.esb.ui.controller;
import javafx.scene.control.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



import com.cnf.esb.SapienDataLoader;
import com.cnf.esb.ui.beans.ConnectionSetting;
import com.cnf.esb.ui.beans.DatabaseType;
import com.cnf.esb.ui.utils.ConnectionSettingsHandler;
import com.cnf.esb.utils.SapienDataLoadHelper;
import com.cnf.exceptions.SapienDataLoaderConfigException;
import com.cnf.exceptions.SapienDataLoaderException;


import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;


import javafx.fxml.*;


public class SapienDataUploadController implements Initializable{

	@FXML private Stage stage;
	@FXML private TextField filePath;
	@FXML private TextArea messageBox;
	@FXML private Button upload;
	@FXML private Button setDBParams;
	@FXML private Button browse;
	@FXML private ComboBox<ConnectionSetting> dbConnectionProfile;
	@FXML private ComboBox<DatabaseType> dbType;
	@FXML private TextField connectionName;
	@FXML private TextField jdbcURL;
	@FXML private TextField dbUser;
	@FXML private TextField dbPass;
	@FXML private Label connectionStatus;
	
	

	@Override
	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		List<ConnectionSetting> connectionSettings = ConnectionSettingsHandler.getInstance().readConnectionSettings();
		dbConnectionProfile.getItems().clear();
		dbConnectionProfile.getItems().addAll(connectionSettings);
		List<DatabaseType> databaseTypes = ConnectionSettingsHandler.getInstance().getDatabaseTypes();
		dbType.getItems().clear();
		dbType.getItems().addAll(databaseTypes);
		
		
	}
	
	@FXML
	public void setDataSourceConnection(ActionEvent event){
		
		ConnectionSetting connectionSetting =new ConnectionSetting();
		String connName = connectionName.getText();
		connectionSetting.setConnectionProfile(connectionName.getText());
		DatabaseType dbType =this.dbType.getSelectionModel().getSelectedItem();
		dbType.setJdbcURL(this.jdbcURL.getText());
		connectionSetting.setDatabaseType(dbType);
		connectionSetting.setUserName(this.dbUser.getText());
		connectionSetting.setPassword(this.dbPass.getText());

		if(!connName.isEmpty()){
		ConnectionSettingsHandler.getInstance().writeConnectionSettings(connectionSetting);
		this.dbConnectionProfile.getItems().add(connectionSetting);

		}
		SapienDataLoadHelper.initialize(connectionSetting);
		this.browse.setDisable(false);
		this.upload.setDisable(false);
	
	}
	
	@FXML
	public void populateConnectionSettings(ActionEvent event){
	
	}
	

	
	@FXML
	public void testDataSourceConnection(ActionEvent event){
		
		ConnectionSetting connectionSetting =new ConnectionSetting();
		connectionSetting.setConnectionProfile(connectionName.getText());
		DatabaseType dbType =this.dbType.getSelectionModel().getSelectedItem();
		dbType.setJdbcURL(this.jdbcURL.getText());
		connectionSetting.setDatabaseType(dbType);
		connectionSetting.setUserName(this.dbUser.getText());
		connectionSetting.setPassword(this.dbPass.getText());
	    if(SapienDataLoadHelper.testConnection(connectionSetting)){
		this.connectionStatus.setText("Test Connection Succeded");
	    this.connectionStatus.setDisable(false);
	    this.browse.setDisable(false);
		this.upload.setDisable(false);
	    }
	else{
		this.connectionStatus.setText("Test Connection Failed");
	    this.connectionStatus.setDisable(false);
		this.browse.setDisable(true);
		this.upload.setDisable(true);
	}
	
	
	}
	
	@FXML
	public void selectDBType(ActionEvent event)
	{
		 this.jdbcURL.setText(dbType.getSelectionModel().getSelectedItem().getJdbcURL());
	}
	
	@FXML
	public void loadRecentConnections(ActionEvent event)
	{
		ConnectionSetting connectionSetting;
		connectionSetting=this.dbConnectionProfile.getSelectionModel().getSelectedItem();
		//this.connectionName.setText(connectionSetting.getConnectionProfile());
	    this.dbType.getSelectionModel().select(connectionSetting.getDatabaseType());
		this.jdbcURL.setText(connectionSetting.getDatabaseType().getJdbcURL());
		this.dbUser.setText(connectionSetting.getUserName());
		this.dbPass.setText(connectionSetting.getPassword());
		
	}
	
	@FXML
	public void uploadData(ActionEvent event){
		System.out.println("Upload Event Received");
		SapienDataLoader sapienDataLoader = new SapienDataLoader();
		File excelFile = new File(filePath.getText());
		String message=null;
		
		if(null!=excelFile)
			try {
				message=sapienDataLoader.dumpSapientDataStore(excelFile);
				messageBox.setText(message);
			} catch(SapienDataLoaderConfigException sapienDataLoaderConfigException){
				System.out.println(sapienDataLoaderConfigException.getMessage());
				messageBox.setText(sapienDataLoaderConfigException.getMessage());
				
	}catch (SapienDataLoaderException e) {
				e.printStackTrace();
				messageBox.setText(e.getMessage());
			}
		
		
	
	}
	
	@FXML
	public void browseFile(ActionEvent event) throws IOException{
		System.out.println(" browse button event received");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Upload");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Excel","*.xls","*.xlsx"));
		File excelFile= fileChooser.showOpenDialog(stage);
		if(null!=excelFile){
		this.filePath.setText(excelFile.getCanonicalPath());
		this.upload.setDisable(false);
		}
		

	
	}
	
	@FXML
	public void close(ActionEvent event){
	
		
		System.out.println(" close button event received");
		System.exit(0);
	
	}
	
	

}
