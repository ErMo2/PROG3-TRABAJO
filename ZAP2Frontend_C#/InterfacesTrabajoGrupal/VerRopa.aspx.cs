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
    public partial class VerRopa : System.Web.UI.Page
    {
        private RopaWSClient productoDao;
        private ropa producto;
        private ProductoPrecioWSClient productoPrecioDao;
        private BindingList<productoPrecio> prodPred;
        private productoPrecio Producto;
        private SucursalWSClient sucursalDao;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idRopa;
            productoDao = new RopaWSClient();

            if (Session["idRopaVisualizar"] != null)
            {
                idRopa = (int)Session["idRopaVisualizar"];
                producto = productoDao.buscarRopa(idRopa);
                if (!IsPostBack)
                {
                    cargarDatos(idRopa);
                }
                productoPrecioDao = new ProductoPrecioWSClient();
                productoPrecio[] ArregloProdPre = productoPrecioDao.listarProductoPrecioProducto(idRopa);
                if (ArregloProdPre != null)
                {
                    prodPred = new BindingList<productoPrecio>(ArregloProdPre);
                }

                gvSucursales.DataSource = prodPred;
                gvSucursales.DataBind();
            }
        }
        protected void cargarDatos(int idRopa)
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            ddlTemporada.SelectedValue = producto.temporada;
            txtMaterial.Text = producto.material;
            ddlTipoRopa.SelectedValue = producto.tipo.ToString();
            sucursalDao = new SucursalWSClient();
            var sucursales = sucursalDao.listarSucursalesDeUnProductoSinPrecio(idRopa);
            ddlSucursal.Items.Clear();
            foreach (var sucursal in sucursales)
            {
                ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));

            }
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {

            Response.Redirect("SeleccionarTipoDeProducto.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            productoDao = new RopaWSClient();
            producto = new ropa();
            producto.nombre = txtNombreProducto.Text;
            producto.descripcion = txtDescripcionProducto.Text;
            producto.temporada = ddlTemporada.SelectedValue;
            producto.material = txtMaterial.Text;


            if (ddlTipoRopa.SelectedValue == "RopaHombre")
                producto.tipo = tipoRopa.RopaHombre;
            else if (ddlTipoRopa.SelectedValue == "RopaMujer")
                producto.tipo = tipoRopa.RopaMujer;
            else
                producto.tipo = tipoRopa.Calzado;
            producto.tipoSpecified = true;

            if (Session["idModificarRopa"] != null)
            {
                producto.idProducto = (int)Session["idModificarRopa"];
                int resultado = productoDao.modificarRopa(producto);
            }
            else
            {
                producto.idProducto = productoDao.insertarRopa(producto);
            }
            Response.Redirect("ListarProductos.aspx");
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