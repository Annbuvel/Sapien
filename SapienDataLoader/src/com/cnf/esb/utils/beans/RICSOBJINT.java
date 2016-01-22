package com.cnf.esb.utils.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
@IdClass(RICSOBJINT_PK.class)
public class RICSOBJINT {
	

	@Id
	private long cnt_intr_seq_no;
	@Id
	private long cnt_obj_seq_no;
	
	private long policy_no;
	@Transient
	private String ext_contract_ref;
	@Transient
	private String ext_section_ref;
	@Transient
	private boolean flag;
	private String cust_object_type;
	private String cust_object_code;
	private String obj_val_seq_no;
	private String content;

	
	
	
	public RICSOBJINT()
	{
		
	}
	
	public String getExt_contract_ref() {
		return ext_contract_ref;
	}



	public void setExt_contract_ref(String ext_contract_ref) {
		this.ext_contract_ref = ext_contract_ref;
	}



	public String getExt_section_ref() {
		return ext_section_ref;
	}



	public void setExt_section_ref(String ext_section_ref) {
		this.ext_section_ref = ext_section_ref;
	}



	public long getCnt_obj_seq_no() {
		return cnt_obj_seq_no;
	}



	public void setCnt_obj_seq_no(long cnt_obj_seq_no) {
		this.cnt_obj_seq_no = cnt_obj_seq_no;
	}



	public String getObj_val_seq_no() {
		return obj_val_seq_no;
	}



	public void setObj_val_seq_no(String obj_val_seq_no) {
		this.obj_val_seq_no = obj_val_seq_no;
	}
	

	
	public long getPolicy_no() {
		return policy_no;
	}
	public void setPolicy_no(long policy_no) {
		this.policy_no = policy_no;
	}
	
	public long getCnt_intr_seq_no() {
		return cnt_intr_seq_no;
	}
	public void setCnt_intr_seq_no(long cnt_intr_seq_no) {
		this.cnt_intr_seq_no = cnt_intr_seq_no;
	}

	public String getCust_object_type() {
		return cust_object_type;
	}
	public void setCust_object_type(String cust_object_type) {
		this.cust_object_type = cust_object_type;
	}
	public String getCust_object_code() {
		return cust_object_code;
	}
	public void setCust_object_code(String cust_object_code) {
		this.cust_object_code = cust_object_code;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFalg(boolean flag) {
		this.flag = flag;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer strValue = new StringBuffer();
		strValue.append(this.cnt_intr_seq_no);
		strValue.append("\n");
		strValue.append(this.cnt_obj_seq_no);
		strValue.append("\n");
		strValue.append(this.policy_no);
		
		return strValue.toString();
	}
	
	
	
	
}


