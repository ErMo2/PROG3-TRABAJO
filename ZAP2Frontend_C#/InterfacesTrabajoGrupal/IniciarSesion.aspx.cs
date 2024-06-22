using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class IniciarSesion : System.Web.UI.Page
    {
        CuentaUsuarioWSClient cuentaDao;
        cuentaUsuario[] cuentasUsuariosAux;
        BindingList<cuentaUsuario> cuentasUsuarios;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Aquí puedes agregar lógica de inicialización si es necesaria
            }
        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            string username = txtUsername.Text.Trim();
            string password = txtPassword.Text;

            // Aquí deberías implementar la lógica para validar las credenciales
            if (ValidateUser(username, password))
            {
                // Autenticación exitosa
                
                Response.Redirect("Home.aspx");
            }
            else
            {
                // Mostrar mensaje de error si las credenciales son incorrectas
                lblErrorMessage.Text = "Nombre de usuario o contraseña incorrectos.";
            }
        }

        private bool ValidateUser(string username, string password)
        {
            // Aquí simulamos una validación básica de usuario
            // En un entorno real, verificarías las credenciales en una base de datos u otro almacenamiento seguro
            cuentaDao = new CuentaUsuarioWSClient();
            cuentasUsuariosAux = cuentaDao.listarCuentaUsuarios();
            cuentasUsuarios = new BindingList<cuentaUsuario>(cuentasUsuariosAux);
            foreach(cuentaUsuario cuenta in cuentasUsuarios) 
            {
                if(cuenta.usuario==username && cuenta.contrasena==password)
                {
                    Session["Usuario"] = cuenta;
                    return true;
                }
            }
            return false;
        }
    }
}