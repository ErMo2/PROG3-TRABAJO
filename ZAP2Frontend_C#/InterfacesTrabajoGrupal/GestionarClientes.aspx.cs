using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarClientes : System.Web.UI.Page
    {
        private ClienteWSClient daoCliente;
        private BindingList<cliente> listaClientes;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                daoCliente = new ClienteWSClient();

                if (Session["id"] != null)
                {
                    int idCliente = (int)Session["id"];
                    CargarDatosCliente(idCliente);
                }
            }
        }

        private void CargarDatosCliente(int idCliente)
        {
            cliente[] arregloClientes = daoCliente.listarClientes(); // Método para obtener la lista de clientes
            if (arregloClientes != null)
                listaClientes = new BindingList<cliente>(arregloClientes);

            cliente cliente = listaClientes.SingleOrDefault(c => c.id_cliente == idCliente);
            if (cliente != null)
            {
                // Asigna los valores del cliente a los controles
                txtIdCliente.Text = cliente.id_cliente.ToString();
                txtNombre.Text = cliente.nombre;
                txtApellidoPaterno.Text = cliente.apellido_paterno;
                txtApellidoMaterno.Text = cliente.apellido_materno;
                txtTelefono.Text = cliente.telefono.ToString();
                txtEmail.Text = cliente.email;
                ddlTipoDocumento.SelectedValue = cliente.tipo_documento.ToString();
                txtNumeroDocumento.Text = cliente.nro_documento.ToString();
                ddlGenero.SelectedValue = cliente.sexo.ToString();
                txtDireccion.Text = cliente.direccion;
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            daoCliente = new ClienteWSClient();
            cliente cliente = new cliente();

            cliente.nombre = txtNombre.Text;
            cliente.apellido_paterno = txtApellidoPaterno.Text;
            cliente.apellido_materno = txtApellidoMaterno.Text;
            cliente.telefono=int.Parse(txtTelefono.Text);
            cliente.email = txtEmail.Text;
            cliente.tipo_documento = ddlTipoDocumento.SelectedValue == "DNI" ? tipoDocumento.DNI : tipoDocumento.CARNET_EXTRANJERIA;
            cliente.nro_documento = int.Parse(txtNumeroDocumento.Text);
            cliente.sexo = ddlGenero.SelectedValue == "M" ? 'M' : 'F';
            cliente.direccion = txtDireccion.Text;
            cliente.activo = 1;
            cliente.tipo_documentoSpecified = true;
            cliente.dni = "0";
            if (Session["id"] != null)
            {
                // Modificar el cliente existente
                cliente.id_Persona = int.Parse(txtIdCliente.Text);
                daoCliente.modificarCliente(cliente); // Método para modificar cliente
            }
            else
            {
                // Insertar un nuevo cliente
                cliente.id_cliente = daoCliente.insertarCliente(cliente);
            }

            // Redireccionar a la página de listado
            Response.Redirect("ListarClientes.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarClientes.aspx");
        }
    }
}