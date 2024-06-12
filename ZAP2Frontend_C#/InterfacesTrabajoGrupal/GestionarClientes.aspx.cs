using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarClientes : System.Web.UI.Page
    {
        private ClienteWSClient daoCliente;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Código para inicializar la página si es necesario
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarClientes.aspx");
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            daoCliente = new ClienteWSClient();
            cliente nuevoCliente = new cliente();

            nuevoCliente.nombre = txtNombre.Text;
            nuevoCliente.apellido_paterno = txtApellidoPaterno.Text;
            nuevoCliente.apellido_materno = txtApellidoMaterno.Text;
            nuevoCliente.telefono =int.Parse(txtTelefono.Text);
            nuevoCliente.email = txtEmail.Text;
            if (ddlTipoDocumento.SelectedValue == "DNI")
                nuevoCliente.tipo_documento = tipoDocumento.DNI;
            else nuevoCliente.tipo_documento = tipoDocumento.CARNET_EXTRANJERIA;
            nuevoCliente.dni = txtDNI.Text;
            nuevoCliente.nro_documento = int.Parse(txtNumeroDocumento.Text);
            nuevoCliente.sexo=ddlGenero.SelectedValue=="M"?'M':'F';
            nuevoCliente.direccion = txtDireccion.Text;
            
            nuevoCliente.activo = 1;
            nuevoCliente.tipo_documentoSpecified = true;
            
            nuevoCliente.id_Persona=daoCliente.insertarCliente(nuevoCliente);
            Response.Redirect("ListarClientes.aspx");
        }
    }
}