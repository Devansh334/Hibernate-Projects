package Hibernate_Menu_Driven.Hibernate_Menu_Driven;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Acropolis {
	@Id
	@Column(name="Enrollment_No")
	int Enroll;
	
	@Column(name="Student_Name")
	String name;
	
	@Column(name="Percentage")
	float per;

	public int getEnroll() {
		return Enroll;
	}

	public void setEnroll(int enroll) {
		Enroll = enroll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}

	
	
}
