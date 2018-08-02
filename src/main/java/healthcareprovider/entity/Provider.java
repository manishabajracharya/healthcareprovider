package healthcareprovider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ipps")
public class Provider {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="DRG_Definition")
	private String drgDefinition;
	
	@Column(name="Provider_Id")
	private int providerId;
	
	@Column(name="Provider_Name")
	private String providerName;
	
	@Column(name="Provider_Street_Address")
	private String providerStreetAddress;
	
	@Column(name="Provider_City")
	private String providerCity;
	
	@Column(name="Provider_State")
	private String providerState;
	
	@Column(name="Provider_Zip_Code")
	private String providerZipCode;
	
	@Column(name="Hospital_Referral_Region_Description")
	private String hospitalReferralRegionDescription;
	
	@Column(name="Total_Discharges")
	private int totalDischarges;
	
	@Column(name="Average_Covered_Charges")
	private double averageCoveredCharges;
	
	@Column(name="Average_Total_Payments")
	private double averageTotalPayments;
	
	@Column(name="Average_Medicare_Payments")
	private double averageMedicarePayments;	
	
	public Provider() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrgDefinition() {
		return drgDefinition;
	}

	public void setDrgDefinition(String drgDefinition) {
		this.drgDefinition = drgDefinition;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderStreetAddress() {
		return providerStreetAddress;
	}

	public void setProviderStreetAddress(String providerStreetAddress) {
		this.providerStreetAddress = providerStreetAddress;
	}

	public String getProviderCity() {
		return providerCity;
	}

	public void setProviderCity(String providerCity) {
		this.providerCity = providerCity;
	}

	public String getProviderState() {
		return providerState;
	}

	public void setProviderState(String providerState) {
		this.providerState = providerState;
	}

	public String getProviderZipCode() {
		return providerZipCode;
	}

	public void setProviderZipCode(String providerZipCode) {
		this.providerZipCode = providerZipCode;
	}

	public String getHospitalReferralRegionDescription() {
		return hospitalReferralRegionDescription;
	}

	public void setHospitalReferralRegionDescription(String hospitalReferralRegionDescription) {
		this.hospitalReferralRegionDescription = hospitalReferralRegionDescription;
	}

	public int getTotalDischarges() {
		return totalDischarges;
	}

	public void setTotalDischarges(int totalDischarges) {
		this.totalDischarges = totalDischarges;
	}

	public double getAverageCoveredCharges() {
		return averageCoveredCharges;
	}

	public void setAverageCoveredCharges(double averageCoveredCharges) {
		this.averageCoveredCharges = averageCoveredCharges;
	}

	public double getAverageTotalPayments() {
		return averageTotalPayments;
	}

	public void setAverageTotalPayments(double averageTotalPayments) {
		this.averageTotalPayments = averageTotalPayments;
	}

	public double getAverageMedicarePayments() {
		return averageMedicarePayments;
	}

	public void setAverageMedicarePayments(double averageMedicarePayments) {
		this.averageMedicarePayments = averageMedicarePayments;
	}

	
		
}





