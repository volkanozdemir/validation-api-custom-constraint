package io.bilisim.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import io.bilisim.anotation.ValidateUsingAnotherStringField;

public class ValidaterOfValidateUsingAnotherStringField implements ConstraintValidator<ValidateUsingAnotherStringField, Object> {

	private String fieldName;
	private String expectedFieldValue;
	private String dependFieldName;
	private String expectedDependFieldValue;
	
	@Override
	public void initialize(ValidateUsingAnotherStringField constraintAnnotation) {
		this.fieldName = constraintAnnotation.fieldName();
		this.expectedFieldValue = constraintAnnotation.expectedFieldValue();
		this.dependFieldName = constraintAnnotation.dependFieldName();
		this.expectedDependFieldValue = constraintAnnotation.expectedDependFieldValue();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			//subject alaný (fieldName) degeri expectedFieldValue ise (kosulumuzda A olacak bu deger)
			if(BeanUtils.getProperty(value, fieldName).equalsIgnoreCase(expectedFieldValue)) {
				// publish(dependValue) degeri expectedDependFieldValue (kosulumuzda true) deðerine eþit olmalý. Eþit deðilse validasyon hatasý olur. 
				if(!BeanUtils.getProperty(value, dependFieldName).equalsIgnoreCase(expectedDependFieldValue)) {
					return false;
				}
			} else {
				if(BeanUtils.getProperty(value, dependFieldName).equalsIgnoreCase(expectedDependFieldValue)) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}	
}
