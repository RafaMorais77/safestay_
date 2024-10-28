package com.nexushost.safestay.controller;

import com.nexushost.safestay.service.UsuarioService; // Corrigido o caminho do pacote
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // Injeção de dependência do serviço de usuário

    /**
     * Método para registrar um novo usuário.
     *
     * @param email O e-mail do usuário a ser registrado.
     * @param senha A senha do usuário a ser registrada.
     * @param model O modelo que armazena atributos para a view.
     * @return O nome da view a ser renderizada.
     */
    @PostMapping("/register")
    public String registrarUsuario(@RequestParam String email,
                                   @RequestParam String senha,
                                   Model model) {
        // Cadastra o usuário e obtém uma mensagem de retorno
        String mensagem = usuarioService.cadastrarUsuario(email, senha);
        
        // Adiciona a mensagem ao modelo, diferenciando entre sucesso e erro
        model.addAttribute(mensagem.contains("sucesso") ? "success" : "error", mensagem);
        
        // Retorna à página de index.jsp
        return "index"; // A página onde o usuário será redirecionado após o registro
    }
}
