package com.cnf.esb.utils.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
@IdClass(RIATCHCINT_PK.class)

public class RIATCHCINT {

	@Id
    private long cnt_intr_seq_no;
    @Id
	private int term_no;
	@Id
	private String attr_code;
	@Id
	private int category_val_seq;
	
	@Transient
	private long ext_section_ref;
	
	private long policy_no;
	private String deal;
	private String operation;
	private String value;
	private String split_key_1;
	private String split_key_2;
	private String split_key_3;
	private String split_key_4;
	private String split_key_5;
	@Transient
	boolean flag;
	


	public RIATCHCINT()
	{
		
	}

	public long getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(long policy_no) {
		this.policy_no = policy_no;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}
	public long getExt_section_ref() {
		return ext_section_ref;
	}

	public void setExt_section_ref(long ext_section_ref) {
		this.ext_section_ref = ext_section_ref;
	}


	public long getCnt_intr_seq_no() {
		return cnt_intr_seq_no;
	}

	public void setCnt_intr_seq_no(long cnt_intr_seq_no) {
		this.cnt_intr_seq_no = cnt_intr_seq_no;
	}

	public int getTerm_no() {
		return term_no;
	}

	public void setTerm_no(int term_no) {
		this.term_no = term_no;
	}

	public String getAttr_code() {
		return attr_code;
	}

	public void setAttr_code(String attr_code) {
		this.attr_code = attr_code;
	}

	public int getCategory_val_seq() {
		return category_val_seq;
	}

	public void setCategory_val_seq(int category_val_seq) {
		this.category_val_seq = category_val_seq;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSplit_key_1() {
		return split_key_1;
	}

	public void setSplit_key_1(String split_key_1) {
		this.split_key_1 = split_key_1;
	}

	public String getSplit_key_2() {
		return split_key_2;
	}

	public void setSplit_key_2(String split_key_2) {
		this.split_key_2 = split_key_2;
	}

	public String getSplit_key_3() {
		return split_key_3;
	}

	public void setSplit_key_3(String split_key_3) {
		this.split_key_3 = split_key_3;
	}

	public String getSplit_key_4() {
		return split_key_4;
	}

	public void setSplit_key_4(String split_key_4) {
		this.split_key_4 = split_key_4;
	}

	public String getSplit_key_5() {
		return split_key_5;
	}

	public void setSplit_key_5(String split_key_5) {
		this.split_key_5 = split_key_5;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFalg(boolean flag) {
		this.flag = flag;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	
	

}



