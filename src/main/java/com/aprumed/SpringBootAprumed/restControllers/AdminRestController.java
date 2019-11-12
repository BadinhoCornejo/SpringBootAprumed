package com.aprumed.SpringBootAprumed.restControllers;

import com.aprumed.SpringBootAprumed.models.*;
import com.aprumed.SpringBootAprumed.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @Autowired
    AvatarService avatarService;

    @Autowired
    private LibroService libroService;

    @Autowired
    private PortadaService portadaService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private EjemplarService ejemplarService;

    @Autowired
    VentaService ventaService;

    @Autowired
    LineaVentaService lineaVentaService;

    @Autowired
    ReceptorService receptorService;

    @Autowired
    ComprobantePagoService comprobantePagoService;


    //USERS
    @GetMapping("listUsers")
    public List<Usuario> listUsuario(){
        return usuarioService.listUsuarios();
    }

    //BOOKS
    @GetMapping("listBooks")
    public List<Libro> listaLibros(HttpServletRequest request) {

        List<Libro> libros = libroService.listLibros();

        return libros;
    }

    @PostMapping(value = "newBook", consumes = "application/json", produces = "application/json")
    public Libro nuevoLibroPost(@RequestBody Libro libro) {
        libro.setStock(0);
        libro.setEstado("Inactivo");

        return libroService.addLibro(libro);
    }

    @PutMapping(value = "editBook" , consumes = "application/json", produces = "application/json")
    public Libro editarLibroPost(@RequestBody Libro libro) {

        Libro _libro = libroService.getLibroByIsbn(libro.getIsbn());

        if(_libro != null){
            libro.setStock(_libro.getStock());
            libro.setLibroID(_libro.getLibroID());
            if(libro.getPortada() == null){
                libro.setPortada(_libro.getPortada());
            }
        }

        return libroService.addLibro(libro);
    }

    @PutMapping(value = "eliminarLibro/{id}", consumes = "application/json", produces = "application/json")
    public Libro eliminarLibro(@PathVariable(value = "id") int id) {
        Libro libro = null;
        libro = libroService.getLibroById(id);
        libro.setInactivo();
        return libroService.addLibro(libro);
    }

    @PostMapping(value = "addEjemplares", consumes = "application/json", produces = "application/json")
    public Libro agregarEjemplar(@RequestBody List<Ejemplar> ejemplares){

        Libro libro = new Libro();

        for (Ejemplar ejemplar : ejemplares) {
            ejemplar.setActivo();
            libro = libroService.getLibroById(ejemplar.libro.getLibroID());
        }

        ejemplarService.addEjemplares(ejemplares);

        List<Ejemplar> ejemplaresByLibro = ejemplarService.getEjemplaresByLibro(libro.getLibroID());

        libro.calcularStock(ejemplaresByLibro);

        return libroService.addLibro(libro);
    }

    //CATEGORIES
    @PostMapping(value="newCategorie", consumes = "application/json", produces = "application/json")
    public Categoria crearCategoriaPost(@RequestBody Categoria categoria){
        categoria.setActivo();
        return categoriaService.addCategoria(categoria);
    }

    @PutMapping(value="editCategorie", consumes = "application/json", produces = "application/json")
    public Categoria editarCategoriaPost(@RequestBody Categoria categoria) {
        return categoriaService.addCategoria(categoria);
    }

    //SALES
    @GetMapping(value = "listaVentas")
    public List<Venta> listVenta(Model model ) {
        List<Venta> lista = ventaService.listaVentas();

        return lista;
    }


}
