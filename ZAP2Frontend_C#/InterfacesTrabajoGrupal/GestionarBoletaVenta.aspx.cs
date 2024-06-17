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
    public partial class BoletaVenta : System.Web.UI.Page
    {
        private Boleta_VentaWSClient boletaVentaDAO = new Boleta_VentaWSClient();
        private ClienteWSClient clienteDAO = new ClienteWSClient();
        private ProductoPrecioWSClient precioDAO = new ProductoPrecioWSClient();

        private cliente cliente;
        private BindingList<productoPrecio> productosSeleccionados = new BindingList<productoPrecio>();
        private BindingList<sucursal> sucursalList;
        private productoPrecio[] arregloProductoPrecios;
        private SucursalWSClient sucursalDAO;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                productosSeleccionados = new BindingList<productoPrecio>();
                Session["ProductosSeleccionados"] = productosSeleccionados;

                CargarSucursales();
            }
            else
            {
                productosSeleccionados = Session["ProductosSeleccionados"] as BindingList<productoPrecio>;
                BindGridView();
            }
        }

        private void CargarSucursales()
        {
            sucursalDAO=new SucursalWSClient();
            sucursalList = new BindingList<sucursal>(sucursalDAO.listarSucursal());
            ddlSucursales.DataSource = sucursalList;
            ddlSucursales.DataTextField = "nombre";
            ddlSucursales.DataValueField = "id_sucursal";
            ddlSucursales.DataBind();
        }

        private void CargarProductosPorSucursal()
        {
            int idSucursal = int.Parse(ddlSucursales.SelectedValue);
            arregloProductoPrecios = precioDAO.listarProductoPrecioProductoDeUnaSucursal(idSucursal);

            var listaProductos = new BindingList<producto>(
                arregloProductoPrecios.Select(pp => pp.producto).Where(p => p != null).ToList()
            );

            ddlProducto.DataSource = listaProductos;
            ddlProducto.DataTextField = "nombre";
            ddlProducto.DataValueField = "idProducto";
            ddlProducto.DataBind();
        }

        protected void ddlSucursales_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarProductosPorSucursal();
        }

        protected void btnBuscarCliente_Click(object sender, EventArgs e)
        {
            int idCliente;
            if (int.TryParse(txtCliente.Text, out idCliente))
            {
                cliente = clienteDAO.listarClientesPorNombre(txtCliente.Text);
                if (cliente != null)
                {
                    txtCliente.Text = cliente.nombre;
                }
                else
                {
                    lblMensaje.Text = "Cliente no encontrado";
                }
            }
            else
            {
                lblMensaje.Text = "ID de cliente no válido";
            }
        }

        protected void btnBuscarProducto_Click(object sender, EventArgs e)
        {
            int idProducto = int.Parse(ddlProducto.SelectedValue);
            int cantidad = int.Parse(txtCantidad.Text);

            int idSucursal = int.Parse(ddlSucursales.SelectedValue);
            arregloProductoPrecios = precioDAO.listarProductoPrecioProductoDeUnaSucursal(idSucursal);

            var prodPrecio = arregloProductoPrecios.FirstOrDefault(pp => pp.producto.idProducto == idProducto);
            var prod = prodPrecio.producto;

            if (prod != null)
            {
                var prodSel = new productoPrecio
                {
                    producto = new producto
                    {
                        idProducto = prod.idProducto,
                        nombre = prod.nombre,
                        descripcion = prod.descripcion,
                        cantidadComprada = prod.cantidadComprada,
                        prodPrecio = new productoPrecio
                        {
                            precio = prodPrecio.precio,
                        }
                    },
                    precio = prodPrecio.precio,
                };


                productosSeleccionados.Add(prodSel);

                gvProductos.DataSource = productosSeleccionados;
                gvProductos.DataBind();
                
                CalcularTotal();
            }
        }

        protected void btnEliminarProducto_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int productoId = Convert.ToInt32(btn.CommandArgument);
            var producto = productosSeleccionados.FirstOrDefault(p => p.producto.idProducto == productoId);
            if (producto != null)
            {
                productosSeleccionados.Remove(producto);
                BindGridView();
            }

            CalcularTotal();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarDocumentoDeVenta.aspx");
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {/*
            boletaVenta.fecha_emision = Convert.ToDateTime(txtFechaEmision.Text);
            boletaVenta.Cliente = cliente;

            var lineasDocVenta = productosSeleccionados.Select(p => new lineaDocVenta
            {
                ProductoId = p.producto.idProducto,
                Nombre = p.producto.nombre,
                Cantidad = p.cantidadComprada,
                Precio = p.precio
            }).ToList();

            boletaVenta.lineasDocVenta = lineasDocVenta;

            bool resultado = boletaVentaDAO.RegistrarBoletaVenta(boletaVenta);
            if (resultado)
            {
                Session["ProductosSeleccionados"] = null;
                Response.Redirect("ListarDocumentoDeVenta.aspx");
            }
            else
            {
                lblMensaje.Text = "Error al registrar la boleta de venta";
            }*/
        }

        private void BindGridView()
        {
            gvProductos.DataSource = productosSeleccionados;
            gvProductos.DataBind();
        }

        private void CalcularTotal()
        {
            double total = productosSeleccionados.Sum(p => p.precio * p.producto.cantidadComprada);
            lblTotalValue.Text = total.ToString("C");
        }
    }
}