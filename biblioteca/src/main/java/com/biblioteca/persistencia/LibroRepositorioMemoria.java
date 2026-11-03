package com.biblioteca.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.biblioteca.negocio.Libro;
import com.biblioteca.negocio.LibroRepositorio;

@Repository
public class LibroRepositorioMemoria implements LibroRepositorio {

    private final List<Libro> libros = List.of(
            new Libro(1L, "Cien años de soledad", "Gabriel García Márquez", 1967),
            new Libro(2L, "El amor en los tiempos del cólera", "Gabriel García Márquez", 1985),
            new Libro(3L, "La ciudad y los perros", "Mario Vargas Llosa", 1963),
            new Libro(4L, "Rayuela", "Julio Cortázar", 1963),
            new Libro(5L, "Ficciones", "Jorge Luis Borges", 1944)
    );

    @Override
    public List<Libro> listar() {
        return List.copyOf(libros);
    }

    @Override
    public Optional<Libro> buscarPorId(Long id) {
        return libros.stream()
                .filter(libro -> libro.id().equals(id))
                .findFirst();
    }
}
