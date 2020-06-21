@Documented
@Constraint(validatedBy = Validator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RegularAmountConstraint {
    String message() default "Invalid: amount supplied is non divisable by a whole number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}