package com.trabajadores.login;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trabajadores.sesion.TCredenciales;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.trabajadores.DBmanager.DBmanager;
@CrossOrigin("http://localhost:8081/")
@Controller
public class LoginController {

    TCredenciales tokenMap = TCredenciales.Instance();

    // @Autowired
    // private UsuarioRepositoryCustom userRepository; // Repositorio que extiende de JpaRepository

    //private FirebirdDatabaseConnection conexion;

    private DBmanager DBmanager = new DBmanager();

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response,
            @RequestBody LoginDto loginDto) {

        String[] valoresDB = DBmanager.login(loginDto.getIdUsuario());

        if (valoresDB[0] != null && valoresDB[1].equals(loginDto.getClave())) {
            String uuid = TCredenciales.login(valoresDB[0], valoresDB[1]);
            System.out.println(uuid);

            response.addHeader("token", uuid);

            return ResponseEntity.ok("Autenticación exitosa");
        } else {
            // autenticación fallida
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @GetMapping("/loginCheck")
    public ResponseEntity<String> pruebaLogin(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        response.addHeader("token", token);

        System.out.println("-----------Check del headeeeeeeeeeer----------------");

        System.out.println(token);

        if (TCredenciales.isLogged(token)) {

            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logOut(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        TCredenciales.logOut(token);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}