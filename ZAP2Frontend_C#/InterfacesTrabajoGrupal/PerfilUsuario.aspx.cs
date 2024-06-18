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
        ClienteWSClient clienteDao;
        cliente cli;
        protected void Page_Load(object sender, EventArgs e)
        {
            clienteDao = new ClienteWSClient();
            cuentaUsuario cuenta = new cuentaUsuario();
            cuenta  = Session["Usuario"] as cuentaUsuario;
            cli = clienteDao.buscarPersonaNatural(cuenta.personaNatural.id_Persona);
            lblNombreUsuario.Text = cuenta.usuario;
            lblTipoDocumento.Text = cli.tipo_documento.ToString();
            lblNumeroDocumento.Text = cli.nro_documento.ToString();
            lblNombreReal.Text = cli.nombre;
            lblApellidos.Text = cli.apellido_paterno +" "+ cli.apellido_materno;
            lblSexo.Text = cli.sexo.ToString();
            lblEmail.Text = cli.email;
            lblTelefono.Text = cli.telefono.ToString();
        }
        protected void btnCerrarSesion_Click(object sender, EventArgs e)
        {
            Response.Redirect("CerrarSesion.aspx");
        }
    }
}