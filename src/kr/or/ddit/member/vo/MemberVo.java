package kr.or.ddit.member.vo;

public class MemberVo {
	private String mem_id;
	private String mem_pass;
	private String mem_nama;
	private String mem_mail;
	private String mem_hp;
	private String mem_add1;
	private String mem_add2;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_nama() {
		return mem_nama;
	}
	public void setMem_nama(String mem_nama) {
		this.mem_nama = mem_nama;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_hp() {
		return mem_hp;
	}
	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}
	public String getMem_add1() {
		return mem_add1;
	}
	public void setMem_add1(String mem_add1) {
		this.mem_add1 = mem_add1;
	}
	public String getMem_add2() {
		return mem_add2;
	}
	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}
	@Override
	public String toString() {
		return "MemberVo [mem_id=" + mem_id + ", mem_pass=" + mem_pass
				+ ", mem_nama=" + mem_nama + ", mem_mail=" + mem_mail
				+ ", mem_hp=" + mem_hp + ", mem_add1=" + mem_add1
				+ ", mem_add2=" + mem_add2 + "]";
	}
	public MemberVo(String mem_id, String mem_pass, String mem_nama,
			String mem_mail, String mem_hp, String mem_add1, String mem_add2) {
		super();
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
		this.mem_nama = mem_nama;
		this.mem_mail = mem_mail;
		this.mem_hp = mem_hp;
		this.mem_add1 = mem_add1;
		this.mem_add2 = mem_add2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mem_add1 == null) ? 0 : mem_add1.hashCode());
		result = prime * result
				+ ((mem_add2 == null) ? 0 : mem_add2.hashCode());
		result = prime * result + ((mem_hp == null) ? 0 : mem_hp.hashCode());
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result
				+ ((mem_mail == null) ? 0 : mem_mail.hashCode());
		result = prime * result
				+ ((mem_nama == null) ? 0 : mem_nama.hashCode());
		result = prime * result
				+ ((mem_pass == null) ? 0 : mem_pass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVo other = (MemberVo) obj;
		if (mem_add1 == null) {
			if (other.mem_add1 != null)
				return false;
		} else if (!mem_add1.equals(other.mem_add1))
			return false;
		if (mem_add2 == null) {
			if (other.mem_add2 != null)
				return false;
		} else if (!mem_add2.equals(other.mem_add2))
			return false;
		if (mem_hp == null) {
			if (other.mem_hp != null)
				return false;
		} else if (!mem_hp.equals(other.mem_hp))
			return false;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (mem_mail == null) {
			if (other.mem_mail != null)
				return false;
		} else if (!mem_mail.equals(other.mem_mail))
			return false;
		if (mem_nama == null) {
			if (other.mem_nama != null)
				return false;
		} else if (!mem_nama.equals(other.mem_nama))
			return false;
		if (mem_pass == null) {
			if (other.mem_pass != null)
				return false;
		} else if (!mem_pass.equals(other.mem_pass))
			return false;
		return true;
	}
	public MemberVo() {
	}
	
}
