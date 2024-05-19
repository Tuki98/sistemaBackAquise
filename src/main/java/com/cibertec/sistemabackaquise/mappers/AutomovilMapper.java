package com.cibertec.sistemabackaquise.mappers;

import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilCreateDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilDTO;
import com.cibertec.sistemabackaquise.dtos.AutomovilDTO.AutomovilUpdateDTO;
import com.cibertec.sistemabackaquise.model.Automovil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AutomovilMapper {


    AutomovilMapper instancia = Mappers.getMapper(AutomovilMapper.class);

    @Mapping(target = "marcaDTO", source = "marca")
    @Mapping(target = "motorDTO", source = "motor")
    @Mapping(target = "colorDTO", source = "color")
    AutomovilDTO automovilToAutomovilDTO(Automovil automovil);

    @Mapping(target = "marca", source = "marcaDTO")
    @Mapping(target = "motor", source = "motorDTO")
    @Mapping(target = "color", source = "colorDTO")
    Automovil automovilDTOToAutomovil(AutomovilDTO automovilDTO);

    @Mapping(target = "marca", source = "marcaDTO")
    @Mapping(target = "motor", source = "motorDTO")
    @Mapping(target = "color", source = "colorDTO")
    Automovil automovilCreateDTOToAutomovil(AutomovilCreateDTO automovilCreateDTO);

    @Mapping(target = "marca", source = "marcaDTO")
    @Mapping(target = "motor", source = "motorDTO")
    @Mapping(target = "color", source = "colorDTO")
    Automovil automovilUpdateDTOToAutomovil(AutomovilUpdateDTO automovilUpdateDTO);

    @Mapping(target = "marca", source = "marcaDTO")
    @Mapping(target = "motor", source = "motorDTO")
    @Mapping(target = "color", source = "colorDTO")
    List<AutomovilDTO> listaAutomovilAListaAutomovilDTO(List<Automovil> listaAutomovil);
}
