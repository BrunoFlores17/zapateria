/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.modelo.dominio.Cliente;
import aplicacion.bean.LoginBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable{
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private String nombreUs;
    private String passwUs;
    private Usuario unUsuario;
    private Cliente unCliente;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
        loginBean =new LoginBean();
       unUsuario=new Usuario();
       unCliente =new Cliente();
       
    }

    public String validarUsuario(){
        String resultado=null;
        Usuario usuario = loginBean.validarUsuario(nombreUs, passwUs);
        if(usuario== null){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales invalidas", "credenciales invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Valido", "Usuario Valido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", usuario);
            resultado = "menu?faces-redirect=true";
        }
        return resultado;
    }
    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    /**
     * @return the nombreUs
     */
    public String getNombreUs() {
        return nombreUs;
    }

    /**
     * @param nombreUs the nombreUs to set
     */
    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    /**
     * @return the passwUs
     */
    public String getPasswUs() {
        return passwUs;
    }

    /**
     * @param passwUs the passwUs to set
     */
    public void setPasswUs(String passwUs) {
        this.passwUs = passwUs;
    }

    /**
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the unCliente
     */
    public Cliente getUnCliente() {
        return unCliente;
    }

    /**
     * @param unCliente the unCliente to set
     */
    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
}
