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
    public partial class GestionarPedido : System.Web.UI.Page
    {
        //private ProductoWSClient daoProducto;
        //private OrdenVentaWSClient daoOrdenVenta;
        //private LineaOrdenVentaWSClient daoLineaOrdenVenta;

        private BindingList<producto> productos;
        private pedido pedido;
        private BindingList<detallePedido> detallesPedido;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                TextFechaPedido.Text = DateTime.Now.ToString("yyyy-MM-dd");
            }
        }

        protected void gvDetallePedido_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            
        }

        protected void btnBuscarProducto_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormProducto() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }
        protected void lbAgregarDetPed_Click(object sender, EventArgs e)
        {

        }
        protected void btnEliminarProducto_Click(object sender, EventArgs e)
        {

        }
        protected void btnGuardar_Click(object sender, EventArgs e)
        {

        }
        protected void lbBusquedaProductoModal_Click(object sender, EventArgs e)
        {

        }

        protected void gvProductos_RowDataBound(object sender, GridViewRowEventArgs e)
        {

        }

        protected void btnSeleccionarProductoModal_Click(object sender, EventArgs e)
        {

        }
    }
}