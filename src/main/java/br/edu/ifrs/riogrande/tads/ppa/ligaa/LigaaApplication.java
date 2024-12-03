package br.edu.ifrs.riogrande.tads.ppa.ligaa;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoJpaRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class LigaaApplication {

	@Autowired
	private AlunoJpaRepository alunoJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LigaaApplication.class, args); 
	}

	@PostConstruct
	void seed() {
		System.out.println("Semeando ... a discórdia!");
		var can = new Aluno();
        can.setCpf("11122233344");
        can.setDataHoraCriacao(LocalDateTime.now());
        can.setDataHoraAlteracao(LocalDateTime.now());
        can.setDesativado(false);
        can.setEnderecoEletronico("can.robert@gmail.com");
		can.setLogin(can.getEnderecoEletronico());
        can.setNome("Canrobert Junior");
        can.setId(UUID.randomUUID());

		alunoJpaRepository.save(can); // yes you can!
	}

}
