package com.nexushost.safestay.service;

import com.nexushost.safestay.model.Usuario;
import com.nexushost.safestay.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Método para cadastrar um novo usuário.
     *
     * @param email O e-mail do usuário a ser registrado.
     * @param senha A senha do usuário a ser registrada.
     * @return Mensagem de sucesso ou erro.
     */
    public String cadastrarUsuario(String email, String senha) {
        // Verifica se o email já está cadastrado
        if (usuarioRepository.existsByEmail(email)) {
            return "Email já cadastrado!";
        }

        // Cria um novo usuário e define os valores de email e senha
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);

        // Salva o usuário no repositório
        usuarioRepository.save(usuario);

        return "Cadastro realizado com sucesso!";
    }
}
