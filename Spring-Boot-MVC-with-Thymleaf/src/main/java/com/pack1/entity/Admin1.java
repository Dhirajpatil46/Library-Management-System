package com.pack1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "ADMIN1")
public class Admin1 {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "AEMAIL", length = 25)
    private String aemail;

    @Column(name = "PASSWORD", length = 25)
    private String password;

    @Column(name = "ANAME", length = 25)
    private String aname;

    @Column(name = "ADDRESS", length = 25)
    private String address;

    @Column(name = "APHONENO", length = 25)
    private String aphoneno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAphoneno() {
		return aphoneno;
	}

	public void setAphoneno(String aphoneno) {
		this.aphoneno = aphoneno;
	}
    
    

}
