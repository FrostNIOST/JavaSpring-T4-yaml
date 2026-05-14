package co.edu.sena.project_yaml.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AllowedCombinationValidator implements ConstraintValidator<AllowedCombination, Cliente> {

    @Override
    public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
        if (cliente == null) return true;
        TipoDocumentoEmbedded tipo = cliente.getTipoDocumentoEmbedded();
        // If no tipo provided, skip this validator (use other @NotNull if needed)
        if (tipo == null || tipo.getSigla() == null) return true;

        String sigla = tipo.getSigla();
        String numero = cliente.getNumeroDocumento();

        // Rule: if tipo sigla is CC (cédula de ciudadanía) then numeroDocumento is required
        if ("CC".equalsIgnoreCase(sigla)) {
            boolean ok = numero != null && !numero.isBlank();
            if (!ok) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Para tipo CC se requiere numeroDocumento (cédula)")
                        .addPropertyNode("numeroDocumento")
                        .addConstraintViolation();
            }
            return ok;
        }

        // default: accept
        return true;
    }
}
