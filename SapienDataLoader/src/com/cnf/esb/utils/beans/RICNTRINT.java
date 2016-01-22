package com.cnf.esb.utils.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cnf.esb.utils.RandomNumberFactory;
import com.cnf.esb.utils.RandomNumberGen;

@Entity
@Table
public class RICNTRINT implements Serializable {


	private static final long serialVersionUID = -5172920178033260200L;
	
	
	@Id
	private long cnt_intr_seq_no;

	private String record_ind;
	private String ext_contract_ref;
	private String ext_section_ref;
	@Temporal(TemporalType.DATE)
	private Date cont_start_date;
	@Temporal(TemporalType.DATE)
	private Date cont_end_date;
	private String contract_source;
	private String contract_name;
	private String contract_sl_name;
	private String contract_type;
	private String cont_nature;
	private String xol_type;
	private String contract_status;
	private String document_rfrnce;
	private String contract_ref_no;
	private String inuring;
	private String ceding_reference;
	private String business_deprtmt;
	private long section_ref_no;
	private String section_name;
	private String section_sl_name;
	private String insured_name;
	private String section_type;
	private String section_type_no;
	private String prem_acct_basis;
	private String claim_acct_basis;
	private String accumulate_basis;
	private String layer_no;
	private String pliability_from;
	private String pliability_to;
	private String xol_protection;
	private String facultativ_share;
	private String deductible_amnt;
	private String layer_amount;
	private String manager_company;
	private String sharing_company1;
	private String sharing_company2;
	private String sharing_company3;
	private String assumed_company;
	private String company_code;
	private long policy_no;
	private String object_id;
	private String endorsement_no;
	private String calculation_type;
	private String amount;
	private String percentage;
	private String model;
	private String adj_percentage;
	private String adj_model;
	private String adj_minimum;
	private String adj_maximum;
	private String net_prem_pct;
	private String gross_prem_pct;
	private String inwds_comm_pct;
	private String reinst_from1;
	private String reinst_to1;
	private String reinst_type1;
	private String reinst_prm_pct1;
	private String reinst_flat_val1;
	private String reinst_from2;
	private String reinst_to2;
	private String reinst_type2;
	private String reinst_prm_pct2;
	private String reinst_flat_val2;
	private String reinst_from3;
	private String reinst_to3;
	private String reinst_type3;
	private String reinst_prm_pct3;
	private String reinst_flat_val3;
	private String aggr_period;
	private String aggr_basis;
	private String aggr_limit_val;
	private String aggr_stability;
	private String stability_type;
	private String stab_type_basis;
	private String rate_type;
	private String base_index_date;
	private String condition_type;
	private String condition_val;
	private String base_index_rate;
	private String subsystem_id;
	private String ignore_convrsion;
	private String remttance_method;
	private String claims_excluded;
	private String sunset_date;
	private String claim_model;
	private String frequency_type;
	private String claim_aggr_limit;
	private String billing_doc_type;
	private String contract_usage;
	private String interface_type;
	private String cont_amnt_currcy;
	private RandomNumberGen controlSeq = RandomNumberFactory.getInstance().registerAndGetSequence("ControlSeq");


	public RICNTRINT() {
		this.setCnt_intr_seq_no(controlSeq.getRandomNumber());
	
	}

	public long getCNT_INTR_SEQ_NO() {
		return cnt_intr_seq_no;
	}

	public void setCnt_intr_seq_no(long cnt_Intr_seq_no) {
		cnt_intr_seq_no = cnt_Intr_seq_no;
	}

	public String getRecord_ind() {
		return record_ind;
	}

	public void setRecord_ind(String record_ind) {
		this.record_ind = record_ind;
	}

	public String getExt_contract_ref() {
		return ext_contract_ref;
	}

	public void setExt_contract_ref(String ext_contract_ref) {
		this.ext_contract_ref = ext_contract_ref;
	}

	public String getEXT_SECTION_REF() {
		return ext_section_ref;
	}

	public void setExt_section_ref(String eXT_SECTION_REF) {
		ext_section_ref = eXT_SECTION_REF;
	}

	public Date getCont_start_date() {
		return cont_start_date;
	}

	public void setCont_start_date(Date cont_start_date) {
		this.cont_start_date = cont_start_date;
	}

	public Date getCont_end_date() {
		return cont_end_date;
	}

	public void setCont_end_date(Date cont_end_date) {
		this.cont_end_date = cont_end_date;
	}

	public String getContract_source() {
		return contract_source;
	}

	public void setContract_source(String contract_source) {
		this.contract_source = contract_source;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getContract_sl_name() {
		return contract_sl_name;
	}

	public void setContract_sl_name(String contract_sl_name) {
		this.contract_sl_name = contract_sl_name;
	}

	public String getContract_type() {
		return contract_type;
	}

	public void setContract_type(String contract_type) {
		this.contract_type = contract_type;
	}

	public String getCont_nature() {
		return cont_nature;
	}

	public void setCont_nature(String cont_nature) {
		this.cont_nature = cont_nature;
	}

	public String getXol_type() {
		return xol_type;
	}

	public void setXol_type(String xol_type) {
		this.xol_type = xol_type;
	}

	public String getContract_status() {
		return contract_status;
	}

	public void setContract_status(String contract_status) {
		this.contract_status = contract_status;
	}

	public String getDocument_rfrnce() {
		return document_rfrnce;
	}

	public void setDocument_rfrnce(String document_rfrnce) {
		this.document_rfrnce = document_rfrnce;
	}

	public String getContract_ref_no() {
		return contract_ref_no;
	}

	public void setContract_ref_no(String contract_ref_no) {
		this.contract_ref_no = contract_ref_no;
	}

	public String getInuring() {
		return inuring;
	}

	public void setInuring(String inuring) {
		this.inuring = inuring;
	}

	public String getCeding_reference() {
		return ceding_reference;
	}

	public void setCeding_reference(String ceding_reference) {
		this.ceding_reference = ceding_reference;
	}

	public String getBusiness_deprtmt() {
		return business_deprtmt;
	}

	public void setBusiness_deprtmt(String business_deprtmt) {
		this.business_deprtmt = business_deprtmt;
	}

	public long getSection_ref_no() {
		return section_ref_no;
	}

	public void setSection_ref_no(long sECTION_REF_NO) {
		section_ref_no = sECTION_REF_NO;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public String getSection_sl_name() {
		return section_sl_name;
	}

	public void setSection_sl_name(String section_sl_name) {
		this.section_sl_name = section_sl_name;
	}

	public String getInsured_name() {
		return insured_name;
	}

	public void setInsured_name(String insured_name) {
		this.insured_name = insured_name;
	}

	public String getSection_type() {
		return section_type;
	}

	public void setSection_type(String section_type) {
		this.section_type = section_type;
	}

	public String getSection_type_no() {
		return section_type_no;
	}

	public void setSection_type_no(String section_type_no) {
		this.section_type_no = section_type_no;
	}

	public String getPrem_acct_basis() {
		return prem_acct_basis;
	}

	public void setPrem_acct_basis(String prem_acct_basis) {
		this.prem_acct_basis = prem_acct_basis;
	}

	public String getClaim_acct_basis() {
		return claim_acct_basis;
	}

	public void setClaim_acct_basis(String claim_acct_basis) {
		this.claim_acct_basis = claim_acct_basis;
	}

	public String getAccumulate_basis() {
		return accumulate_basis;
	}

	public void setAccumulate_basis(String accumulate_basis) {
		this.accumulate_basis = accumulate_basis;
	}

	public String getLayer_no() {
		return layer_no;
	}

	public void setLayer_no(String layer_no) {
		this.layer_no = layer_no;
	}

	public String getPliability_from() {
		return pliability_from;
	}

	public void setPliability_from(String pliability_from) {
		this.pliability_from = pliability_from;
	}

	public String getPliability_to() {
		return pliability_to;
	}

	public void setPliability_to(String pLIABILITY_TO) {
		pliability_to = pLIABILITY_TO;
	}

	public String getXol_protection() {
		return xol_protection;
	}

	public void setXol_protection(String xol_protection) {
		this.xol_protection = xol_protection;
	}

	public String getFacultativ_share() {
		return facultativ_share;
	}

	public void setFacultativ_share(String facultativ_share) {
		this.facultativ_share = facultativ_share;
	}

	public String getDeductible_amnt() {
		return deductible_amnt;
	}

	public void setDeductible_amnt(String deductible_amnt) {
		this.deductible_amnt = deductible_amnt;
	}

	public String getLayer_amount() {
		return layer_amount;
	}

	public void setLayer_amount(String layer_amount) {
		this.layer_amount = layer_amount;
	}

	public String getManager_company() {
		return manager_company;
	}

	public void setManager_company(String manager_company) {
		this.manager_company = manager_company;
	}

	public String getSharing_company1() {
		return sharing_company1;
	}

	public void setSharing_company1(String sharing_company1) {
		this.sharing_company1 = sharing_company1;
	}

	public String getSharing_company2() {
		return sharing_company2;
	}

	public void setSharing_company2(String sHARING_COMPANY2) {
		sharing_company2 = sHARING_COMPANY2;
	}

	public String getSharing_company3() {
		return sharing_company3;
	}

	public void setSharing_company3(String sharing_company3) {
		this.sharing_company3 = sharing_company3;
	}

	public String getAssumed_company() {
		return assumed_company;
	}

	public void setAssumed_company(String assumed_company) {
		this.assumed_company = assumed_company;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	public long getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(long policy_no) {
		this.policy_no = policy_no;
	}

	public String getObject_id() {
		return object_id;
	}

	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}

	public String getEndorsement_no() {
		return endorsement_no;
	}

	public void setEndorsement_no(String eNDORSEMENT_NO) {
		endorsement_no = eNDORSEMENT_NO;
	}

	public String getCalculation_type() {
		return calculation_type;
	}

	public void setCalculation_type(String calculation_type) {
		this.calculation_type = calculation_type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAdj_percentage() {
		return adj_percentage;
	}

	public void setAdj_percentage(String adj_percentage) {
		this.adj_percentage = adj_percentage;
	}

	public String getAdj_model() {
		return adj_model;
	}

	public void setAdj_model(String adj_model) {
		this.adj_model = adj_model;
	}

	public String getAdj_minimum() {
		return adj_minimum;
	}

	public void setAdj_minimum(String adj_minimum) {
		this.adj_minimum = adj_minimum;
	}

	public String getAdj_maximum() {
		return adj_maximum;
	}

	public void setAdj_maximum(String adj_maximum) {
		this.adj_maximum = adj_maximum;
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

	public String getReinst_from1() {
		return reinst_from1;
	}

	public void setReinst_from1(String reinst_from1) {
		this.reinst_from1 = reinst_from1;
	}

	public String getReinst_to1() {
		return reinst_to1;
	}

	public void setReinst_to1(String reinst_to1) {
		this.reinst_to1 = reinst_to1;
	}

	public String getReinst_type1() {
		return reinst_type1;
	}

	public void setReinst_type1(String reinst_type1) {
		this.reinst_type1 = reinst_type1;
	}

	public String getReinst_prm_pct1() {
		return reinst_prm_pct1;
	}

	public void setReinst_prm_pct1(String reinst_prm_pct1) {
		this.reinst_prm_pct1 = reinst_prm_pct1;
	}

	public String getReinst_flat_val1() {
		return reinst_flat_val1;
	}

	public void setReinst_flat_val1(String reinst_flat_val1) {
		this.reinst_flat_val1 = reinst_flat_val1;
	}

	public String getReinst_from2() {
		return reinst_from2;
	}

	public void setReinst_from2(String reinst_from2) {
		this.reinst_from2 = reinst_from2;
	}

	public String getReinst_to2() {
		return reinst_to2;
	}

	public void setReinst_to2(String reinst_to2) {
		this.reinst_to2 = reinst_to2;
	}

	public String getReinst_type2() {
		return reinst_type2;
	}

	public void setReinst_type2(String reinst_type2) {
		this.reinst_type2 = reinst_type2;
	}

	public String getReinst_prm_pct2() {
		return reinst_prm_pct2;
	}

	public void setReinst_prm_pct2(String reinst_prm_pct2) {
		this.reinst_prm_pct2 = reinst_prm_pct2;
	}

	public String getReinst_flat_val2() {
		return reinst_flat_val2;
	}

	public void setReinst_flat_val2(String reinst_flat_val2) {
		this.reinst_flat_val2 = reinst_flat_val2;
	}

	public String getReinst_from3() {
		return reinst_from3;
	}

	public void setReinst_from3(String reinst_from3) {
		this.reinst_from3 = reinst_from3;
	}

	public String getReinst_to3() {
		return reinst_to3;
	}

	public void setReinst_to3(String reinst_to3) {
		this.reinst_to3 = reinst_to3;
	}

	public String getReinst_type3() {
		return reinst_type3;
	}

	public void setReinst_type3(String reinst_type3) {
		this.reinst_type3 = reinst_type3;
	}

	public String getReinst_prm_pct3() {
		return reinst_prm_pct3;
	}

	public void setReinst_prm_pct3(String reinst_prm_pct3) {
		this.reinst_prm_pct3 = reinst_prm_pct3;
	}

	public String getReinst_flat_val3() {
		return reinst_flat_val3;
	}

	public void setReinst_flat_val3(String reinst_flat_val3) {
		this.reinst_flat_val3 = reinst_flat_val3;
	}

	public String getAggr_period() {
		return aggr_period;
	}

	public void setAggr_period(String aggr_period) {
		this.aggr_period = aggr_period;
	}

	public String getAggr_basis() {
		return aggr_basis;
	}

	public void setAggr_basis(String aggr_basis) {
		this.aggr_basis = aggr_basis;
	}

	public String getAggr_limit_val() {
		return aggr_limit_val;
	}

	public void setAggr_limit_val(String aggr_limit_val) {
		this.aggr_limit_val = aggr_limit_val;
	}

	public String getAggr_stability() {
		return aggr_stability;
	}

	public void setAggr_stability(String aggr_stability) {
		this.aggr_stability = aggr_stability;
	}

	public String getStability_type() {
		return stability_type;
	}

	public void setStability_type(String stability_type) {
		this.stability_type = stability_type;
	}

	public String getStab_type_basis() {
		return stab_type_basis;
	}

	public void setStab_type_basis(String stab_type_basis) {
		this.stab_type_basis = stab_type_basis;
	}

	public String getRate_type() {
		return rate_type;
	}

	public void setRate_type(String rate_type) {
		this.rate_type = rate_type;
	}

	public String getBase_index_date() {
		return base_index_date;
	}

	public void setBase_index_date(String base_index_date) {
		this.base_index_date = base_index_date;
	}

	public String getCondition_type() {
		return condition_type;
	}

	public void setCondition_type(String condition_type) {
		this.condition_type = condition_type;
	}

	public String getCondition_val() {
		return condition_val;
	}

	public void setCondition_val(String condition_val) {
		this.condition_val = condition_val;
	}

	public String getBase_index_rate() {
		return base_index_rate;
	}

	public void setBase_index_rate(String base_index_rate) {
		this.base_index_rate = base_index_rate;
	}

	public String getSubsystem_id() {
		return subsystem_id;
	}

	public void setSubsystem_id(String sUBSYSTEM_ID) {
		subsystem_id = sUBSYSTEM_ID;
	}

	public String getIgnore_convrsion() {
		return ignore_convrsion;
	}

	public void setIgnore_convrsion(String ignore_convrsion) {
		this.ignore_convrsion = ignore_convrsion;
	}

	public String getRemttance_method() {
		return remttance_method;
	}

	public void setRemttance_method(String remttance_method) {
		this.remttance_method = remttance_method;
	}

	public String getClaims_excluded() {
		return claims_excluded;
	}

	public void setClaims_excluded(String claims_excluded) {
		this.claims_excluded = claims_excluded;
	}

	public String getSunset_date() {
		return sunset_date;
	}

	public void setSunset_date(String sunset_date) {
		this.sunset_date = sunset_date;
	}

	public String getClaim_model() {
		return claim_model;
	}

	public void setClaim_model(String claim_model) {
		this.claim_model = claim_model;
	}

	public String getFrequency_type() {
		return frequency_type;
	}

	public void setFrequency_type(String frequency_type) {
		this.frequency_type = frequency_type;
	}

	public String getClaim_aggr_limit() {
		return claim_aggr_limit;
	}

	public void setClaim_aggr_limit(String claim_aggr_limit) {
		this.claim_aggr_limit = claim_aggr_limit;
	}

	public String getBilling_doc_type() {
		return billing_doc_type;
	}

	public void setBilling_doc_type(String billing_doc_type) {
		this.billing_doc_type = billing_doc_type;
	}

	public String getContract_usage() {
		return contract_usage;
	}

	public void setContract_usage(String contract_usage) {
		this.contract_usage = contract_usage;
	}

	public String getInterface_type() {
		return interface_type;
	}

	public void setInterface_type(String interface_type) {
		this.interface_type = interface_type;
	}

	public String getCont_amnt_currcy() {
		return cont_amnt_currcy;
	}

	public void setCont_amnt_currcy(String cont_amnt_currcy) {
		this.cont_amnt_currcy = cont_amnt_currcy;
	}
	
	
}
