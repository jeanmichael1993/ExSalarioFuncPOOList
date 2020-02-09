package entities;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private Double salario;
	
	
	public Funcionario() {
		
	}
	
	public Funcionario(int id,String nome,double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void aumentarSalario(double percentage) {
		this.salario += salario / percentage;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId());
		sb.append(", ");
		sb.append(getNome());
		sb.append(", ");
		sb.append(getSalario());
		return sb.toString();
		
	}
}
