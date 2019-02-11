package io.bilisim.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import io.bilisim.validator.ValidaterOfValidateUsingAnotherStringField;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ValidaterOfValidateUsingAnotherStringField.class)
public @interface ValidateUsingAnotherStringField {
	/*mandatory*/
	String message() default "";
	
	Class<? extends Payload>[] payload() default {};
	
	Class<?>[] groups() default {};
	
	/*User defined*/
	String fieldName();
	
	String dependFieldName();
	
	String expectedDependFieldValue();
	
	String expectedFieldValue();
}
