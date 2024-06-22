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
            Response.Redirect("GestionarBoletaVenta.aspx");
        }

        protected void lbRegistrarFacturaDeVenta_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarFacturaVenta.aspx");
        }

        protected void btnVerBoleta_Click(object sender, EventArgs e)
        {
            daoBoletaDeVenta = new Boleta_VentaWSClient();
            boletaVenta[] arregloBoletas = daoBoletaDeVenta.listarBoletaVentaTodos();
            if (arregloBoletas != null)
                listaBoletasDeVenta = new BindingList<boletaVenta>(arregloBoletas);

            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            boletaVenta boleta = listaBoletasDeVenta[index];

            if (boleta != null)
            {
                lblDetallesBoleta.Text = $"<strong>Id Documento:</strong> {boleta.id_documento}<br/>" +
                                         $"<strong>Fecha de Emisión:</strong> {boleta.fecha_emision}<br/>" +
                                         $"<strong>Monto Total:</strong> {boleta.montoTotal}<br/>" +
                                         $"<strong>Moneda:</strong> {boleta.moneda}<br/>" +
                                         $"<strong>Detalles:</strong> {boleta.detalles}<br/>" +
                                         $"<strong>Empleado:</strong> {boleta.empleado.nombre + boleta.empleado.apellido_paterno}<br/>" +
                                         $"<strong>Tarjeta:</strong> {boleta.tarjeta}<br/>";
                                        // $"<strong>Líneas Doc Venta:</strong> {boleta.lineasDocVenta}<br/>";
            }
            ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verBoletaModal').modal('show');", true);
        }

        protected void btnVerFactura_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            facturaVenta factura = listaFacturasDeVenta[index];

            if (factura != null)
            {
                lblDetallesFactura.Text = $"<strong>Id Documento:</strong> {factura.id_documento}<br/>" +
                                          $"<strong>Fecha de Emisión:</strong> {factura.fecha_emision}<br/>" +
                                          $"<strong>Monto Total:</strong> {factura.montoTotal}<br/>" +
                                          $"<strong>Moneda:</strong> {factura.moneda}<br/>" +
                                          $"<strong>Detalles:</strong> {factura.detalles}<br/>" +
                                          $"<strong>Empleado:</strong> {factura.empleado}<br/>" +
                                          $"<strong>Tarjeta:</strong> {factura.tarjeta}<br/>" +
                                          $"<strong>Líneas Doc Venta:</strong> {factura.lineasDocVenta}<br/>";
            }
            ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verFacturaModal').modal('show');", true);
        }
    }
}

