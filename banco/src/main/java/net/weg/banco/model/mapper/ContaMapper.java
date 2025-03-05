//package net.weg.banco.model.mapper;
//
//import net.weg.banco.model.dto.ContaClienteResponseDTO;
//import net.weg.banco.model.dto.ContaGetResponseDTO;
//import net.weg.banco.model.dto.ContaPostRequestDTO;
//import net.weg.banco.model.entity.Conta;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public interface ContaMapper {
//    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);
//
//    @Mapping(expression = "java(conta.getId())")
//    ContaGetResponseDTO contaToContaGetResponseDTO(Conta conta);
//
//    ContaClienteResponseDTO contaToContaClienteResponseDTO(Conta conta);
//    ContaPostRequestDTO contaToContaPostRequestDTO(Conta conta);
//}
