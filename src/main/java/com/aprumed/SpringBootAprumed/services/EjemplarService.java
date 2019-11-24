package com.aprumed.SpringBootAprumed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aprumed.SpringBootAprumed.models.Ejemplar;
import com.aprumed.SpringBootAprumed.repositories.IEjemplar;

@Service
public class EjemplarService {

	@Autowired
	private IEjemplar ejemplarRepo;

	public List<Ejemplar> listEjemplares() {
		return ejemplarRepo.findAll();
	}

	public Ejemplar addEjemplar(Ejemplar ejemplar) {
		return ejemplarRepo.save(ejemplar);
	}

	public List<Ejemplar> addEjemplares(List<Ejemplar> ejemplars){
		return ejemplarRepo.saveAll(ejemplars);
	}

	public Ejemplar getEjemplarById(int id) {
		return ejemplarRepo.findById(id).get();
	}

	public Ejemplar getEjemplarBySku(String sku) {
		return ejemplarRepo.findBySku(sku);
	}

	public List<Ejemplar> listarLibros(PageRequest pageable) {
		return ejemplarRepo.listEjemplaresWithPagination(pageable);
	}

	public List<Ejemplar> ejemplaresPorCategoria(int categoriaID){ return ejemplarRepo.ejemplaresByCategorie(categoriaID);}

	public List<Ejemplar> buscarLibroEjemplar(String parameter ) {
		return ejemplarRepo.buscarLibroEjemplar(parameter);
	}
	
	public List<Ejemplar> listarLibrosCategoria(int categoriaID,PageRequest pageable) {
		return ejemplarRepo.listEjemplaresWithPaginationCategorie(categoriaID,pageable);
	}

	public List<Ejemplar> getEjemplaresByLibro(int libroID){
		return ejemplarRepo.findEjemplarByLibroLibroID(libroID);
	}

	public Ejemplar getOneEjemplar(String isbn){return ejemplarRepo.getOneEjemplar(isbn);}

	public void deleteEjemplarById(int id) {
		ejemplarRepo.deleteById(id);
	}

}
