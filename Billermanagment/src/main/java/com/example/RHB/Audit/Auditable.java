package com.example.RHB.Audit;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@Getter
@Setter
public abstract class Auditable<U> {
	
	@CreatedBy
	protected U CreatedBy;
	@CreatedDate
	@Temporal(TIMESTAMP)
	protected Date CreatedDate;
	
	@LastModifiedBy
	protected U LastModifiedBy;
	
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	protected Date LastModifiedDate;
	
	

}
