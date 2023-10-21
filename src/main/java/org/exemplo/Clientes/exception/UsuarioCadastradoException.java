package org.exemplo.Clientes.exception;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException (String login) {
        super("Usúario: '"+login+"' já cadastrado!");
    }
}
