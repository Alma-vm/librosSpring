package almavm.libros1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almavm.libros1.mongo.documentos.Libros;
import almavm.libros1.repository.LibroRepository;

@RestController
@RequestMapping("/Libros")
public class LibrosController {
		@Autowired
		private LibroRepository libroRepo;
		
		@PostMapping
		public ResponseEntity<?> createLibro(@RequestBody Libros libro){
			try {
				Libros librocreate= libroRepo.create(libro);
				return new ResponseEntity<Libros>(librocreate, HttpStatus.CREATED );
			}catch(Exception e) {
					return new ResponseEntity<String>(e.getCause().toString(), 
							HttpStatus.INTERNAL_SERVER_ERROR);
				}		
		}
		
		@GetMapping
		public ResponseEntity<?> finAllLibros(){
			try {
				List<Libros> libros= libroRepo.findAll();
				return new ResponseEntity<List <Libros>>(libros, HttpStatus.OK );
			}catch(Exception e) {
					return new ResponseEntity<String>(e.getCause().toString(), 
							HttpStatus.INTERNAL_SERVER_ERROR);
				}	

		}
		
		@PutMapping
		public ResponseEntity<?> updateLibro(@RequestBody Libros libro){
			try {
				Libros librocreate= libroRepo.create(libro);
				return new ResponseEntity<Libros>(librocreate, HttpStatus.OK );
			}catch(Exception e) {
					return new ResponseEntity<String>(e.getCause().toString(), 
							HttpStatus.INTERNAL_SERVER_ERROR);
				}		
		}
		
		@DeleteMapping(value="/{id}")
		public ResponseEntity<?> deleteLibro(@PathVariable Integer id){
			try {
				libroRepo.deleteById(id);
				return new ResponseEntity<String>("Fue eliminado", HttpStatus.OK );
			}catch(Exception e) {
					return new ResponseEntity<String>(e.getCause().toString(), 
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
		
		}

}
