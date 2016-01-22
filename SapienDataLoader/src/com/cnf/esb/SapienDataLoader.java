package com.cnf.esb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import com.cnf.esb.ui.beans.ConnectionSetting;
import com.cnf.esb.ui.beans.DatabaseType;
import com.cnf.esb.utils.SapienDataLoadHelper;
import com.cnf.esb.utils.beans.RIATCHCINT;
import com.cnf.esb.utils.beans.RICNOTFINT;
import com.cnf.esb.utils.beans.RICSOBJINT;
import com.cnf.esb.utils.beans.RIREINSINT;
import com.cnf.esb.utils.beans.RICNTRINT;
import com.cnf.exceptions.SapienDataLoaderConfigException;
import com.cnf.exceptions.SapienDataLoaderDataException;
import com.cnf.exceptions.SapienDataLoaderException;

public class SapienDataLoader {

	private Map<String, List<?>> sheetMap;
	private InputStream sapienDataMappingFile;
	private StringBuffer errors;

	public SapienDataLoader() {
		init();
	}

	public void init() {
		sapienDataMappingFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("SapienDataMapper.xml");
		errors = new StringBuffer();
		sheetMap = new HashMap<String, List<?>>();

	}

	public String dumpSapientDataStore(File xlsFile) throws SapienDataLoaderException {

		try {
			parseExcelFileToBeans(xlsFile);
			validateAndSetDataObjects();
			SapienDataLoadHelper.getInstance().loadSapienStagingTables(sheetMap);

			/*if (!validateAndSetDataObjects()) {
				// SapienDataLoadHelper.getInstance().loadSapienStagingTables(sheetMap);
				errors.append("No of Rows inserted in ricntrint table =" + sheetMap.get("ricntrint").size());
				errors.append("No of Rows inserted in RIREINSINT table =" + sheetMap.get("RIREINSINT").size());
				errors.append("No of Rows inserted in RICNOTFINT table =" + sheetMap.get("RICNOTFINT").size());
				errors.append("No of Rows inserted in RIATCHCINT table =" + sheetMap.get("RIATCHCINT").size());
				errors.append("No of Rows inserted in RICSOBJINT table =" + sheetMap.get("RICSOBJINT").size());
			} else {

				throw new SapienDataLoaderDataException(
						"The Following Policy Numbers not Found in the Sheet \n \n" + errors.toString());
			}
*/
		} catch (SapienDataLoaderDataException sapienDataLoaderDataException) {
			throw sapienDataLoaderDataException;
		}

		return errors.toString();

	}

	private void parseExcelFileToBeans(File xlsFile) throws SapienDataLoaderException {

		// Declare Variables
		XLSReader xlsReader = null;
		InputStream inputStream = null;
		List<RICNTRINT> ricntrints = null;
		List<RIREINSINT> rireinsints = null;
		List<RICNOTFINT> ricnotfints = null;
		List<RIATCHCINT> riatchcints = null;
		List<RICSOBJINT> ricsobjints = null;

		// Initialize Variables
		ricntrints = new ArrayList<RICNTRINT>();
		rireinsints = new ArrayList<RIREINSINT>();
		ricnotfints = new ArrayList<RICNOTFINT>();
		riatchcints = new ArrayList<RIATCHCINT>();
		ricsobjints = new ArrayList<RICSOBJINT>();

		sheetMap.put("RICNTRINT", ricntrints);
		sheetMap.put("RIREINSINT", rireinsints);
		sheetMap.put("RICNOTFINT", ricnotfints);
		sheetMap.put("RIATCHCINT", riatchcints);
		sheetMap.put("RICSOBJINT", ricsobjints);

		// Parse Excel Sheet into Java beans using JXLS API

		// Load the XML Mapping file contains the Field Mappings
		try {
			 //ReaderConfig.getInstance().setSkipErrors( true );
			xlsReader = ReaderBuilder.buildFromXML(sapienDataMappingFile);

		} catch (FileNotFoundException e) {
			throw new SapienDataLoaderConfigException(
					"Field mapping File : SapienDataMapper.xml" + "not Found /n /n" + e.getMessage());

		} catch (IOException e) {
			throw new SapienDataLoaderConfigException(
					"Problem reading Mapping File :SapienDataMapper.xml"  + e.getMessage());

		} catch (SAXException e) {
			throw new SapienDataLoaderConfigException(
					"Error Parsing the Mapping File :SapienDataMapper.xml" + e.getMessage());

		} catch (Exception e) {

			throw new SapienDataLoaderException(e.getStackTrace().toString());

		}

		try {
			inputStream = new BufferedInputStream(new FileInputStream(xlsFile));
			xlsReader.read(inputStream, sheetMap);
		} catch (FileNotFoundException e) {
			throw new SapienDataLoaderConfigException(
					"Field mapping File :  SapienDataMapper.xml  not Found /n /n" + e.getMessage());
		} catch (InvalidFormatException e) {
			throw new SapienDataLoaderDataException(
					"Invalid Cell Format : " + xlsFile.getName() + "/n /n" + e.getMessage());
		} catch (IOException e) {
			throw new SapienDataLoaderConfigException(
					"Error Parsing the Mapping File :SapienDataMapper.xml  /n"+ e.getMessage());
		}

		finally {
			try {
				if (null != inputStream)
					inputStream.close();
			} catch (IOException e) {
				throw new SapienDataLoaderException(e.getStackTrace().toString());
			}
		}

	}

	@SuppressWarnings("unchecked")
	private boolean validateAndSetDataObjects() throws SapienDataLoaderDataException {

		List<RICNTRINT> ricntrints = null;
		List<RIREINSINT> rireinsints = null;
		List<RICNOTFINT> ricnotfints = null;
		List<RIATCHCINT> riatchcints = null;
		List<RICSOBJINT> ricsobjints = null;

		ricntrints = (List<RICNTRINT>) sheetMap.get("RICNTRINT");
		rireinsints = (List<RIREINSINT>) sheetMap.get("RIREINSINT");
		riatchcints = (List<RIATCHCINT>) sheetMap.get("RIATCHCINT");
		ricsobjints = (List<RICSOBJINT>) sheetMap.get("RICSOBJINT");
		ricnotfints = (List<RICNOTFINT>) sheetMap.get("RICNOTFINT");

		boolean flag = false;
		boolean parentFlag = false;
		if (ricntrints.isEmpty() || null == ricntrints) {
			throw new SapienDataLoaderDataException("Excel File does not have data for ricntrint");
		}

		if (rireinsints.isEmpty() || null == rireinsints) {
			throw new SapienDataLoaderDataException("Excel File does not have data for RIREINSINT");
		}

		if (riatchcints.isEmpty() || null == riatchcints) {
			throw new SapienDataLoaderDataException("Excel File does not have data for RIATCHCINT");
		}
		if (ricsobjints.isEmpty() || null == ricsobjints) {
			throw new SapienDataLoaderDataException("Excel File does not have data for RICSOBJINT");
		}

		if (ricnotfints.isEmpty() || null == ricnotfints) {
			throw new SapienDataLoaderDataException("Excel File does not have data for RICNOTFINT");
		}

		// Iterate on ricntrint Sheet for Every Record
		for (RICNTRINT ricntrint : ricntrints) {

			// Iterate on RIREINSINT Sheet for Every Record to find the Policy
			// Number matching with ricntrint
			flag = false;
			int counter =0;
			for (RIREINSINT rireinsint : rireinsints) {
				if (rireinsint.getPolicy_no() == ricntrint.getPolicy_no() && rireinsint.getExt_contract_ref().equals(ricntrint.getExt_contract_ref()) && rireinsint.getExt_section_ref().equals(ricntrint.getEXT_SECTION_REF()) ) {
					rireinsint.setCnt_intr_seq_no(ricntrint.getCNT_INTR_SEQ_NO());
					rireinsint.setRi_seq_no(counter++);
					rireinsint.setFalg(true);
					flag = true;

				}
			}

			if (!flag) {
				errors.append("Policy Number :  " + ricntrint.getPolicy_no() + " Not found in RIREINSINT Sheet");
				parentFlag = true;

			}
			flag = false;
			// Iterate on RIATCHCINT Sheet for Every Record to find the Policy
			// Number matching with ricntrint
			for (RIATCHCINT riatchcint : riatchcints) {
				if (riatchcint.getPolicy_no() == ricntrint.getPolicy_no() ) {
					riatchcint.setCnt_intr_seq_no(ricntrint.getCNT_INTR_SEQ_NO());
					flag = true;
					riatchcint.setFalg(true);

				}
			}

			if (!flag) {
				errors.append("Policy Number :  " + ricntrint.getPolicy_no() + " Not found in RIREINSINT Sheet");
				parentFlag = true;

			}

			// Iterate on RICSOBJINT Sheet for Every Record to find the Policy
			// Number matching with ricntrint
			flag = false;
			counter=0;
			for (RICSOBJINT ricsobjint : ricsobjints) {
				if (ricsobjint.getPolicy_no() == ricntrint.getPolicy_no() && ricsobjint.getExt_contract_ref().equals(ricntrint.getExt_contract_ref()) && ricsobjint.getExt_section_ref().equals(ricntrint.getEXT_SECTION_REF())) {
					ricsobjint.setCnt_intr_seq_no(ricntrint.getCNT_INTR_SEQ_NO());
					ricsobjint.setCnt_obj_seq_no(counter++);
					ricsobjint.setFalg(true);
					flag = true;

				}
			}

			if (!flag) {
				errors.append("Policy Number :  " + ricntrint.getPolicy_no() + " Not found in RIREINSINT Sheet");
				parentFlag = true;

			}

			// Iterate on RICNOTFINT Sheet for Every Record to find the Policy
			// Number matching with ricntrint
			flag = false;
			for (RICNOTFINT ricnotfint : ricnotfints) {
				if (ricnotfint.getPolicy_no() == ricntrint.getPolicy_no() && ricnotfint.getExt_contract_ref().equals(ricntrint.getExt_contract_ref()) && ricnotfint.getExt_section_ref().equals(ricntrint.getEXT_SECTION_REF())) {
					ricnotfint.setCnt_intr_seq_no(ricntrint.getCNT_INTR_SEQ_NO());
					ricnotfint.setFalg(true);
					flag = true;

				}
			}

			if (!flag) {
				errors.append("Policy Number :  " + ricntrint.getPolicy_no() + " Not found in RIREINSINT Sheet");
				parentFlag = true;

			}

		}

		return parentFlag;
	}

	public static void main(String args[]) throws SapienDataLoaderDataException {

		try {
			ConnectionSetting connectionSetting = new ConnectionSetting();
			DatabaseType type = new DatabaseType();
			type.setJdbcURL("jdbc:hsqldb:file:C:/Annbuvel/Db/Test");
			type.setJdbcDriver("org.hsqldb.jdbcDriver");
			connectionSetting.setDatabaseType(type);
			connectionSetting.setUserName("SA");
			connectionSetting.setPassword("");
		//	SapienDataLoadHelper.initialize(connectionSetting);
			
			System.out.println(new SapienDataLoader().dumpSapientDataStore(new File("SapienData-Modified.xlsx")));
		} catch (SapienDataLoaderDataException sapienDataLoaderDataException) {
			System.out.println(sapienDataLoaderDataException.getMessage());
		} catch (SapienDataLoaderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
