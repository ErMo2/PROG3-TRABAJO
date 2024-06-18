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
    public partial class ListarPedidos : System.Web.UI.Page
    {
        private PedidoWSClient daoPedido;
        private pedido pedido;
        private BindingList<pedido> pedidos;
        protected void Page_Load(object sender, EventArgs e)
        {
            daoPedido = new PedidoWSClient();

            pedido[] arregloPedidos = daoPedido.listarPedidos();//Creo un arreglo genérico para resibir un ArrayList<> de JAVA

            if (arregloPedidos != null)
                pedidos = new BindingList<pedido>(arregloPedidos);

            gvPedidos.DataSource = pedidos;
            gvPedidos.DataBind();
        }

        protected void lbRegistrarPedido_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarPedido.aspx");
        }

        protected void btnVer_Click(object sender, EventArgs e)
        {
            int idPedido = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idPedido"] = idPedido;
            Response.Redirect("GestionarPedido.aspx?accion=ver");
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            int idPedido = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoPedido.eliminarPedido(idPedido);
            Response.Redirect("ListarPedidos.aspx");
        }

        protected void gvPedidos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvPedidos.PageIndex = e.NewPageIndex;
            gvPedidos.DataBind();
        }
    }
}