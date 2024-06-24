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
        private boletaVenta boletaVenta = new boletaVenta();

        // Listar Cajeros
        private BindingList<cajero> listarCajeros;
        private cajero cajero = new cajero();
        private CajeroWSClient cajeroDAO;

        // Listar Monedas
        private BindingList<moneda> listarMonedas;
        private moneda moneda = new moneda();
        private MonedaWSClient monedaDAO;

        private cliente cliente;
        private BindingList<productoPrecio> productosSeleccionados = new BindingList<productoPrecio>();
        private BindingList<sucursal> sucursalList;
        private productoPrecio[] arregloProductoPrecios;
        private SucursalWSClient sucursalDAO;

        private BindingList<cliente> todosLosClientes;
        private BindingList<cliente> clientesFiltrados;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                todosLosClientes = new BindingList<cliente>(clienteDAO.listarClientes());
                Session["TodosLosClientes"] = todosLosClientes;

                productosSeleccionados = new BindingList<productoPrecio>();
                Session["ProductosSeleccionados"] = productosSeleccionados;
                txtFechaEmision.Text = DateTime.Now.ToString("yyyy-MM-dd");

                CargarMonedas();
                CargarSucursales();
                CargarTarjetas();

            }
            else
            {
                todosLosClientes = Session["TodosLosClientes"] as BindingList<cliente>;
                productosSeleccionados = Session["ProductosSeleccionados"] as BindingList<productoPrecio>;
                //BindGridView();
            }
        }
        private void CargarTarjetas()
        {
            TarjetaWSClient tarjetaDAO = new TarjetaWSClient();
            BindingList<tarjeta> listarTarjetas;
            tarjetaDAO = new TarjetaWSClient();
            listarTarjetas = new BindingList<tarjeta>(tarjetaDAO.listarTarjeta());
            ddlTarjetas.DataSource = listarTarjetas;
            ddlTarjetas.DataTextField = "tipoTarjeta";
            ddlTarjetas.DataValueField = "idTarjeta";
            ddlTarjetas.DataBind();
        }
        private void CargarCajerosPorSucursal(int idSucursal)
        {
            cajeroDAO = new CajeroWSClient();
            listarCajeros = new BindingList<cajero>(cajeroDAO.listarCajerosPorSucursal(idSucursal));
            if (listarCajeros != null)
            {
                ddlCajeros.DataSource = listarCajeros;

                ddlCajeros.DataTextField = "nombre";
                ddlCajeros.DataValueField = "id_Persona";
                ddlCajeros.DataBind();
            }
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
            CargarCajerosPorSucursal(idSucursal);

        }

        protected void ddlSucursales_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarProductosPorSucursal();
        }

        protected void btnBuscarCliente_Click(object sender, EventArgs e)
        {
            string nombreCliente = txtNombreCliente.Text.Trim();
            if (!string.IsNullOrEmpty(nombreCliente))
            {
                clientesFiltrados = new BindingList<cliente>(
                    todosLosClientes.Where(c => c.nombre.IndexOf(nombreCliente, StringComparison.OrdinalIgnoreCase) >= 0).ToList()
                );

                if (clientesFiltrados.Count > 0)
                {
                    var clientesParaMostrar = clientesFiltrados.Select(c => new
                    {
                        idCliente = c.id_cliente,
                        nombreCompleto = $"{c.nombre} {c.apellido_paterno} {c.apellido_materno}"
                    }).ToList();

                    ddlClientes.DataSource = clientesParaMostrar;
                    ddlClientes.DataTextField = "nombreCompleto";
                    ddlClientes.DataValueField = "idCliente";
                    ddlClientes.DataBind();
                }
                else
                {
                    lblMensaje.Text = "No se encontraron clientes con ese nombre.";
                    ddlClientes.Items.Clear();
                }
            }
            else
            {
                lblMensaje.Text = "Por favor, ingrese un nombre para buscar.";
            }
        }


        protected void btnBuscarProducto_Click(object sender, EventArgs e)
        { // Validación para asegurar que un producto haya sido seleccionado
            if (ddlProducto.SelectedValue == null || ddlProducto.SelectedValue == "")
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Debe seleccionar un producto.');", true);
                return;
            }

            int idProducto = int.Parse(ddlProducto.SelectedValue);
            int cantidad = int.Parse(txtCantidad.Text);



            // Validación para asegurar que una cantidad haya sido ingresada
            if (string.IsNullOrWhiteSpace(txtCantidad.Text) || !int.TryParse(txtCantidad.Text, out int Cantidad) || cantidad <= 0)
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Debe ingresar una cantidad válida.');", true);
                return;
            }

            int idSucursal = int.Parse(ddlSucursales.SelectedValue);
            arregloProductoPrecios = precioDAO.listarProductoPrecioProductoDeUnaSucursal(idSucursal);

            var prodPrecio = arregloProductoPrecios.FirstOrDefault(pp => pp.producto.idProducto == idProducto);
            var prod = prodPrecio.producto;

            if (prod != null)
            {
                var prodSel = new productoPrecio
                {
                    idProductoPrecio = prodPrecio.idProductoPrecio,
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
            Response.Redirect("ListarDocumentoDeVenta.aspx");
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            // Validación para asegurar que el número de serie no esté vacío
            if (string.IsNullOrWhiteSpace(txtNumeroSerie.Text))
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('El campo de número de serie es obligatorio.');", true);
                return;
            }

            // Validación para asegurar que el nombre del cliente no esté vacío
            if (string.IsNullOrWhiteSpace(txtNombreCliente.Text))
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('El campo de nombre del cliente es obligatorio.');", true);
                return;
            }
            if (productosSeleccionados == null || productosSeleccionados.Count == 0)
            {
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Primero debe llenar los campos de fechas y número de huéspedes.');", true);
                return;
            }
            int idCliente = int.Parse(ddlClientes.SelectedValue);

            // Configurar los datos de la boleta de venta
            boletaVenta.fecha_emision = DateTime.Now;
            boletaVenta.fecha_emisionSpecified = true;

            // Ingresar moneda
            moneda moneda = new moneda();
            moneda.idMoneda = Int32.Parse(ddlMonedas.SelectedValue);
            boletaVenta.moneda = moneda;

            // Tipo Tarjeta
            boletaVenta.tarjeta = new tarjeta
            {
                idTarjeta = int.Parse(ddlTarjetas.SelectedValue),

            };


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

                    producto = new productoPrecio { idProductoPrecio = producto.idProductoPrecio },
                    precioUnitario = producto.precio, // Asumiendo que 'precio' es el precio unitario del producto
                    cantidad = producto.producto.cantidadComprada, // Ajusta esto según cómo obtienes la cantidad del producto
                    precioTotal = producto.precio * producto.producto.cantidadComprada,
                    subTotal = producto.precio * producto.producto.cantidadComprada * (1 + boletaVenta.impuestos) // Puedes ajustar esto si tienes un cálculo diferente para el subtotal
                };
                lineasDocVenta.Add(linea);
            }

            boletaVenta.numSerie = int.Parse(txtNumeroSerie.Text);
            boletaVenta.montoTotal = devuelve() * 1.18;
            boletaVenta.total = devuelve();
            boletaVenta.lineasDocVenta = lineasDocVenta.ToArray();
            boletaVenta.idCliente = idCliente;

            // Registrar la boleta de venta
            int resultado = boletaVentaDAO.insertarBoletaVenta(boletaVenta);

            int result;
            if (resultado != 0)
            {
                foreach (lineaDoc linea in lineasDocVenta)
                {
                    LineaDocWSClient lineaDocDAO = new LineaDocWSClient();

                    linea.documento = boletaVenta;
                    linea.documento = new documento();
                    linea.documento.id_documento = resultado;

                    result = lineaDocDAO.insertarLineaDoc(linea);
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