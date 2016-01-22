package com.cnf.esb.utils.beans;

import java.io.Serializable;

public class RICSOBJINT_PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4956660147331280669L;
	
	
	private long cnt_intr_seq_no;
	private long cnt_obj_seq_no;
	public long getCnt_intr_seq_no() {
		return cnt_intr_seq_no;
	}
	public void setCnt_intr_seq_no(long cnt_intr_seq_no) {
		this.cnt_intr_seq_no = cnt_intr_seq_no;
	}
	public long getCnt_obj_seq_no() {
		return cnt_obj_seq_no;
	}
	public void setCnt_obj_seq_no(long cnt_obj_seq_no) {
		this.cnt_obj_seq_no = cnt_obj_seq_no;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int) (this.cnt_intr_seq_no+this.cnt_obj_seq_no);
	}
	@Override
	public boolean equals(Object obj) {
       boolean flag = false ;  
		
		if (obj == this) flag=true;
	        if (!(obj instanceof RICSOBJINT_PK)) return false;
	        if (obj != null) {
	        	RICSOBJINT_PK pk = (RICSOBJINT_PK) obj;
	        flag= pk.getCnt_intr_seq_no() == this.cnt_intr_seq_no && pk.getCnt_obj_seq_no()==this.getCnt_obj_seq_no();
	        } 
	        System.out.println(flag==true ? "objects are equal" : "Not Equal");
	        return flag;
	}
	


	
	

}
