/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class LoginBean {
     private Usuario usuario;
    private IUsuarioDAO usuarioDao;

    public LoginBean() {
        usuarioDao=new UsuarioDAOImp();
        usuario =new Usuario();
    }
    public Usuario validarUsuario(String nombreUs,String passwUs){
        return getUsuarioDao().validarUsuario(nombreUs, passwUs);}

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioDao
     */
    public IUsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    /**
     * @param usuarioDao the usuarioDao to set
     */
    public void setUsuarioDao(IUsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    /**
     * Creates a new instance of LoginBean
     */
    
}
