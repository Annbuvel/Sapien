package com.cnf.esb.ui.beans;

public class ConnectionSetting {
	
	private String connectionProfile;
	private String userName;
	private String password;
	private DatabaseType databaseType;
	
	public DatabaseType getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(DatabaseType databaseType) {
		this.databaseType = databaseType;
	}
	public String getConnectionProfile() {
		return connectionProfile;
	}
	public void setConnectionProfile(String connectionProfile) {
		this.connectionProfile = connectionProfile;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getConnectionProfile();
	}
	
	
}

