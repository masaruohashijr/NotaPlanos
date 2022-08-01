package br.gov.previc.cgti.notaautomatica.model;

public class Avaliacao {

	private String cnpb;
	private String solvencia;
	private String ativos;
	private String atuarial;
	private String resultado;
	private String eficienciaOperacional;

	public Avaliacao(
			final String cnpb, 
			final String solvencia, 
			final String ativos, 
			final String atuarial, 
			final String resultado,
			final String eficienciaOperacional) {
		super();
		this.cnpb = cnpb;
		this.solvencia = solvencia;
		this.ativos = ativos;
		this.atuarial = atuarial;
		this.resultado = resultado;
		this.eficienciaOperacional = eficienciaOperacional;
	}

	public String getCnpb() {
		return cnpb;
	}

	public void setCnpb(String cnpb) {
		this.cnpb = cnpb;
	}

	public String getSolvencia() {
		return solvencia;
	}

	public void setSolvencia(String solvencia) {
		this.solvencia = solvencia;
	}

	public String getAtivos() {
		return ativos;
	}

	public void setAtivos(String ativos) {
		this.ativos = ativos;
	}

	public String getAtuarial() {
		return atuarial;
	}

	public void setAtuarial(String atuarial) {
		this.atuarial = atuarial;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getEficienciaOperacional() {
		return eficienciaOperacional;
	}

	public void setEficienciaOperacional(String eficienciaOperacional) {
		this.eficienciaOperacional = eficienciaOperacional;
	}

}
