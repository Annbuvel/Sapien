package com.cnf.esb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cnf.esb.ui.beans.ConnectionSetting;
import com.cnf.esb.utils.beans.RIATCHCINT;
import com.cnf.esb.utils.beans.RICNOTFINT;
import com.cnf.esb.utils.beans.RICSOBJINT;
import com.cnf.esb.utils.beans.RIREINSINT;
import com.cnf.esb.utils.beans.RICNTRINT;

public class SapienDataLoadHelper {

	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;
	private static SapienDataLoadHelper sapienDataLoadHelper;

	public static SapienDataLoadHelper getInstance() {
		if (null == sapienDataLoadHelper)
			SapienDataLoadHelper.initialize();
		System.out.println("Sapine Loader Not initialized");

		return sapienDataLoadHelper;
	}

	private SapienDataLoadHelper() {

	}

	public static void initialize() {
		if (null == sapienDataLoadHelper) {
			sapienDataLoadHelper = new SapienDataLoadHelper();
			sapienDataLoadHelper.emfactory = Persistence.createEntityManagerFactory("SapienDataLoader");
			sapienDataLoadHelper.entitymanager = sapienDataLoadHelper.emfactory.createEntityManager();
		}
	}

	public static void initialize(ConnectionSetting connectionSetting) {

		sapienDataLoadHelper = new SapienDataLoadHelper();
		Map<String, String> persistenceMap = new HashMap<String, String>();
		persistenceMap.put("javax.persistence.jdbc.url", connectionSetting.getDatabaseType().getJdbcURL());
		persistenceMap.put("javax.persistence.jdbc.user", connectionSetting.getUserName());
		persistenceMap.put("javax.persistence.jdbc.password", connectionSetting.getPassword());
		persistenceMap.put("javax.persistence.jdbc.driver", connectionSetting.getDatabaseType().getJdbcDriver());
		sapienDataLoadHelper.emfactory = Persistence.createEntityManagerFactory("SapienDataLoader", persistenceMap);
		sapienDataLoadHelper.entitymanager = sapienDataLoadHelper.emfactory.createEntityManager();

	}

	private SapienDataLoadHelper(ConnectionSetting connectionSetting) {
		Map<String, String> persistenceMap = new HashMap<String, String>();
		persistenceMap.put("javax.persistence.jdbc.url", connectionSetting.getDatabaseType().getJdbcURL());
		persistenceMap.put("javax.persistence.jdbc.user", connectionSetting.getUserName());
		persistenceMap.put("javax.persistence.jdbc.password", connectionSetting.getPassword());
		persistenceMap.put("javax.persistence.jdbc.driver", "org.hsqldb.jdbcDriver");
		emfactory = Persistence.createEntityManagerFactory("SapienDataLoader", persistenceMap);
		entitymanager = emfactory.createEntityManager();

	}

	public static SapienDataLoadHelper getInstance(ConnectionSetting connectionSetting) {

		return sapienDataLoadHelper;
	}

	@SuppressWarnings("unchecked")
	public void loadSapienStagingTables(Map<String, List<?>> excelSheetMap) {
		List<?> sheetData = null;

		sheetData = excelSheetMap.get("RICNTRINT");
		entitymanager.getTransaction().begin();
		System.out.println("Sheet Data Size " + sheetData.size());

		try {
			for (RICNTRINT ricntrint : (List<RICNTRINT>) sheetData) {

				entitymanager.persist(ricntrint);

			}

			sheetData = excelSheetMap.get("RIREINSINT");

			for (RIREINSINT rireinsint : (List<RIREINSINT>) sheetData) {

				if (rireinsint.isFlag())
					entitymanager.persist(rireinsint);

			}

			sheetData = excelSheetMap.get("RICNOTFINT");

			for (RICNOTFINT ricnotfint : (List<RICNOTFINT>) sheetData) {
				if (ricnotfint.isFalg())
					entitymanager.persist(ricnotfint);

			}

			sheetData = excelSheetMap.get("RIATCHCINT");

			for (RIATCHCINT riatchcint : (List<RIATCHCINT>) sheetData) {
				if (riatchcint.isFlag())
					entitymanager.persist(riatchcint);

			}
			System.out.println("Endo of RIATCHCINT");

			sheetData = excelSheetMap.get("RICSOBJINT");

			for (RICSOBJINT ricsobjint : (List<RICSOBJINT>) sheetData) {
				if (ricsobjint.isFlag())
					entitymanager.persist(ricsobjint);

			}
			entitymanager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entitymanager.close();
			emfactory.close();
		}

	}

	public static boolean testConnection(ConnectionSetting connectionSetting) {
		boolean flag = false;
		Connection connection = null;
		try {
			Class.forName(connectionSetting.getDatabaseType().getJdbcDriver());
			System.out.println(connectionSetting.getDatabaseType().getJdbcURL());
			connection = DriverManager.getConnection(connectionSetting.getDatabaseType().getJdbcURL(),
					connectionSetting.getUserName(), connectionSetting.getPassword());
			if (null != connection)
				flag = connection.isValid(10);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
		return flag;
	}

}
