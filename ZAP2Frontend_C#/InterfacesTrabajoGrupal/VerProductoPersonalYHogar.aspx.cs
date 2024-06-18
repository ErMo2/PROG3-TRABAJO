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
    public partial class VerProductoPersonalYHogar : System.Web.UI.Page
    {
        private ProductosParaElCuidadoPersonalYDelHogarWSClient productoDao;
        private productosParaElCuidadoPersonalYDelHogar producto;
        private ProductoPrecioWSClient productoPrecioDao;
        private productoPrecio Producto;
        private BindingList<productoPrecio> prodPred;
        private SucursalWSClient sucursalDao;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idProductoHogar;
            productoDao = new ProductosParaElCuidadoPersonalYDelHogarWSClient();

            if (Session["idHigieneVisualizar"] != null)
            {
                idProductoHogar = (int)Session["idHigieneVisualizar"];
                producto = productoDao.buscarProductoPCH(idProductoHogar);
                if (!IsPostBack)
                {
                    cargarDatos(idProductoHogar);
                }
                productoPrecioDao = new ProductoPrecioWSClient();
                productoPrecio[] ArregloProdPre = productoPrecioDao.listarProductoPrecioProducto(idProductoHogar);
                if (ArregloProdPre != null)
                {
                    prodPred = new BindingList<productoPrecio>(ArregloProdPre);
                }

                gvSucursales.DataSource = prodPred;
                gvSucursales.DataBind();
            }
        }
        protected void cargarDatos(int idProductoHogar)
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            ddlUnidadMedida.SelectedValue = producto.unidadMedida.ToString();
            txtTipo.Text = producto.tipo.ToString();
            sucursalDao = new SucursalWSClient();
            var sucursales = sucursalDao.listarSucursalesDeUnProductoSinPrecio(idProductoHogar);
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
            //producto.idProducto = productoDao.insertarPCH(producto);
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