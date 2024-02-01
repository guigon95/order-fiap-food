package br.com.fiapfood.order.application.core.exception;

import br.com.fiapfood.order.adapter.dto.response.exceptions.ErrorMessage;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class InvalidFieldException extends RuntimeException {
    String message;
    List<ErrorMessage.CauseError> causeErrorList;
}
