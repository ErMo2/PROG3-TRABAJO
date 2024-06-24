using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class ProdPerecible : System.Web.UI.Page
    {
        private ProductoPerecibleWSClient productoDao;
        private productoPerecible producto;
        private ProductoPrecioWSClient productoPrecioDao;
        private productoPrecio productoPrecio;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idProductoPerecible;
            productoDao = new ProductoPerecibleWSClient();
            if (Session["idPerecible"] != null)
            {
                idProductoPerecible = (int)Session["idPerecible"];
                Session["idPerecible"] = null;
                producto=productoDao.buscarProductoPerecible(idProductoPerecible);
                if (!IsPostBack)
                {
                    cargarDatos();
                }
                Session["idModificarPerecible"] = idProductoPerecible;
            }

        }
        protected void cargarDatos()
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            dtpFechaNacimiento.Value = producto.fechVencimiento.ToString("yyyy-MM-dd");
            ddlTipoProductoPerecible.SelectedValue = producto.tipo_producto_perecible.ToString();
            ddlUnidadMedida.SelectedValue = producto.unidad_de_medida.ToString();
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            if (Session["idModificarPerecible"] != null)
            {
                Response.Redirect("ListarProductos.aspx");
            }
            else
            {
                Response.Redirect("SeleccionarTipoDeProducto.aspx");
            }

        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            productoDao = new ProductoPerecibleWSClient();
            producto = new productoPerecible();
            producto.nombre = txtNombreProducto.Text;
            producto.descripcion = txtDescripcionProducto.Text;
            if (DateTime.TryParse(dtpFechaNacimiento.Value, out DateTime fechaVencimiento))
            {
                producto.fechVencimiento = fechaVencimiento;

            }
            if (ddlTipoProductoPerecible.SelectedValue == "Cereales")
                producto.tipo_producto_perecible = tipoProductoPerecible.Cereales;
            else if (ddlTipoProductoPerecible.SelectedValue == "Lacteos")
                producto.tipo_producto_perecible = tipoProductoPerecible.Lacteos;
            else if (ddlTipoProductoPerecible.SelectedValue == "Frutas")
                producto.tipo_producto_perecible = tipoProductoPerecible.Frutas;
            else if (ddlTipoProductoPerecible.SelectedValue == "Verduras")
                producto.tipo_producto_perecible = tipoProductoPerecible.Verduras;
            else if (ddlTipoProductoPerecible.SelectedValue == "Congelados")
                producto.tipo_producto_perecible = tipoProductoPerecible.Congelados;
            else
                producto.tipo_producto_perecible = tipoProductoPerecible.Despensa;
            if (ddlUnidadMedida.SelectedValue == "Unidad")
                producto.unidad_de_medida = unidadDeMedida.unidad;
            else if (ddlUnidadMedida.SelectedValue == "Paquete")
                producto.unidad_de_medida = unidadDeMedida.paquete;
            else if (ddlUnidadMedida.SelectedValue == "KG")
                producto.unidad_de_medida = unidadDeMedida.KG;
            else if (ddlUnidadMedida.SelectedValue == "LT")
                producto.unidad_de_medida = unidadDeMedida.LT;
            else
                producto.unidad_de_medida = unidadDeMedida.NA;
            producto.activo = 1;
            producto.fechVencimientoSpecified = true;
            producto.tipo_producto_perecibleSpecified = true;
            producto.unidad_de_medidaSpecified= true;
            productoPrecio = new productoPrecio();
            productoPrecioDao = new ProductoPrecioWSClient();
            
            if (Session["idModificarPerecible"] !=null)
            {
                producto.idProducto = (int)Session["idModificarPerecible"];
                int resultado=productoDao.modificarProductoPerecible(producto);
            }
            else
            {
                producto.idProducto = productoDao.insertarProductoPerecible(producto);
            }
            
            productoPrecio.producto = new producto();
            productoPrecio.producto.idProducto = producto.idProducto;
            
            producto.fechVencimientoSpecified= true;
            producto.tipo_producto_perecibleSpecified= true;
            producto.unidad_de_medidaSpecified = true;
            Response.Redirect("listarProductos.aspx");
        }
    }
}