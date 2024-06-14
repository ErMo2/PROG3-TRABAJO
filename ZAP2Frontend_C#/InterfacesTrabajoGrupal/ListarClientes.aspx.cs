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
    public partial class ListarClientes : System.Web.UI.Page
    {
        private ClienteWSClient daoCliente;
        private BindingList<cliente> listaClientes;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDatos();
            }
        }

        private void CargarDatos()
        {
            daoCliente = new ClienteWSClient();
            cliente[] arregloClientes = daoCliente.listarClientes();
            if (arregloClientes != null)
                listaClientes = new BindingList<cliente>(arregloClientes);

            gvClientes.DataSource = listaClientes;
            gvClientes.DataBind();
        }
        protected void gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvClientes.PageIndex = e.NewPageIndex;
            CargarDatos();
        }
        private void BindGridView()
        {
            daoCliente = new ClienteWSClient();
            cliente[] listaClientes = daoCliente.listarClientes();
            if (listaClientes != null)
            {
                BindingList<cliente>clientes = new BindingList<cliente>(listaClientes);
                gvClientes.DataSource = clientes;
                gvClientes.DataBind();
                ViewState["Clientes"] = clientes; // Guardar en ViewState
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }
        protected void lbRegistrarCliente_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarClientes.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarClientes.aspx");
        }
        protected void btnModificar_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            BindingList<cliente> clientes = ViewState["Clientes"] as BindingList<cliente>;
            int idCliente = clientes[index].id_cliente;
            Response.Redirect("ModificarCliente.aspx?id=" + idCliente);
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            BindingList<cliente> clientes = ViewState["Clientes"] as BindingList<cliente>;
            int idCliente = clientes[index].id_cliente;
            daoCliente = new ClienteWSClient();
            daoCliente.eliminarCliente(idCliente);
            BindGridView(); // Refresh the GridView after deletion
        }

        protected void btnVer_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            BindingList<cliente> clientes = ViewState["Clientes"] as BindingList<cliente>;
            cliente clienteSeleccionado = clientes[index];

            if (clienteSeleccionado != null)
            {
                lblDetallesCliente.Text = $"<strong>Nombre:</strong> {clienteSeleccionado.nombre}<br/>" +
                                          $"<strong>Apellido Paterno:</strong> {clienteSeleccionado.apellido_paterno}<br/>" +
                                          $"<strong>Apellido Materno:</strong> {clienteSeleccionado.apellido_materno}<br/>" +
                                          $"<strong>Teléfono:</strong> {clienteSeleccionado.telefono}<br/>" +
                                          $"<strong>Email:</strong> {clienteSeleccionado.email}<br/>" +
                                          $"<strong>Dirección:</strong> {clienteSeleccionado.direccion}<br/>";
            }
            ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verClienteModal').modal('show');", true);
        }
    }
}