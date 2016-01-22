package com.cnf.esb.ui.beans;

public class DatabaseType {

		private String dbType;
		private String jdbcURL;
		private String jdbcDriver;
		public String getJdbcDriver() {
			return jdbcDriver;
		}
		public void setJdbcDriver(String jdbcDriver) {
			this.jdbcDriver = jdbcDriver;
		}
		public String getJdbcURL() {
			return jdbcURL;
		}
		public void setJdbcURL(String jdbcURL) {
			this.jdbcURL = jdbcURL;
		}
		public String getDbType() {
			return dbType;
		}
		public void setDbType(String dbType) {
			this.dbType = dbType;
		}
		
		
		@Override
		public String toString()
		{
			return this.dbType;
		}

}
