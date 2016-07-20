package com.ksairamesh.devel.outfits.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

public class Outfit {

	@Entity
	@EntityListeners(AuditingEntityListener.class)
	public class Note
	{
		@Id
		@GeneratedValue
		private Long id;
		
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate
		@Column(nullable = false)
		private Date updateDate;
		
		@Temporal(TemporalType.TIMESTAMP)
		@CreatedDate
		@Column(updatable = false, nullable = false)
		private Date createDate;
		
		@NotBlank
		private String value;
		
		@NotBlank
		private String outfitType;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getOutfitType() {
			return outfitType;
		}

		public void setOutfitType(String outfitType) {
			this.outfitType = outfitType;
		}

	}

	
}
