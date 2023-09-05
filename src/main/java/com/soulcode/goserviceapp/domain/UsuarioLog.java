package com.soulcode.goserviceapp.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;

@Document(collection = "usuarios")
@Getter @Setter @NoArgsConstructor
public class UsuarioLog {
    @Id
    private String id;

    private String nome;

    private String email;

    private String perfil;

    @Field(targetType = FieldType.DATE_TIME)
    private LocalDateTime dataLog = LocalDateTime.now();


    public UsuarioLog(String id, String nome, String email, String perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
    }

    public UsuarioLog (Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.perfil = usuario.getPerfil().getDescricao();
    }


}
