package br.com.byron.refugioBrasil.strategy.validators;

import java.time.LocalDate;

public class ValidUtil {

	private final static String regexEmail = "^(([^<>()\\[\\]\\.,;:\\s@\\\"]+(\\.[^<>()\\[\\]\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@(([^<>()[\\]\\.,;:\\s@\\\"]+\\.)+[^<>()[\\]\\.,;:\\s@\\\"]{2,})$";
	public static String notNull(Object obj, String nameField) {
		return obj == null ? "O campo "+nameField+" não pode ser nulo" : null;
	}
	
	public static String notEmpty(String obj, String nameField) {
		return obj.isEmpty() ? "O campo "+nameField+" não pode ser vazio" : null;
	}
	
	public static String notEmptyandNull(String obj, String nameField) {
		return obj.isEmpty() || obj == null? "O campo"+nameField+"não pode ser vazio ou nulo" : null;
	}
	
	public static String size(int size, String value, String nameField){
		if(value != null) {
			if(value.trim().length() != size) {
				return "Por favor insira "+ size +"caracteres";
			}
		}
		return null;
	}
	
	public static String size(int min, int max, String value, String nameField){
		if(value != null) {
			if(value.trim().length() < min || value.trim().length() > max) {
				return min!=max?"O campo "+nameField+" entre"+ min + " e "+ max +" caracteres":"O campo "+nameField+" deve ter "+ min +"caracteres";
			}
		}
		return null;
	}
	
	public static String size(String value, String nameField){
		return size(5, 100, value, nameField);
	}
	
	public static String dateInitEnd(LocalDate dateInit, LocalDate dateEnd, String nameField) {
		return dateInit.isAfter(dateEnd) || dateInit.equals(dateEnd)?"O campo "+nameField+" de fim deve ser depois da data início":null;
	}
	
	public static String numberOnlyPositive(Integer number, String nameField) {
		return number <= 0 ? "O campo "+nameField+" deve ser possitivo" : null;
	}
	
	public static String onlyNumbers(String value, String nameField) {
		return !value.matches("^([0-9])$")?"O campo "+nameField+" deve conter apenas numeros":null;
	}
		
	public static String onlyWords(String value, String nameField){
		return !value.matches("^([A-Za-zÀ-ú](\\s){0,1})*$")?"O campo "+nameField+" deve conter apenas letras":null;
	}

	public static String notSpecials(String value, String nameField){
		return !value.matches("^(([A-Za-z])*([\\wÀ-ú])*(\\s){0,1})*$")?"O campo "+nameField+" não pode conter caracteres especiais":null;
	}
	
	public static String validEmail(String value) {
		return !value.matches(regexEmail)?"Por favor insira um e-mail válido":null;		
	}
}