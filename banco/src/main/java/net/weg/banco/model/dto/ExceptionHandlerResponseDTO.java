package net.weg.banco.model.dto;

import java.time.LocalDateTime;

public record ExceptionHandlerResponseDTO(String mensagem, LocalDateTime horario) {
}