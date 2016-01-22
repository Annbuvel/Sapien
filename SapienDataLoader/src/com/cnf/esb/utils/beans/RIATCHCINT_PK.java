package com.cnf.esb.utils.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RIATCHCINT_PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3679849198123511321L;
	
	private long cnt_intr_seq_no;
	private int term_no;
	private String attr_code;
    private int category_val_seq;
    
    public RIATCHCINT_PK()
    {
    	
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
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println((int)this.getCnt_intr_seq_no()+this.getCategory_val_seq()+this.term_no+ (int)(this.cnt_intr_seq_no));
		return (int)this.getCnt_intr_seq_no()+this.getCategory_val_seq()+this.term_no+ (int)(this.cnt_intr_seq_no);
	}
	@Override
	public boolean equals(Object obj) {
		boolean flag = false ;  
		
		if (obj == this) flag=true;
	        if (!(obj instanceof RIATCHCINT_PK)) return false;
	        if (obj != null) {
	        RIATCHCINT_PK pk = (RIATCHCINT_PK) obj;
	        flag= pk.getCnt_intr_seq_no() == this.cnt_intr_seq_no && pk.getAttr_code().equals(this.getAttr_code())&& pk.category_val_seq==this.category_val_seq && pk.term_no==this.term_no;
	        } 
	        System.out.println(flag==true ? "objects are equal" : "Not Equal");
	        return flag;
	}
	

}
