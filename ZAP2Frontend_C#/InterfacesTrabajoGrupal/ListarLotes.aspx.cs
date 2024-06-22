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
    public partial class ListarLotes : System.Web.UI.Page
    {
        private LoteWSClient daoLotes;
        private BindingList<lote> lotes;
        private AlmacenWSClient daoAlmacen;
        private SucursalWSClient daoSucursal;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarLotes();
            }
        }

        private void CargarLotes()
        {
            daoLotes = new LoteWSClient();
            daoAlmacen = new AlmacenWSClient(); 
            daoSucursal = new SucursalWSClient();
            lote[] arregloLotes = daoLotes.listarLote();
            almacen alma;
            sucursal sucur;
            if (arregloLotes != null)
            {
                lotes = new BindingList<lote>(arregloLotes);
                //foreach(lote lote in lotes)
                //{
                //    alma = daoAlmacen.
                //    alma = daoAlmacen.buscarAlmacen(lote.almacen.id_almacen);
                //    sucur=daoSucursal.buscarSucursal(alma.sucursal.id_sucursal);
                //    lote.almacen.sucursal = new sucursal();
                //    lote.almacen.sucursal.nombre = sucur.nombre;
                //    lote.almacen.sucursal.
                //}
                gvLotes.DataSource = lotes;
                gvLotes.DataBind();
            }
        }

        protected void gvLotes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvLotes.PageIndex = e.NewPageIndex;
            CargarLotes();
        }

        protected void gvLotes_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            daoLotes = new LoteWSClient();
            int idLote = Convert.ToInt32(e.CommandArgument);
            if(e.CommandName == "Eliminar")
            {
                daoLotes.eliminarLote(idLote);
                CargarLotes();
            }
        }

        protected void lbRegistrarLote_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarLotes.aspx");
        }
    }
}