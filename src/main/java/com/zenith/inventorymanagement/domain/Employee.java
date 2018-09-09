package com.zenith.inventorymanagement.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee", schema="management")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fname;
	private String lname;
	private Designation position;
	private LocalDate dob;
	private String email;
	private String password;

	private Integer workDays;
	private Integer absentDays;

	public Employee(String namef, String namel, Designation pos, LocalDate date, String maile, String pass, int w, int a )
	{
		fname = namef;
		lname = namel;
		position = pos;
		dob = date;
		email = maile;
		password = pass;
		workDays = w;
		absentDays = a;
	}

	public Employee() {
	}

	public Long getId() {
		return this.id;
	}

	public String getFname() {
		return this.fname;
	}

	public String getLname() {
		return this.lname;
	}

	public Designation getPosition() {
		return this.position;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public Integer getWorkDays() {
		return this.workDays;
	}

	public Integer getAbsentDays() {
		return this.absentDays;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setPosition(Designation position) {
		this.position = position;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setWorkDays(Integer workDays) {
		this.workDays = workDays;
	}

	public void setAbsentDays(Integer absentDays) {
		this.absentDays = absentDays;
	}

	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Employee)) return false;
		final Employee other = (Employee) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
		final Object this$fname = this.getFname();
		final Object other$fname = other.getFname();
		if (this$fname == null ? other$fname != null : !this$fname.equals(other$fname)) return false;
		final Object this$lname = this.getLname();
		final Object other$lname = other.getLname();
		if (this$lname == null ? other$lname != null : !this$lname.equals(other$lname)) return false;
		final Object this$position = this.getPosition();
		final Object other$position = other.getPosition();
		if (this$position == null ? other$position != null : !this$position.equals(other$position)) return false;
		final Object this$dob = this.getDob();
		final Object other$dob = other.getDob();
		if (this$dob == null ? other$dob != null : !this$dob.equals(other$dob)) return false;
		final Object this$email = this.getEmail();
		final Object other$email = other.getEmail();
		if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
		final Object this$password = this.getPassword();
		final Object other$password = other.getPassword();
		if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
		final Object this$workDays = this.getWorkDays();
		final Object other$workDays = other.getWorkDays();
		if (this$workDays == null ? other$workDays != null : !this$workDays.equals(other$workDays)) return false;
		final Object this$absentDays = this.getAbsentDays();
		final Object other$absentDays = other.getAbsentDays();
		if (this$absentDays == null ? other$absentDays != null : !this$absentDays.equals(other$absentDays))
			return false;
		return true;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $fname = this.getFname();
		result = result * PRIME + ($fname == null ? 43 : $fname.hashCode());
		final Object $lname = this.getLname();
		result = result * PRIME + ($lname == null ? 43 : $lname.hashCode());
		final Object $position = this.getPosition();
		result = result * PRIME + ($position == null ? 43 : $position.hashCode());
		final Object $dob = this.getDob();
		result = result * PRIME + ($dob == null ? 43 : $dob.hashCode());
		final Object $email = this.getEmail();
		result = result * PRIME + ($email == null ? 43 : $email.hashCode());
		final Object $password = this.getPassword();
		result = result * PRIME + ($password == null ? 43 : $password.hashCode());
		final Object $workDays = this.getWorkDays();
		result = result * PRIME + ($workDays == null ? 43 : $workDays.hashCode());
		final Object $absentDays = this.getAbsentDays();
		result = result * PRIME + ($absentDays == null ? 43 : $absentDays.hashCode());
		return result;
	}

	protected boolean canEqual(Object other) {
		return other instanceof Employee;
	}

	public String toString() {
		return "Employee(id=" + this.getId() + ", fname=" + this.getFname() + ", lname=" + this.getLname() + ", position=" + this.getPosition() + ", dob=" + this.getDob() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", workDays=" + this.getWorkDays() + ", absentDays=" + this.getAbsentDays() + ")";
	}
}
