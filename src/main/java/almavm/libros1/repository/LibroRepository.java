package almavm.libros1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import almavm.libros1.mongo.documentos.Libros;

public interface LibroRepository extends MongoRepository<Libros,Integer>{

	Libros create(Libros libro);

}
