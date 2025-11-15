package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.UsuarioEspecialDTO;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.UsuarioGenericoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-14T21:34:21-0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 25 (Eclipse Adoptium)"
)
@Component
public class IUsuarioMapaImpl implements IUsuarioMapa {

    @Override
    public UsuarioGenericoDTO convertir_usuario_a_usuariogenericodto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioGenericoDTO usuarioGenericoDTO = new UsuarioGenericoDTO();

        usuarioGenericoDTO.setNombres( usuario.getNombres() );
        usuarioGenericoDTO.setCorreo( usuario.getCorreo() );
        usuarioGenericoDTO.setEstado( usuario.getEstado() );
        usuarioGenericoDTO.setFechaNacimiento( usuario.getFechaNacimiento() );
        usuarioGenericoDTO.setDocumento( usuario.getDocumento() );

        return usuarioGenericoDTO;
    }

    @Override
    public List<UsuarioGenericoDTO> convertir_lista_a_listadtogenerico(List<Usuario> lista) {
        if ( lista == null ) {
            return null;
        }

        List<UsuarioGenericoDTO> list = new ArrayList<UsuarioGenericoDTO>( lista.size() );
        for ( Usuario usuario : lista ) {
            list.add( convertir_usuario_a_usuariogenericodto( usuario ) );
        }

        return list;
    }

    @Override
    public UsuarioEspecialDTO convertir_usuario_a_usuarioespecialdto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioEspecialDTO usuarioEspecialDTO = new UsuarioEspecialDTO();

        usuarioEspecialDTO.setNombres( usuario.getNombres() );
        usuarioEspecialDTO.setCorreo( usuario.getCorreo() );
        usuarioEspecialDTO.setEstado( usuario.getEstado() );
        usuarioEspecialDTO.setFechaNacimiento( usuario.getFechaNacimiento() );
        usuarioEspecialDTO.setDocumento( usuario.getDocumento() );
        usuarioEspecialDTO.setContraseña( usuario.getContraseña() );

        return usuarioEspecialDTO;
    }

    @Override
    public List<UsuarioEspecialDTO> convertir_lista_a_listadtoespecial(List<Usuario> lista) {
        if ( lista == null ) {
            return null;
        }

        List<UsuarioEspecialDTO> list = new ArrayList<UsuarioEspecialDTO>( lista.size() );
        for ( Usuario usuario : lista ) {
            list.add( convertir_usuario_a_usuarioespecialdto( usuario ) );
        }

        return list;
    }
}
