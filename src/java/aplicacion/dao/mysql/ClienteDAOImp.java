/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IClienteDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class ClienteDAOImp implements IClienteDAO {

    @Override
    public Cliente validarCliente(String nombreCliente, String password) {
       Cliente c = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       Criteria criteria = session.createCriteria(Cliente.class);
       criteria.add(Restrictions.like("nombreCliente", nombreCliente));
       criteria.add(Restrictions.like("password", password));
       criteria.add(Restrictions.eq("estado", true));
       if(!criteria.list().isEmpty()){
           c = (Cliente)criteria.list().get(0);
       }
       session.getTransaction().commit();
       session.close();
       return c;
    }

    @Override
    public Cliente obtenerCliente(String nombreCliente) {
       Cliente c = null;
       Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       Criteria criteria = session.createCriteria(Cliente.class);
       criteria.add(Restrictions.like("nombreCliente", nombreCliente));
       if(!criteria.list().isEmpty()){
           c = (Cliente)criteria.list().get(0);
       }
       session.getTransaction().commit();
       session.close();
       return c;
    }

    @Override
    public void modificar(Usuario unUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Usuario unUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuario unUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
