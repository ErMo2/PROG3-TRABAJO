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
                BindGridView();
            }
        }

        private void BindGridView()
        {
           daoCliente = new ClienteWSClient();
           cliente[] arregloClientes = daoCliente.listarClientes();
            if (arregloClientes != null)
            {
                listaClientes = new BindingList<cliente>(arregloClientes);
                gvClientes.DataSource = listaClientes;
                gvClientes.DataBind();
                ViewState["Clientes"] = listaClientes; // Guardar en ViewState
            }
        }

        protected void gvClientes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvClientes.PageIndex = e.NewPageIndex;
            BindGridView();
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
            int idCliente = int.Parse(btn.CommandArgument);
            BindingList<cliente> clientes = ViewState["Clientes"] as BindingList<cliente>;
            if (clientes != null)
            {
                cliente clienteSeleccionado = clientes.SingleOrDefault(c => c.id_cliente == idCliente);
                if (clienteSeleccionado != null)
                {
                    Response.Redirect("GestionarClientes.aspx?id=" + idCliente);
                }
            }
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int idCliente = int.Parse(btn.CommandArgument);
            BindingList<cliente> clientes = ViewState["Clientes"] as BindingList<cliente>;
            if (clientes != null)
            {
                cliente clienteSeleccionado = clientes.SingleOrDefault(c => c.id_cliente == idCliente);
                if (clienteSeleccionado != null)
                {
                    daoCliente = new ClienteWSClient();
                    daoCliente.eliminarCliente(idCliente);
                    BindGridView(); // Refrescar el GridView después de la eliminación
                }
            }
        }

        protected void btnVer_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int idCliente = int.Parse(btn.CommandArgument);
            BindingList<cliente> clientes = ViewState["Clientes"] as BindingList<cliente>;
            if (clientes != null)
            {
                cliente clienteSeleccionado = clientes.SingleOrDefault(c => c.id_cliente == idCliente);
                if (clienteSeleccionado != null)
                {
                    lblDetallesCliente.Text = $"<strong>Nombre:</strong> {clienteSeleccionado.nombre}<br/>" +
                                              $"<strong>Apellido Paterno:</strong> {clienteSeleccionado.apellido_paterno}<br/>" +
                                              $"<strong>Apellido Materno:</strong> {clienteSeleccionado.apellido_materno}<br/>" +
                                              $"<strong>Teléfono:</strong> {clienteSeleccionado.telefono}<br/>" +
                                              $"<strong>Email:</strong> {clienteSeleccionado.email}<br/>" +
                                              $"<strong>Dirección:</strong> {clienteSeleccionado.direccion}<br/>" +
                                              $"<strong>Sexo:</strong> {clienteSeleccionado.sexo}<br/>" +
                                               $"<strong>Tipo de Documento:</strong> {clienteSeleccionado.tipo_documento}<br/>" +
                                               $"<strong>Numero de Documento:</strong> {clienteSeleccionado.dni}<br/>";
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verClienteModal').modal('show');", true);
                }
            }
        }
    }
}