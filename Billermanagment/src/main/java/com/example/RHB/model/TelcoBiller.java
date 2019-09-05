package com.example.RHB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.RHB.Audit.Auditable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TelcoBiller")
@EntityListeners(AuditingEntityListener.class)
@Data
@Getter
@Setter
@NoArgsConstructor
public class TelcoBiller extends Auditable<String> {
	
	@Id
	@Column(name="id")
	private long id;
	@Column(name="Billername")
	private String Billername;
	@Column(name="BillerAddress")
	private String BillerAddress;
	@Column(name="email")
	private String email;
	@Column(name="State")
	private String State;
	
	public TelcoBiller(long id, String Billername, String BillerAddress, String email, String State) {
		super();
		this.id = id;
		this.Billername = Billername;
		this.BillerAddress = BillerAddress;
		this.email = email;
		this.State = State;
	}

	@Override
	public String toString() {
		return "TelcoBiller [id=" + id + ", Billername=" + Billername + ", BillerAddress=" + BillerAddress + ", email="
				+ email + ", State=" + State + "]";
	}
	
	

}
