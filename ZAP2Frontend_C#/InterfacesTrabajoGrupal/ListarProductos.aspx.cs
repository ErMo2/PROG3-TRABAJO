using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionProducto : System.Web.UI.Page
    {
        private ProductoPerecibleWSClient daoProdPerecible;
        private ProductosParaElCuidadoPersonalYDelHogarWSClient daoProdCuiHog;
        private ElectrodomesticosWSClient daoElectrodomestico;
        private RopaWSClient daoRopa;

        private BindingList<productoPerecible> listaProdPerecibles;
        private BindingList<productosParaElCuidadoPersonalYDelHogar> listaProdCuiHog;
        private BindingList<electrodomesticos> listaElectrodomesticos;
        private BindingList<ropa> listaRopa;

        private ReportesFrontWSClient daoReportesFrontWSClient;

        private BindingList<productoPerecible> productosPerecibles;
        private BindingList<Electrodomestico> electrodomesticos;
        private BindingList<productosParaElCuidadoPersonalYDelHogar> productosCuiPerYHogar;
        private BindingList<ropa> productosRopa;
        protected void Page_Load(object sender, EventArgs e)
        {
            daoProdPerecible = new ProductoPerecibleWSClient();
            daoProdCuiHog = new ProductosParaElCuidadoPersonalYDelHogarWSClient();
            daoElectrodomestico = new ElectrodomesticosWSClient();
            daoRopa = new RopaWSClient();
            
                

                ropa[] ropaArreglo = daoRopa.listarRopa();
                electrodomesticos[] electrodomesticosArreglo = daoElectrodomestico.listarElectrodomesticos();
                productosParaElCuidadoPersonalYDelHogar[] prodCuiHogArreglo = daoProdCuiHog.listarPCH();
                productoPerecible[] prodPerecibleArreglo = daoProdPerecible.listarProductoPerecible();

                if (ropaArreglo != null)
                    listaRopa = new BindingList<ropa>(ropaArreglo);

                if (electrodomesticosArreglo != null)
                    listaElectrodomesticos = new BindingList<electrodomesticos>(electrodomesticosArreglo);

                if (prodCuiHogArreglo != null)
                    listaProdCuiHog = new BindingList<productosParaElCuidadoPersonalYDelHogar>(prodCuiHogArreglo);

                if (prodPerecibleArreglo != null)
                    listaProdPerecibles = new BindingList<productoPerecible>(prodPerecibleArreglo);

                gvElectrodomesticos.DataSource = listaElectrodomesticos;
                gvLimpiezayHogar.DataSource = listaProdCuiHog;
                gvProductosPerecibles.DataSource = listaProdPerecibles;
                gvRopa.DataSource = listaRopa;

                gvElectrodomesticos.DataBind();
                gvLimpiezayHogar.DataBind();
                gvProductosPerecibles.DataBind();
                gvRopa.DataBind();
            
            
        }
        

        protected void lbRegistrarProducto_Click(object sender, EventArgs e)
        {
            Response.Redirect("SeleccionarTipoDeProducto.aspx");
        }

        protected void gvElectrodomesticos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvElectrodomesticos.PageIndex = e.NewPageIndex;
            gvElectrodomesticos.DataBind();
        }

        protected void gvLimpieza_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvLimpiezayHogar.PageIndex = e.NewPageIndex;
            gvLimpiezayHogar.DataBind();
        }

        protected void gvRopa_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvRopa.PageIndex = e.NewPageIndex;
            gvRopa.DataSource = listaRopa;
            gvRopa.DataBind();
        }

        protected void gvProductosPerecibles_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvProductosPerecibles.PageIndex = e.NewPageIndex;
            gvProductosPerecibles.DataBind();
        }

        protected void EditProductPerecible_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idPerecible"] = idProducto;
            Response.Redirect($"GestionarProdPerecible.aspx?idPerecible={idProducto}");
        }

        protected void DeleteProductPerecible_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoProdPerecible.eliminarProductoPerecible(idProducto);
            Response.Redirect("ListarProductos.aspx");
        }

        protected void VerProductPerecible_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idPerecibleVisualizar"] = idProducto;
            Response.Redirect($"VerProductosPerecibles.aspx?idPerecibleVisualizar={idProducto}");
        }

        protected void EditProductElectrodomestico_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idElectrodomestico"] = idProducto;
            Response.Redirect($"GestionarElectrodomestico.aspx?idElectrodomestico={idProducto}");

        }

        protected void DeleteProductElectrodomestico_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoElectrodomestico.eliminarElectrodomestico(idProducto);
            Response.Redirect("ListarProductos.aspx");
            //CargarDatos();
        }

        protected void VerProductElectrodomestico_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idElectrodomesticoVisualizar"] = idProducto;
            Response.Redirect($"VerElectrodomesticos.aspx?idElectrodomesticoVisualizar={idProducto}");
        }

        protected void EditProductLimpiezaHogar_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idHigiene"] = idProducto;
            Response.Redirect($"GestionarProductoPersonalYHogar.aspx?idHigiene={idProducto}");
        }

        protected void DeleteProductLimpiezaHogar_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoProdCuiHog.eliminarPCH(idProducto);
            Response.Redirect("ListarProductos.aspx");
            //CargarDatos();
        }

        protected void VerProductLimpiezaHogar_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idHigieneVisualizar"] = idProducto;
            Response.Redirect($"VerProductoPersonalYHogar.aspx?idHigieneVisualizar={idProducto}");
        }

        protected void EditProductRopa_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idRopa"] = idProducto;
            Response.Redirect($"GestionarRopa.aspx?idRopa={idProducto}");
        }

        protected void DeleteProductRopa_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoRopa.eliminarRopa(idProducto);
            Response.Redirect("ListarProductos.aspx");
        }

        protected void VerProductRopa_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idRopaVisualizar"] = idProducto;
            Response.Redirect($"VerRopa.aspx?idRopaVisualizar={idProducto}");
        }
        protected void lbimprimirReporte_Click(object sender, EventArgs e)
        {
            daoReportesFrontWSClient = new ReportesFrontWSClient();
            byte[] reporte = daoReportesFrontWSClient.generarReporteProductosConsumidos();
            if (reporte != null && reporte.Length > 0)
            {
                Response.Clear();
                Response.ContentType = "application/pdf";
                Response.AddHeader("Content-Disposition", "inline; filename=ReporteMasVendidos.pdf");
                Response.BinaryWrite(reporte);
                Response.End();
            }
            
        }

        protected void lbBusquedaProdPerecible_Click(object sender, EventArgs e)
        {
            productoPerecible[] productosPerecibleArr = daoProdPerecible.listarProductosXnombre(txtNombreProdPerecible.Text);
            if (productosPerecibleArr != null)
            {
                productosPerecibles = new BindingList<productoPerecible>(productosPerecibleArr);
                gvProductosPerecibles.DataSource = productosPerecibles;
                gvProductosPerecibles.DataBind();
            }
        }

        protected void lbBusquedaElectrodomestico_Click(object sender, EventArgs e)
        {
            Electrodomestico[] ElectrodomesticosArr = daoElectrodomestico.listarProductosXnombre(txtNombreElectrodomestico.Text);
            if (ElectrodomesticosArr != null)
            {
                electrodomesticos = new BindingList<Electrodomestico>(ElectrodomesticosArr);
                gvElectrodomesticos.DataSource = electrodomesticos;
                gvElectrodomesticos.DataBind();
            }
        }

        protected void lbBusquedaProdLimpYHog_Click(object sender, EventArgs e)
        {
            productosParaElCuidadoPersonalYDelHogar[] productosCuidaoPerYHogarArr = daoProdCuiHog.listarProductosXnombre(txtNombreProdLimpiezaYHogar.Text);
            if (productosCuidaoPerYHogarArr != null)
            {
                productosCuiPerYHogar = new BindingList<productosParaElCuidadoPersonalYDelHogar>(productosCuidaoPerYHogarArr);
                gvLimpiezayHogar.DataSource = productosCuiPerYHogar;
                gvLimpiezayHogar.DataBind();
            }
        }

        protected void lbBusquedaRopa_Click(object sender, EventArgs e)
        {
            ropa[] ropaArr = daoRopa.listarProductosXnombre(txtNombreRopa.Text);
            if (ropaArr != null)
            {
                productosRopa = new BindingList<ropa>(ropaArr);
                gvRopa.DataSource = productosRopa;
                gvRopa.DataBind();
            }
        }
    }
}