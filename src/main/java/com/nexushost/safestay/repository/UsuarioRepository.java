package com.nexushost.safestay.repository; // Corrigido para o caminho correto do pacote

import com.nexushost.safestay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Adiciona a anotação @Repository para garantir que o Spring reconheça como um bean de repositório
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
