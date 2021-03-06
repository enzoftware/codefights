package service.impl;

import java.util.List;

import dao.ILibroDAO;
import dao.impl.LibroDAOImpl;
import entities.Libro;
import service.ILibroService;

public class LibroServiceImpl implements ILibroService {

	ILibroDAO dao = null;
	
	public LibroServiceImpl() {
		dao = new LibroDAOImpl();
	}

	@Override
	public List<Libro> listar() {
		
		return dao.listar();
	}

	@Override
	public boolean agregar(Libro obj) {
		// TODO Auto-generated method stub
		
		return dao.agregar(obj);
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub

		return dao.eliminar(id);
	}

}
