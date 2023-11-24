package com.projetointegrador.app.rest.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.projetointegrador.app.rest.Models.Pessoa;
import com.projetointegrador.app.rest.Models.Usuario;
import com.projetointegrador.app.rest.Repo.CarroRepository;
import com.projetointegrador.app.rest.Repo.PessoaRepository;
import com.projetointegrador.app.rest.Repo.UsuarioRepository;


@RestController
public class ApiControllers {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private CarroRepository carroRepo;
	
	@Autowired
	private PessoaRepository pessoaRepo;


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
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Integer id) {
	    Optional<Pessoa> optionalUser = pessoaRepo.findById(id);

	    if (optionalUser.isPresent()) {
	        Pessoa deletePessoa = optionalUser.get();
	        pessoaRepo.delete(deletePessoa);
	        
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", "USUARIO DELETADO ID: " + id);
	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}



	@GetMapping(value = "/carros")
	public List<Carro> getCarros() {
		return carroRepo.findAll();
	}

	@GetMapping(value = "/singleCarro/{id}")
	public Carro getSingleCarro(@PathVariable Integer id) {

		Carro carro = carroRepo.findById(id).get();
		return carro;
	}

	@PostMapping(value = "/saveCarro")
	public ResponseEntity<Carro> saveCarro(@RequestBody Carro carro) {
		
		
	Carro novoCarro = carroRepo.save(carro);
	
	Carro carroSalvo = carroRepo.findById(novoCarro.getId()).orElse(null);
	
	if(carroSalvo != null) {
		return ResponseEntity.ok(carroSalvo);
	} else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	}
	

	@PutMapping(value = "updateCarro/{id}")
	public ResponseEntity<Carro> updateCarro(@PathVariable Integer id, @RequestBody Carro carro) {
	    Optional<Carro> optionalCarro = carroRepo.findById(id);

	    if (optionalCarro.isPresent()) {
	        Carro updateCarro = optionalCarro.get();
	        
	        updateCarro.setMarca(carro.getMarca());
	        updateCarro.setDescricao(carro.getDescricao());
	        updateCarro.setModelo(carro.getModelo());
	        updateCarro.setAnoFabricacao(carro.getAnoFabricacao());
	        updateCarro.setAnoModelo(carro.getAnoModelo());
	        updateCarro.setValor(carro.getValor());

	        Carro carroAtualizado = carroRepo.save(updateCarro);

	        return ResponseEntity.ok(carroAtualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	@DeleteMapping(value = "/deleteCarro/{id}")
	public ResponseEntity<Map<String, Object>> deleteCarro(@PathVariable Integer id) {
	    Optional<Carro> optionalCarro = carroRepo.findById(id);

	    if (optionalCarro.isPresent()) {
	        Carro deleteCarro = optionalCarro.get();
	        carroRepo.delete(deleteCarro);
	        
	        Map<String, Object> response = new HashMap<>();
	        response.put("message", "CARRO DELETADO ID: " + id);
	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
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
	
	@PostMapping(value = "/criarPessoa")
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
	    Pessoa novaPessoa = pessoaRepo.save(pessoa);
	    
	    Pessoa pessoaSalva = pessoaRepo.findById(novaPessoa.getId()).orElse(null);

	    if (pessoaSalva != null) {
	        return ResponseEntity.ok(pessoaSalva);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@GetMapping(value = "/pessoas")
	public List<Pessoa> getAllPessoas() {
		return pessoaRepo.findAll();
	}
	
	@PutMapping(value = "/atualizarPessoa/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable int id, @RequestBody Pessoa pessoaDados) {
	    Optional<Pessoa> optionalPessoa = pessoaRepo.findById(id);

	    if (optionalPessoa.isPresent()) {
	        Pessoa pessoaExistente = optionalPessoa.get();


	        pessoaExistente.setNome(pessoaDados.getNome());
	        pessoaExistente.setEmail(pessoaDados.getEmail());
	        pessoaExistente.setTelefone(pessoaDados.getTelefone());
	        pessoaExistente.setDataNasc(pessoaDados.getDataNasc());
	        pessoaExistente.setCpf(pessoaDados.getCpf());
	        pessoaExistente.setSituacao(pessoaDados.getSituacao());
	        pessoaExistente.setDataInclusao(pessoaDados.getDataInclusao());
	        pessoaExistente.setPerfil(pessoaDados.getPerfil());

	        Pessoa pessoaAtualizada = pessoaRepo.save(pessoaExistente);

	        return ResponseEntity.ok(pessoaAtualizada);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	}
