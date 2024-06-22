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
    public partial class VerProductosPerecibles : System.Web.UI.Page
    {
        private ProductoPerecibleWSClient productoDao;
        private productoPerecible producto;
        private ProductoPrecioWSClient productoPrecioDao;
        private BindingList<productoPrecio> prodPred;
        private productoPrecio Producto;
        private SucursalWSClient sucursalDao;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idProductoPerecible;
            productoDao = new ProductoPerecibleWSClient();

            if (Session["idPerecibleVisualizar"] != null)
            {
                idProductoPerecible = (int)Session["idPerecibleVisualizar"];
                producto = productoDao.buscarProductoPerecible(idProductoPerecible);
                if (!IsPostBack)
                {
                    cargarDatos(idProductoPerecible);
                }
                productoPrecioDao = new ProductoPrecioWSClient();
                productoPrecio[] ArregloProdPre = productoPrecioDao.listarProductoPrecioProducto(idProductoPerecible);
                if (ArregloProdPre != null)
                {
                    prodPred = new BindingList<productoPrecio>(ArregloProdPre);
                }
                
                gvSucursales.DataSource = prodPred;
                gvSucursales.DataBind();
            }

              
        }
        protected void cargarDatos(int idProductoPerecible)
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            dtpFechaNacimiento.Text = producto.fechVencimiento.ToString("yyyy-MM-dd");
            ddlTipoProductoPerecible.SelectedValue = producto.tipo_producto_perecible.ToString();
            ddlUnidadMedida.SelectedValue = producto.unidad_de_medida.ToString();
            sucursalDao = new SucursalWSClient();
            var sucursales = sucursalDao.listarSucursalesDeUnProductoSinPrecio(idProductoPerecible);
            ddlSucursal.Items.Clear();
            foreach (var sucursal in sucursales)
            {
                //if (sucursal.id_sucursal?)
                //{
                //    ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));
                //}
                ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));

            }
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarProductos.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            productoDao = new ProductoPerecibleWSClient();
            producto = new productoPerecible();
            producto.nombre = txtNombreProducto.Text;
            producto.descripcion = txtDescripcionProducto.Text;
            if (DateTime.TryParse(dtpFechaNacimiento.Text, out DateTime fechaVencimiento))
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
            producto.unidad_de_medidaSpecified = true;

            if (Session["idModificarPerecible"] != null)
            {
                producto.idProducto = (int)Session["idModificarPerecible"];
                int resultado = productoDao.modificarProductoPerecible(producto);
            }
            else
            {
                producto.idProducto = productoDao.insertarProductoPerecible(producto);
            }


            producto.fechVencimientoSpecified = true;
            producto.tipo_producto_perecibleSpecified = true;
            producto.unidad_de_medidaSpecified = true;
            //  productoPrecio.descuentos[0].idDescuento = descuentoDao.insertarDescuento(descuentoProducto);
            Response.Redirect("listarProductos.aspx");
        }
        protected void gvSucursales_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "idProductoPrecio").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "sucursal.nombre").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "precio").ToString();

            }
        }
        protected void btnRegistrarProductoPrecio_Click(object sender, EventArgs e)
        {
            //Producto.sucursal= new sucursal();
            Producto = new productoPrecio();
            Producto.sucursal = new sucursal();
            Producto.sucursal.id_sucursal = int.Parse(ddlSucursal.SelectedValue);

            Producto.precio = double.Parse(txtNuevoPrecio.Text);
            Producto.producto = new producto();
            Producto.producto.idProducto = Int32.Parse(txtIdProducto.Text);
            productoPrecioDao.insertarProductoPrecio(Producto);
            gvSucursales.DataBind();

            Response.Redirect(Request.RawUrl);
        }
        protected void gvSucursales_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvSucursales.PageIndex = e.NewPageIndex;
            gvSucursales.DataBind();
        }
        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            productoPrecioDao = new ProductoPrecioWSClient();
            int idProductoPrecio = Int32.Parse(((LinkButton)sender).CommandArgument);
            productoPrecioDao.eliminarProductoPrecio(idProductoPrecio);
            Response.Redirect(Request.RawUrl);
        }
    }
}
