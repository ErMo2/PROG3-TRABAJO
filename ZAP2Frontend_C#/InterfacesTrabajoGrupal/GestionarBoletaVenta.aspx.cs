﻿using InterfacesTrabajoGrupal.ServicioWS;
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
        private boletaVenta boletaVenta = new boletaVenta();

        //Listar Cajeros
        private BindingList<cajero> listarCajeros;
        private cajero cajero = new cajero();
        private CajeroWSClient cajeroDAO;

        //Listar Monedas
        private BindingList<moneda> listarMonedas;
        private moneda moneda = new moneda();
        private MonedaWSClient monedaDAO;

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
                txtFechaEmision.Text = DateTime.Now.ToString("yyyy-MM-dd");

                CargarMonedas();
                CargarCajeros();
                CargarSucursales();
            }
            else
            {
                productosSeleccionados = Session["ProductosSeleccionados"] as BindingList<productoPrecio>;
                BindGridView();
            }
        }
        private void CargarCajeros()
        {
            cajeroDAO = new CajeroWSClient();
            listarCajeros = new BindingList<cajero>(cajeroDAO.listarCajeros());
            ddlCajeros.DataSource = listarCajeros;
            ddlCajeros.DataTextField = "nombre";
            ddlCajeros.DataValueField = "idEmpleado";
            ddlCajeros.DataBind();
        }
        private void CargarMonedas()
        {
            // Asume que existe un método en monedaDAO para listar las monedas
            monedaDAO = new MonedaWSClient();
            listarMonedas = new BindingList<moneda>(monedaDAO.listarMoneda());
            ddlMonedas.DataSource = listarMonedas;
            ddlMonedas.DataTextField = "nombre";
            ddlMonedas.DataValueField = "idMoneda";
            ddlMonedas.DataBind();
        }

        private void CargarSucursales()
        {

            sucursalDAO = new SucursalWSClient();
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
            if (listaProductos.Count == 0)
            {
                // Mostrar alerta de JavaScript si no hay productos
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('La sucursal seleccionada no tiene productos.');", true);
            }
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
                cliente = clienteDAO.buscarCliente(idCliente);
                if (cliente != null)
                {
                    txtCliente.Text = cliente.nombre;
                    Session["IdCliente"] = idCliente; // Guardar el idCliente en la sesión

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
                        cantidadComprada = Int32.Parse(txtCantidad.Text),
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
        {
            int idCliente = (int)Session["IdCliente"];

            // Configurar los datos de la boleta de venta
            boletaVenta.fecha_emision = DateTime.Now;
            boletaVenta.fecha_emisionSpecified = true;
            //Moneda
            //Ingresar moneda
            moneda moneda = new moneda();
            moneda.idMoneda = Int32.Parse(ddlMonedas.SelectedValue);            /*boletaVenta.moneda = new moneda
            {
                idMoneda = int.Parse(ddlMonedas.SelectedValue),
                abreviacion = listarMonedas.FirstOrDefault(m => m.idMoneda == int.Parse(ddlMonedas.SelectedValue))?.abreviacion,
                nombre = listarMonedas.FirstOrDefault(m => m.idMoneda == int.Parse(ddlMonedas.SelectedValue))?.nombre
            };*/
            boletaVenta.moneda = moneda;


            // Tipo Tarjeta
            boletaVenta.tarjeta = new tarjeta
            {
                idTarjeta = 2,
                tipoTarjeta = tipoTarjeta.CUENTA_CORRIENTE,
                tipoTarjetaSpecified = true,
                banco = new banco() // Configura esto según sea necesario
            };

            //Banco Afiliado
            boletaVenta.tarjeta.banco = new banco();
            boletaVenta.impuestos = 0.18;
            boletaVenta.detalles = "Compra realizada por un cliente regular";
            // Cajero
            boletaVenta.empleado = new cajero
            {
                idEmpleado = int.Parse(ddlCajeros.SelectedValue)
            };
            // Crear las líneas de documento de venta a partir de los productos seleccionados
            var lineasDocVenta = new BindingList<lineaDoc>();
            foreach (var producto in productosSeleccionados)
            {
                var linea = new lineaDoc
                {
                    documento = new boletaVenta(),
                    precioUnitario = producto.precio, // Asumiendo que 'precio' es el precio unitario del producto
                    cantidad = producto.producto.cantidadComprada, // Ajusta esto según cómo obtienes la cantidad del producto
                    precioTotal = producto.precio * producto.producto.cantidadComprada,
                    subTotal = producto.precio * producto.producto.cantidadComprada * (1 + boletaVenta.impuestos) // Puedes ajustar esto si tienes un cálculo diferente para el subtotal
                };
                lineasDocVenta.Add(linea);
            }

            boletaVenta.numSerie = 292;
            boletaVenta.montoTotal = devuelve() * 1.18;
            boletaVenta.total = devuelve();
            boletaVenta.lineasDocVenta = lineasDocVenta.ToArray();
            boletaVenta.idCliente = idCliente;
            // Registrar la boleta de venta
            int resultado = boletaVentaDAO.insertarBoletaVenta(boletaVenta);

            if (resultado != 0)
            {
                LineaDocWSClient lineaDocDAO = new LineaDocWSClient();
                foreach (lineaDoc linea in lineasDocVenta)
                {
                    linea.documento.id_documento = resultado;
                    lineaDocDAO.insertarLineaDoc(linea);
                }
                Response.Redirect("ListarDocumentoDeVenta.aspx");

            }
            else
            {
                lblMensaje.Text = "Error al registrar la boleta de venta";
            }

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
        private double devuelve()
        {
            return productosSeleccionados.Sum(p => p.precio * p.producto.cantidadComprada);
        }
    }
}