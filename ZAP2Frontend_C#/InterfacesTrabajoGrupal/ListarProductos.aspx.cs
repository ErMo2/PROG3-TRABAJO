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

        protected void Page_Load(object sender, EventArgs e)
        {
            daoProdPerecible = new ProductoPerecibleWSClient();
            daoProdCuiHog = new ProductosParaElCuidadoPersonalYDelHogarWSClient();
            daoElectrodomestico = new ElectrodomesticosWSClient();
            daoRopa = new RopaWSClient();

            if (!IsPostBack)
            {
                CargarDatos();
            }
        }

        private void CargarDatos()
        {
            ropa[] ropaArreglo = daoRopa.listarRopa();
            electrodomesticos[] electrodomesticosArreglo = daoElectrodomestico.listarElectrodomesticos();
            productosParaElCuidadoPersonalYDelHogar[] prodCuiHogArreglo = daoProdCuiHog.listarPCH();
            productoPerecible[] prodPerecibleArreglo = daoProdPerecible.listarProductoPerecible();

            if (ropaArreglo != null)
                listaRopa = new BindingList<ropa>(ropaArreglo);
            else
                listaRopa = new BindingList<ropa>();

            if (electrodomesticosArreglo != null)
                listaElectrodomesticos = new BindingList<electrodomesticos>(electrodomesticosArreglo);
            else
                listaElectrodomesticos = new BindingList<electrodomesticos>();

            if (prodCuiHogArreglo != null)
                listaProdCuiHog = new BindingList<productosParaElCuidadoPersonalYDelHogar>(prodCuiHogArreglo);
            else
                listaProdCuiHog = new BindingList<productosParaElCuidadoPersonalYDelHogar>();

            if (prodPerecibleArreglo != null)
                listaProdPerecibles = new BindingList<productoPerecible>(prodPerecibleArreglo);
            else
                listaProdPerecibles = new BindingList<productoPerecible>();

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
            Response.Redirect($"EditarProductoPerecible.aspx?idProducto={idProducto}");
        }

        protected void DeleteProductPerecible_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoProdPerecible.eliminarProductoPerecible(idProducto);
            CargarDatos();
        }

        protected void VerProductPerecible_Click(object sender, EventArgs e)
        {

            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Response.Redirect($"DetalleProductoPerecible.aspx?idProducto={idProducto}");
            if (listaProdPerecibles != null)
            {
                var producto = listaProdPerecibles.FirstOrDefault(p => p.idProducto == idProducto);
                if (producto != null)
                {
                    lblDetalles.Text = $"ID: {producto.idProducto}<br/>Nombre: {producto.nombre}<br/>Descripción: {producto.descripcion}<br/>Fecha Vencimiento: {producto.fechVencimiento}<br/>Tipo: {producto.tipo_producto_perecible}";
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "Pop", "openModal();", true);
                }
            }
        }

        protected void EditProductElectrodomestico_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Response.Redirect($"EditarElectrodomestico.aspx?idProducto={idProducto}");
        }

        protected void DeleteProductElectrodomestico_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoElectrodomestico.eliminarElectrodomestico(idProducto);
            CargarDatos();
        }

        protected void VerProductElectrodomestico_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            if (listaElectrodomesticos != null)
            {
                var producto = listaElectrodomesticos.FirstOrDefault(p => p.idProducto == idProducto);
                if (producto != null)
                {
                    lblDetalles.Text = $"ID: {producto.idProducto}<br/>Nombre: {producto.nombre}<br/>Descripción: {producto.descripcion}<br/>Tiene Garantía: {producto.tieneGarantia}<br/>Tiempo Garantía: {producto.tiempoGarantia}";
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "Pop", "openModal();", true);
                }
            }
        }

        protected void EditProductLimpiezaHogar_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Response.Redirect($"EditarLimpiezaHogar.aspx?idProducto={idProducto}");
        }

        protected void DeleteProductLimpiezaHogar_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoProdCuiHog.eliminarPCH(idProducto);
            CargarDatos();
        }

        protected void VerProductLimpiezaHogar_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            if (listaProdCuiHog != null)
            {
                var producto = listaProdCuiHog.FirstOrDefault(p => p.idProducto == idProducto);
                if (producto != null)
                {
                    lblDetalles.Text = $"ID: {producto.idProducto}<br/>Nombre: {producto.nombre}<br/>Descripción: {producto.descripcion}<br/>Unidad de Medida: {producto.unidadMedida}<br/>Tipo: {producto.tipo}";
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "Pop", "openModal();", true);
                }
            }
        }

        protected void EditProductRopa_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            Response.Redirect($"EditarRopa.aspx?idProducto={idProducto}");
        }

        protected void DeleteProductRopa_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoRopa.eliminarRopa(idProducto);
            CargarDatos();
        }

        protected void VerProductRopa_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            if (listaRopa != null)
            {
                var producto = listaRopa.FirstOrDefault(p => p.idProducto == idProducto);
                if (producto != null)
                {
                    lblDetalles.Text = $"ID: {producto.idProducto}<br/>Nombre: {producto.nombre}<br/>Descripción: {producto.descripcion}<br/>Temporada: {producto.temporada}<br/>Material: {producto.material}";
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "Pop", "openModal();", true);
                }
            }
        }
    }
}