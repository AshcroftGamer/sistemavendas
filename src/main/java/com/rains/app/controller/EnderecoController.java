package com.rains.app.controller;


import com.rains.app.model.EnderecoModel;
import com.rains.app.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EnderecoController {

    @Autowired
    public EnderecoRepository repository;

    @PostMapping("/api/salvar")
    public EnderecoModel salvar( @RequestBody EnderecoModel endereco) {
        return repository.save(endereco);
    }

    @GetMapping("/api/listar")
    List<EnderecoModel> todos(){
        return repository.findAll();
    }
    @GetMapping("/api/listar/{id}")
    Optional<EnderecoModel> buscar(@PathVariable Long id){
        return repository.findById(id);
    }

    @DeleteMapping("/api/remover/{id}")
    void remover(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/api/update/{id}")
    Optional<EnderecoModel> update(@RequestBody EnderecoModel endereco, @PathVariable Long id){
        return Optional.of(repository.findById(id)
                .map(data -> {
                    data.setRua(endereco.getRua());
                    data.setNumero(endereco.getNumero());
                    data.setBairro(endereco.getBairro());
                    data.setCidade(endereco.getCidade());
                    data.setEstado(endereco.getEstado());
                    return repository.save(data);
                }).orElseGet(() -> {
                    endereco.setId(id);
                    return repository.save(endereco);
                })
        );
    }

    @PatchMapping("/api/update/rua/{id}")
    Optional<EnderecoModel> updateRua(@RequestBody EnderecoModel nomeRua, @PathVariable Long id){
        return Optional.of(repository.findById(id)
                .map(data ->{
                    data.setRua(nomeRua.getRua());
                    return repository.save(data);
                }).orElseGet(()->{
                    nomeRua.setId(id);
                    return repository.save(nomeRua);
                })
        );
    }



}
