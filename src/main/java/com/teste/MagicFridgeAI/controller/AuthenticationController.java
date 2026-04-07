package com.teste.MagicFridgeAI.controller;

import com.teste.MagicFridgeAI.model.user.LoginDTO;
import com.teste.MagicFridgeAI.model.user.RegisterDTO;
import com.teste.MagicFridgeAI.model.user.TokenDTO;
import com.teste.MagicFridgeAI.repository.UserRepository;
import com.teste.MagicFridgeAI.service.user.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.MagicFridgeAI.model.user.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/cadastro")
    public ResponseEntity cadastrarUser(@RequestBody @Valid RegisterDTO dados){
        if(this.userRepository.findByLogin(dados.login()) != null)
            return ResponseEntity.badRequest().build();
        String senhaCriptografada = new BCryptPasswordEncoder().encode(dados.password());
        User novoUser = new User(dados.login(), senhaCriptografada, dados.role());
        userRepository.save(novoUser);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO dados){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var authentication = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(token));
    }

}
