using InterfacesTrabajoGrupal.ServicioWS;
using MySqlX.XDevAPI;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarPedido : System.Web.UI.Page
    {
        private ProductoWSClient daoProducto;
        private PedidoWSClient daoPedido;
        private Detalle_PedidoWSClient daoDetPedido;

        private BindingList<producto> productos;
        private pedido pedido;
        private BindingList<detallePedido> detallesPedido;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                TextFechaPedido.Text = DateTime.Now.ToString("yyyy-MM-dd");
            }

            daoProducto = new ProductoWSClient();
            daoPedido = new PedidoWSClient();
            daoDetPedido = new Detalle_PedidoWSClient();

            producto[] productosArr = daoProducto.listarProductosXnombre(txtNombreProductoModal.Text);
            if (productosArr != null)
                productos = new BindingList<producto>(productosArr);

            String accion = Request.QueryString["accion"];
            if (accion != null && accion == "ver" && Session["idPedido"] != null)
            {
                lblTituloPedidos.Text = "Ver Pedido";
                int idPedido = (int)Session["idPedido"];
                pedido = daoPedido.buscarPedido(idPedido);
                detallesPedido = new BindingList<detallePedido>(daoDetPedido.listarDetallePedidosXId(idPedido).ToList());
                foreach (detallePedido detPed in detallesPedido)
                {
                    detPed.cantidad = (int)(detPed.subtotal / detPed.precioUnitario);
                }
                Session["detallesPedido"] = detallesPedido;
                mostrarDatos();
            }
            else
            {
                lblTituloPedidos.Text = "Registrar Pedido";
                pedido = new pedido();
                if (!IsPostBack)
                {
                    Session["idPedido"] = null;
                    Session["detallesPedido"] = null;
                    Session["producto"] = null;
                }
            }

            if (Session["detallesPedido"] == null)
                detallesPedido = new BindingList<detallePedido>();
            else
                detallesPedido = (BindingList<detallePedido>)Session["detallesPedido"];

            gvDetallesPedidos.DataSource = detallesPedido;
            gvDetallesPedidos.DataBind();
        }

        protected void mostrarDatos()
        {
            txtIdPedido.Text = pedido.id_pedido.ToString();
            //txtNombrePedido.Text = pedido.nombre;
            btnGuardar.Enabled = false;
            btnBuscarProducto.Enabled = false;
            txtPrecioUnitProducto.Enabled = false;
            txtCantidadUnidades.Enabled = false;
            lbAgregarDetPed.Enabled = false;
            txtTotal.Text = pedido.total.ToString("N2");
        }

        protected void gvDetallePedido_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = ((producto)DataBinder.Eval(e.Row.DataItem, "producto")).nombre;
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "precioUnitario").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "cantidad").ToString();
                e.Row.Cells[3].Text = DataBinder.Eval(e.Row.DataItem, "precioTotal").ToString();
                e.Row.Cells[4].Text = DataBinder.Eval(e.Row.DataItem, "subtotal").ToString();
            }

            pedido.total = 0;
            foreach (detallePedido detPedAux in detallesPedido)
                pedido.total += detPedAux.subtotal;
            txtTotal.Text = pedido.total.ToString("N2");

        }

        protected void btnBuscarProducto_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormProducto() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }
        protected void lbAgregarDetPed_Click(object sender, EventArgs e)
        {
            if (Session["producto"] == null)
            {
                Response.Write("No puede añadir sin haber seleccionado un producto...");
                return;
            }
            if (txtCantidadUnidades.Text.Trim().Equals(""))
            {
                Response.Write("Debe ingresar una cantidad de unidades...");
                return;
            }
            if (txtPrecioUnitProducto.Text.Trim().Equals(""))
            {
                Response.Write("Debe ingresar un precio al producto...");
                return;
            }

            detallePedido detPed = new detallePedido();
            detPed.producto = new producto();
            detPed.producto = (producto)Session["producto"];
            detPed.precioUnitario = double.Parse(txtPrecioUnitProducto.Text);
            detPed.cantidad = Int32.Parse(txtCantidadUnidades.Text);
            detPed.precioTotal = detPed.precioUnitario * detPed.cantidad;
            detPed.subtotal = detPed.precioTotal * 1.18;
            detallesPedido.Add(detPed);

            Session["detallesPedido"] = detallesPedido;

            gvDetallesPedidos.DataSource = detallesPedido;
            gvDetallesPedidos.DataBind();

            calcularTotal();

            txtIDProducto.Text = "";
            txtNombreProducto.Text = "";
            txtPrecioUnitProducto.Text = "";
            txtCantidadUnidades.Text = "";
        }

        protected void calcularTotal()
        {
            pedido.total = 0;
            foreach (detallePedido detPed in detallesPedido)
                pedido.total += detPed.subtotal;
            txtTotal.Text = pedido.total.ToString();
        }


        protected void btnEliminarProducto_Click(object sender, EventArgs e)
        {
            String accion = Request.QueryString["accion"];
            if (accion != null && accion == "registrar")
            {
                int posDetAEliminar = -1;
                int idPedidoSelec = Int32.Parse(((LinkButton)sender).CommandArgument);
                detallesPedido = (BindingList<detallePedido>)Session["detallesPedido"];
                foreach (detallePedido detPed in detallesPedido)
                {
                    posDetAEliminar++;
                    if (detPed.id_DetallePedido == idPedidoSelec)
                        break;
                }
                if (posDetAEliminar > -1)
                {
                    detallesPedido.RemoveAt(posDetAEliminar);
                    Session["detallesPedido"] = detallesPedido;

                    gvDetallesPedidos.DataSource = detallesPedido;
                    gvDetallesPedidos.DataBind();

                    calcularTotal();
                }
            }
        }
        protected void btnGuardar_Click(object sender, EventArgs e)
        {

            //Validacion de que exista por lo menos 1 linea de orden de venta
            if (Session["detallesPedido"] == null)
            {
                Response.Write("Debe agregar un producto...");
                return;
            }
            else
            {
                if (txtNombrePedido.Text == "")
                {
                    Response.Write("Debe agregar un nombre al pedido...");
                    return;
                }
                else
                {
                    pedido.detallesPedido = ((BindingList<detallePedido>)Session["detallesPedido"]).ToArray();
                    pedido.fecha_Pedido = DateTime.Parse(TextFechaPedido.Text);
                    pedido.total = Double.Parse(txtTotal.Text);
                    pedido.nombre = txtNombrePedido.Text;
                    pedido.estadoSpecified = true;
                    pedido.fecha_PedidoSpecified = true;
                }
            }

            calcularTotal();
            int resultado = daoPedido.insertarPedido(pedido);

            foreach (detallePedido detPed in detallesPedido)
            {
                detPed.pedido = new pedido();
                detPed.pedido.id_pedido = resultado;
                daoDetPedido.insertarDetallePedido(detPed);
            }


            Response.Redirect("ListarPedidos.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarPedidos.aspx");
        }

        protected void lbBusquedaProductoModal_Click(object sender, EventArgs e)
        {
            producto[] productosArr = daoProducto.listarProductosXnombre(txtNombreProductoModal.Text);
            if (productosArr != null)
            {
                productos = new BindingList<producto>(productosArr);
                gvProductos.DataSource = productos;
                gvProductos.DataBind();
            }
        }

        protected void gvProductos_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "nombre").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "descripcion").ToString();
            }
        }

        protected void btnSeleccionarProductoModal_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            producto productoSeleccionado = productos.SingleOrDefault(x => x.idProducto == idProducto);
            Session["producto"] = productoSeleccionado;
            txtNombreProducto.Text = productoSeleccionado.nombre + " " + productoSeleccionado.descripcion;
            txtIDProducto.Text = productoSeleccionado.idProducto.ToString();
            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);

        }

        protected void gvProductos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvProductos.PageIndex = e.NewPageIndex;
            gvProductos.DataSource = productos;
            gvProductos.DataBind();
        }
    }
}