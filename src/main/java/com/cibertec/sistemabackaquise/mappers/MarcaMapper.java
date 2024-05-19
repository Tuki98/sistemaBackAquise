package com.cibertec.sistemabackaquise.mappers;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaCreateDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaDTO;
import com.cibertec.sistemabackaquise.dtos.MarcaDTO.MarcaUpdateDTO;
import com.cibertec.sistemabackaquise.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface MarcaMapper {
    MarcaMapper instancia = Mappers.getMapper(MarcaMapper.class);


    MarcaDTO marcaToMarcaDTO(Marca marca);

    Marca marcaDTOToMarca(MarcaDTO marcaDTO);

    Marca marcaCreateDTOToMarca(MarcaCreateDTO marcaCreateDTO);

    Marca marcaUpdateDTOToMarca(MarcaUpdateDTO marcaUpdateDTO);


    List<MarcaDTO> listaMarcaAListaMarcaDTO(List<Marca> listaMarca);
}
