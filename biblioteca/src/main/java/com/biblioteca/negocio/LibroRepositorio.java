package com.biblioteca.negocio;

import java.util.List;
import java.util.Optional;

public interface    LibroRepositorio {

    List<Libro> listar();

    Optional<Libro> buscarPorId(Long id);
}
