package br.com.byron.refugioBrasil.strategy.validators;

import java.time.LocalDate;

public class ValidUtil {

	private final static String regexEmail = "^(([^<>()\\[\\]\\.,;:\\s@\\\"]+(\\.[^<>()\\[\\]\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@(([^<>()[\\]\\.,;:\\s@\\\"]+\\.)+[^<>()[\\]\\.,;:\\s@\\\"]{2,})$";
	public static String notNull(Object obj) {
		return obj == null ? "O campo não pode ser nulo" : null;
	}
	
	public static String notEmpty(String obj) {
		return obj.isEmpty() ? "O campo não pode ser vazio" : null;
	}
	
	public static String notEmptyandNull(String obj) {
		return obj.isEmpty() || obj == null? "O campo não pode ser vazio ou nulo" : null;
	}
	
	public static String size(int min, int max, String value){
		if(value != null) {
			if(value.trim().length() < min || value.trim().length() > max) {
				return min!=max?"Por favor insira entre"+ min + " e "+ max +" caracteres":"Por favor insira "+ min +"caracteres";
			}
		}
		return null;
	}
	
	public static String dateInitEnd(LocalDate dateInit, LocalDate dateEnd) {
		return dateInit.isAfter(dateEnd) || dateInit.equals(dateEnd)?"Por favor a data de fim deve ser depois da data início":null;
	}
	
	public static String numberOnlyPositive(Integer number) {
		return number <= 0 ? "Esse valor deve ser possitivo" : null;
	}
	
	public static String onlyNumbers(String value) {
		return !value.matches("^([0-9])$")?"esse campo deve conter apenas numeros":null;
	}
		
	public static String onlyWords(String value){
		return !value.matches("^([A-Za-zÀ-ú](\\s){0,1})*$")?"esse campo deve conter apenas letras":null;
	}

	public static String notSpecials(String value){
		return !value.matches("^(([A-Za-z])*([\\wÀ-ú])*(\\s){0,1})*$")?"esse campo não pode conter caracteres especiais":null;
	}
	
	public static String validEmail(String value) {
		return !value.matches(regexEmail)?"Por favor insira um e-mail válido":null;		
	}
}