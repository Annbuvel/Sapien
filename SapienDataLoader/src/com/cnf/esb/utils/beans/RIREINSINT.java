package com.cnf.esb.utils.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cnf.esb.utils.RandomNumberFactory;
import com.cnf.esb.utils.RandomNumberGen;

@Entity
@Table
@IdClass(RIREINSINT_ID.class)
public class RIREINSINT {

	@Id
	private long cnt_intr_seq_no;
	@Id
	private long ri_seq_no;
	
	private long policy_no;
	@Transient
	private String ext_contract_ref;
	@Transient
	private String ext_section_ref;
	@Transient
	private boolean flag;
	
	private String broker_cont_ref;
	private String ri_contract_ref;
	private String reinsur_id;
	private String ri_external_ref;
	private String broker_id;
	private String br_external_ref;
	private String accounting_throu;
	private String specified_share;
	private String net_prem_pct;
	private String gross_prem_pct;
	private String inwds_comm_pct;
	private String version_number;
	private static RandomNumberGen controlSeq= RandomNumberFactory.getInstance().registerAndGetSequence("ControlSeq");
	
	public RIREINSINT()
	{
		this.setRi_seq_no(controlSeq.getRandomNumber());	
	}
	
	public String getExt_contract_ref() {
		return ext_contract_ref;
	}



	public void setExt_contract_ref(String ext_contract_ref) {
		this.ext_contract_ref = ext_contract_ref;
	}
	
	
	public long getPolicy_no() {
		return policy_no;
	}
	public void setPolicy_no(long policy_no) {
		this.policy_no = policy_no;
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
	public long getRi_seq_no() {
		return ri_seq_no;
	}
	public void setRi_seq_no(long ri_seq_no) {
		this.ri_seq_no = ri_seq_no;
	}
	public String getBroker_cont_ref() {
		return broker_cont_ref;
	}
	public void setBroker_cont_ref(String broker_cont_ref) {
		this.broker_cont_ref = broker_cont_ref;
	}
	public String getRi_contract_ref() {
		return ri_contract_ref;
	}
	public void setRi_contract_ref(String ri_contract_ref) {
		this.ri_contract_ref = ri_contract_ref;
	}
	public String getReinsur_id() {
		return reinsur_id;
	}
	public void setReinsur_id(String reinsur_id) {
		this.reinsur_id = reinsur_id;
	}
	public String getRi_external_ref() {
		return ri_external_ref;
	}
	public void setRi_external_ref(String ri_external_ref) {
		this.ri_external_ref = ri_external_ref;
	}
	public String getBroker_id() {
		return broker_id;
	}
	public void setBroker_id(String broker_id) {
		this.broker_id = broker_id;
	}
	public String getBr_external_ref() {
		return br_external_ref;
	}
	public void setBr_external_ref(String br_external_ref) {
		this.br_external_ref = br_external_ref;
	}
	public String getAccounting_throu() {
		return accounting_throu;
	}
	public void setAccounting_throu(String accounting_throu) {
		this.accounting_throu = accounting_throu;
	}
	public String getSpecified_share() {
		return specified_share;
	}
	public void setSpecified_share(String specified_share) {
		this.specified_share = specified_share;
	}
	public String getNet_prem_pct() {
		return net_prem_pct;
	}
	public void setNet_prem_pct(String net_prem_pct) {
		this.net_prem_pct = net_prem_pct;
	}
	public String getGross_prem_pct() {
		return gross_prem_pct;
	}
	public void setGross_prem_pct(String gross_prem_pct) {
		this.gross_prem_pct = gross_prem_pct;
	}
	public String getInwds_comm_pct() {
		return inwds_comm_pct;
	}
	public void setInwds_comm_pct(String inwds_comm_pct) {
		this.inwds_comm_pct = inwds_comm_pct;
	}
	public String getVersion_number() {
		return version_number;
	}
	public void setVersion_number(String version_number) {
		this.version_number = version_number;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFalg(boolean flag) {
		this.flag = flag;
	}


}

@SuppressWarnings("unused")
class RIREINSINT_ID
{
	private long cnt_intr_seq_no;
	private long ri_seq_no;
	
	
}
