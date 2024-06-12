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
    public partial class GestionPedidos : System.Web.UI.Page
    {
        private PedidoWSClient pedidoDao;
        private BindingList<pedido> listaPedidos;
        private pedido pedido;
        protected void Page_Load(object sender, EventArgs e)
        {
            pedidoDao= new PedidoWSClient();
            pedido[] arregloPedidos=pedidoDao.listarPedidos();
            if (arregloPedidos != null)
                listaPedidos = new BindingList<pedido>(arregloPedidos);
            
            gvPedidos.DataSource = listaPedidos;
            gvPedidos.DataBind();
        }
        protected void lbRegistrarPedido_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarPedido.aspx");
        }
        protected void gvPedidos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvPedidos.PageIndex = e.NewPageIndex;
            // Recarga tus datos aquí para refrescar el GridView
        }

    }
}