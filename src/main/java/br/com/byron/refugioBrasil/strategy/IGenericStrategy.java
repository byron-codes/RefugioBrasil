package br.com.byron.refugioBrasil.strategy;

public interface IGenericStrategy<O> {
	public String execute(O entity);
}
