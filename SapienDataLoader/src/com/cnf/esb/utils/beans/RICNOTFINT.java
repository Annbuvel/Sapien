package com.cnf.esb.utils.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
@IdClass(RICNOTFINT_ID.class)
public class RICNOTFINT {
	

	   @Id
	   private long cnt_intr_seq_no;
	   @Id
	   private String ntf_seq_num;
	   
	   private long policy_no;
	   @Transient
	   private String ext_contract_ref;
	   @Transient
	   private String ext_section_ref;
	   private String ntf_type;
	   private String ntf_limit_value;
	   private String ntf_limit_pct;
	   private String ntf_due_day_num;
	   private String ntf_ref_date;
	   
	   @Transient
	   private boolean flag;
	   
	   public long getPolicy_no() {
		return policy_no;
	}
	public void setPolicy_no(long policy_no) {
		this.policy_no = policy_no;
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
	public long getCnt_intr_seq_no() {
		return cnt_intr_seq_no;
	}
	public void setCnt_intr_seq_no(long cnt_intr_seq_no) {
		this.cnt_intr_seq_no = cnt_intr_seq_no;
	}
	public String getNtf_seq_num() {
		return ntf_seq_num;
	}
	public void setNtf_seq_num(String ntf_seq_num) {
		this.ntf_seq_num = ntf_seq_num;
	}
	public String getNtf_type() {
		return ntf_type;
	}
	public void setNtf_type(String ntf_type) {
		this.ntf_type = ntf_type;
	}
	public String getNtf_limit_value() {
		return ntf_limit_value;
	}
	public void setNtf_limit_value(String ntf_limit_value) {
		this.ntf_limit_value = ntf_limit_value;
	}
	public String getNtf_limit_pct() {
		return ntf_limit_pct;
	}
	public void setNtf_limit_pct(String ntf_limit_pct) {
		this.ntf_limit_pct = ntf_limit_pct;
	}
	public String getNtf_due_day_num() {
		return ntf_due_day_num;
	}
	public void setNtf_due_day_num(String ntf_due_day_num) {
		this.ntf_due_day_num = ntf_due_day_num;
	}
	public String getNtf_ref_date() {
		return ntf_ref_date;
	}
	public void setNtf_ref_date(String ntf_ref_date) {
		this.ntf_ref_date = ntf_ref_date;
	}
	
	public boolean isFalg() {
		return flag;
	}

	public void setFalg(boolean flag) {
		this.flag = flag;
	}
}


@SuppressWarnings("unused")
class RICNOTFINT_ID
{
	   
	  private long cnt_intr_seq_no;
	   private String ntf_seq_num;
	
}

