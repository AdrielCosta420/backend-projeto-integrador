package com.projetointegrador.app.rest.Controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.app.rest.Models.Auth;

import com.projetointegrador.app.rest.Models.Carro;
import com.projetointegrador.app.rest.Models.Usuario;
import com.projetointegrador.app.rest.Repo.CarroRepository;
import com.projetointegrador.app.rest.Repo.UsuarioRepository;


@RestController
public class ApiControllers {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private CarroRepository carroRepo;



	@GetMapping(value = "/")
	public String getPage() {
		return "TAMO AKI";
	}

	@GetMapping(value = "/users")
	public List<Usuario> getUsers() {
		return usuarioRepo.findAll();
	}

	@PostMapping(value = "/saveUser")
	public String saveUser(@RequestBody Usuario usuario) {
		usuarioRepo.save(usuario);
		return "USUARIO SALVO";
	}

	@PutMapping(value = "update/{id}")
	public String updateUser(@PathVariable Integer id, @RequestBody Usuario usuario) {

		Usuario updateUsuario = usuarioRepo.findById(id).get();

		updateUsuario.setAtivo(usuario.isAtivo());
		updateUsuario.setDataCadastro(usuario.getDataCadastro());
		updateUsuario.setDataNascimento(usuario.getDataNascimento());
		updateUsuario.setLogin(usuario.getLogin());
		updateUsuario.setSenha(usuario.getSenha());
		updateUsuario.setNome(usuario.getNome());

		usuarioRepo.save(updateUsuario);

		return "USUARIO ATUALIZADO";

	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		Usuario deleteUser = usuarioRepo.findById(id).get();

		usuarioRepo.delete(deleteUser);

		return "USUARIO DELETADO ID:" + id;

	}

	@GetMapping(value = "/carros")
	public List<Carro> getCarros() {
		return carroRepo.findAll();
	}

	@GetMapping(value = "/singleCarro/{id}")
	public Carro getSingleCarro(@PathVariable long id) {

		Carro carro = carroRepo.findById(id).get();
		return carro;
	}

	@PostMapping(value = "/saveCarro")
	public String saveCarro(@RequestBody Carro carro) {
		carroRepo.save(carro);
		return "CARRO SALVO";
	}

	@PutMapping(value = "updateCarro/{id}")
	public String updateCarro(@PathVariable long id, @RequestBody Carro carro) {

		Carro updateCarro = carroRepo.findById(id).get();

		updateCarro.setMarca(carro.getMarca());
		updateCarro.setDescricao(carro.getDescricao());
		updateCarro.setModelo(carro.getModelo());
		updateCarro.setAnoFabricacao(carro.getAnoFabricacao());
		updateCarro.setAnoModelo(carro.getAnoModelo());
		updateCarro.setValor(carro.getValor());

		carroRepo.save(updateCarro);

		return "CARRO ATUALIZADO";

	}

	@DeleteMapping(value = "/deleteCarro/{id}")
	public String deleteCarro(@PathVariable long id) {
		Carro deleteCarro = carroRepo.findById(id).get();

		carroRepo.delete(deleteCarro);

		return "CARRO DELETADO ID:" + id;

	}

	@PostMapping(value = "/login")
	public ResponseEntity<Usuario> login(@RequestBody Auth auth) {
		String email = auth.getEmail();
		String senha = auth.getSenha();

		Usuario usuario = usuarioRepo.findByLoginAndSenha(email, senha);

		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
