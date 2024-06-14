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
    public partial class ListarDocumentoDeVenta : System.Web.UI.Page
    {
        private Boleta_VentaWSClient daoBoletaDeVenta;
        private BindingList<boletaVenta> listaBoletasDeVenta;
        private Factura_VentaWSClient daoFacturaVenta;
        private BindingList<facturaVenta> listaFacturasDeVenta;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDatos();
            }
        }

        private void CargarDatos()
        {
            // Cargar Boletas de Venta
            daoBoletaDeVenta = new Boleta_VentaWSClient();
            boletaVenta[] arregloBoletas = daoBoletaDeVenta.listarBoletaVentaTodos();
            if (arregloBoletas != null)
                listaBoletasDeVenta = new BindingList<boletaVenta>(arregloBoletas);

            gvBoletasDeVenta.DataSource = listaBoletasDeVenta;
            gvBoletasDeVenta.DataBind();
           
            // Cargar Facturas de Venta
            daoFacturaVenta = new Factura_VentaWSClient();
            facturaVenta[] arregloFacturas = daoFacturaVenta.listarFacturaVenta();
            if (arregloFacturas != null)
                listaFacturasDeVenta = new BindingList<facturaVenta>(arregloFacturas);
            gvFacturasDeVenta.DataSource = listaFacturasDeVenta;
            gvFacturasDeVenta.DataBind();
        }

        protected void gvBoletasDeVenta_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvBoletasDeVenta.PageIndex = e.NewPageIndex;
            CargarDatos();
        }

        protected void gvFacturasDeVenta_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvFacturasDeVenta.PageIndex = e.NewPageIndex;
            CargarDatos();
        }

        protected void lbRegistrarBoletaDeVenta_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarBoletaDeVenta.aspx");
        }

        protected void lbRegistrarFacturaDeVenta_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarFacturaDeVenta.aspx");
        }
    }
}

