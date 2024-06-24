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
        private ReportesFrontWSClient  daoReporte;
        private sucursal sucursal;
        private almacen almacen;
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
            if (arregloLotes != null)
            {
                lotes = new BindingList<lote>(arregloLotes);
                foreach(lote lot in lotes)
                {
                    almacen = daoAlmacen.buscarAlmacen(lot.almacen.id_almacen);
                    sucursal = daoSucursal.buscarSucursal(almacen.sucursal.id_sucursal);
                    lot.almacen = almacen;
                    lot.almacen.sucursal = sucursal;
                }
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
            if (e.CommandName == "ModificarLote")
            {
                Response.Redirect($"GestionarLotes.aspx?id={idLote}");
            }
            if (e.CommandName == "Eliminar")
            {
                daoLotes.eliminarLote(idLote);
                CargarLotes();
            }
        }

        protected void lbRegistrarLote_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarLotes.aspx");
        }
        protected void btnOption1_Click(object sender, EventArgs e)
        {
            // Lógica para Opción 1
            // Ejemplo: Mostrar un mensaje
            daoReporte = new ReportesFrontWSClient();
            String reporte = daoReporte.generarReporteProductosConsumidosYmandarPorCorreo("a20190315@pucp.edu.pe");
           
            ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('reporte');", true);

        }

        protected void btnOption2_Click(object sender, EventArgs e)
        {
            // Lógica para Opción 2
            // Ejemplo: Mostrar un mensaje
            ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Opción 2 seleccionada');", true);
        }
    }
}