package model;

public class JavaBeans {

	private String nome;
	private String email;
	private String fone;
	private int ID;

	public JavaBeans() {

	}

	public JavaBeans(String nome, String email, String fone, int ID) {
		super();
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

}
