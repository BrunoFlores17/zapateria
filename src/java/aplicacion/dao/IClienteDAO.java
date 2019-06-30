/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;

/**
 *
 * @author Bruno
 */
public interface IClienteDAO {
    Cliente validarCliente(String nombreUsuario, String password);
       
       Cliente obtenerCliente(String nombreUsuario);
       
       void modificar(Usuario unUsuario);
       void agregar (Usuario unUsuario);
       void eliminar (Usuario unUsuario);
       List<Usuario> listarUsuarios();
    
    
}
