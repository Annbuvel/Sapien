package com.cnf.esb.ui.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cnf.esb.ui.beans.ConnectionSetting;
import com.cnf.esb.ui.beans.DatabaseType;

import net.sourceforge.yamlbeans.YamlException;
import net.sourceforge.yamlbeans.YamlReader;
import net.sourceforge.yamlbeans.YamlWriter;

public class ConnectionSettingsHandler {

	private File prefs;
	private File dbType;

	private ConnectionSettingsHandler() {
		initialize();

	}

	private void initialize() {

		dbType = new File("properties/dbConfig.yaml");
		String location = System.getProperty("user.home");
		File dir = new File(location);
		System.out.println(dir.getAbsolutePath());
		String prefFileName = "sLoader.prefs";
		boolean flag = false;

		for (File file : dir.listFiles()) {
			try {

				if ((prefFileName).equals(file.getName())) {
					flag = true;
					prefs = file;
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (!flag) 
			prefs = new File(location + "//" + prefFileName);
			

	}

	public static ConnectionSettingsHandler getInstance() {
		return new ConnectionSettingsHandler();
	}

	public List<ConnectionSetting> readConnectionSettings() {
		List<ConnectionSetting> connectionSettings = null;
		ConnectionSetting connectionSetting = null;
		YamlReader reader = null;
		connectionSettings = new ArrayList<ConnectionSetting>();
		try {
			reader = new YamlReader(new FileReader(prefs));
			Object obj;
			while ((obj = reader.read()) != null) {
				connectionSetting = (ConnectionSetting) obj;
				connectionSettings.add(connectionSetting);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (YamlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return connectionSettings;

	}

	
	public List<DatabaseType> getDatabaseTypes() {
		List<DatabaseType> databaseTypes = null;
		YamlReader reader = null;
		databaseTypes = new ArrayList<DatabaseType>();
		try {
			reader = new YamlReader(new FileReader(dbType));
			Object obj;
			while((obj=reader.read())!=null){
			databaseTypes.add((DatabaseType)obj);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (YamlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return databaseTypes;

	}
	
	
	
	public void writeConnectionSettings(ConnectionSetting connectionSetting) {
		List<ConnectionSetting> connectionSettings = null;
		YamlWriter writer = null;

		try {
			connectionSettings = readConnectionSettings();
			connectionSettings.add(connectionSetting);
			writer = new YamlWriter(new FileWriter(prefs));
			for (ConnectionSetting setting : connectionSettings)
				writer.write(setting);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (YamlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)

					writer.close();
			} catch (YamlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateConnectionSettings(ConnectionSetting connectionSetting) {

	}

	

}
