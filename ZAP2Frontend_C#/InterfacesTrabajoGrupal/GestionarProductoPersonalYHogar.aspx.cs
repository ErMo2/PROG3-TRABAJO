using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class ProductoPersonalYHogar : System.Web.UI.Page
    {
        private ProductosParaElCuidadoPersonalYDelHogarWSClient productoDao;
        private productosParaElCuidadoPersonalYDelHogar producto;
        private ProductoPrecioWSClient productoPrecioDao;
        private productoPrecio productoPrecio;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idHigiene;
            productoDao = new ProductosParaElCuidadoPersonalYDelHogarWSClient();
            if (Session["idHigiene"] != null)
            {
                idHigiene = (int)Session["idHigiene"];
                Session["idHigiene"]=null;
                producto = productoDao.buscarProductoPCH(idHigiene);
                if (!IsPostBack)
                {
                    cargarDatos();
                }
                Session["idModificarHigiene"] = idHigiene;
            }
        }
        protected void cargarDatos()
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            ddlUnidadMedida.SelectedValue = producto.unidadMedida.ToString();
            txtTipo.Text = producto.tipo.ToString();
            
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SeleccionarTipoDeProducto.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            productoDao = new ProductosParaElCuidadoPersonalYDelHogarWSClient();
            producto = new productosParaElCuidadoPersonalYDelHogar();
            producto.descripcion = txtDescripcionProducto.Text;
            producto.nombre = txtNombreProducto.Text;
            producto.tipo = txtTipo.Text;
            if (ddlUnidadMedida.SelectedValue == "Unidad")
            {
                producto.unidadMedida = unidadDeMedida.unidad;
            }
            else if (ddlUnidadMedida.SelectedValue == "Paquete")
            {
                producto.unidadMedida = unidadDeMedida.paquete;
            }
            else if (ddlUnidadMedida.SelectedValue == "KG")
            {
                producto.unidadMedida = unidadDeMedida.KG;
            }
            else if (ddlUnidadMedida.SelectedValue == "LT")
            {
                producto.unidadMedida = unidadDeMedida.LT;
            }
            else
            {
                producto.unidadMedida = unidadDeMedida.NA;
            }
            producto.unidadMedidaSpecified = true;
            producto.idProducto = productoDao.insertarPCH(producto);
            if (Session["idModificarHigiene"] != null)
            {
                producto.idProducto = (int)Session["idModificarHigiene"];
                int resultado = productoDao.modificarPCH(producto);
            }
            else
            {
                producto.idProducto = productoDao.insertarPCH(producto);
            }
            Response.Redirect("listarProductos.aspx");
        }
    }
}