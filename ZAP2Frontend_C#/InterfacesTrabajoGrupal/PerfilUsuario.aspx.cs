using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class PerfilUsuario : System.Web.UI.Page
    {

        protected void Page_Load(object sender, EventArgs e)
        {
            cuentaUsuario cuenta = new cuentaUsuario();
            cuenta  = Session["Usuario"] as cuentaUsuario;
            
            lblNombreUsuario.Text = cuenta.usuario;
        }
        protected void btnCerrarSesion_Click(object sender, EventArgs e)
        {
            Response.Redirect("CerrarSesion.aspx");
        }
    }
}