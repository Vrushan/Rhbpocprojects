package com.example.Rhb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Merchant_categeory")
@Data
@Getter
@Setter
@NoArgsConstructor
public class MerchantCategeorys {
	
	@Id
	@Column(name="Merchentid")
	private long Merchentid;
	@Column(name="MerchentType")
	@NotEmpty(message="MerchentType must be not empty")
	private String MerchentType;
	@Column(name="MerchentAddress")
	private String MerchentAddress;
	@Column(name="Merchentno")
	private String Merchentno;
	@Column(name="postalcode")
	private String postalcode;
	
	
	
	public MerchantCategeorys(long Merchentid, String MerchentType, String MerchentAddress, String Merchentno,
			String postalcode) 
	{
		super();
		this.Merchentid = Merchentid;
		this.MerchentType = MerchentType;
		this.MerchentAddress = MerchentAddress;
		this.Merchentno = Merchentno;
		this.postalcode = postalcode;
		
	}
	
	

}
