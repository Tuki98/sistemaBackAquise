package com.cibertec.sistemabackaquise.mappers;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorCreateDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorDTO;
import com.cibertec.sistemabackaquise.dtos.ColorDTO.ColorUpdateDTO;
import com.cibertec.sistemabackaquise.model.Color;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;
@Mapper
public interface ColorMapper {
    ColorMapper instancia = Mappers.getMapper(ColorMapper.class);


    ColorDTO colorToColorDTO(Color color);

   Color colorDTOToColor(ColorDTO colorDTO);


    Color colorCreateDTOToColor(ColorCreateDTO colorCreateDTO);


    Color colorUpdateDTOToColor(ColorUpdateDTO colorUpdateDTO);


    List<ColorDTO> listaColorAListaColorDTO(List<Color> listaColor);
}
