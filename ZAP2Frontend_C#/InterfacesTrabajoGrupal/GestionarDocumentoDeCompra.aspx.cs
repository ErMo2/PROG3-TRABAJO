using iTextSharp.text.pdf;
using iTextSharp.text;
using Microsoft.Reporting.WebForms;
using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using InterfacesTrabajoGrupal.ServicioWS;
using System.ComponentModel;


namespace InterfacesTrabajoGrupal
{
    public partial class GestionarDocumentoDeCompra : System.Web.UI.Page
    {
        private PedidoWSClient pedidoDao;
        private BindingList<pedido> listaPedidos;
        private pedido pedido;
        protected void Page_Load(object sender, EventArgs e)
        {
            
            if (!IsPostBack)
            {
                double saldo;
                double total;
                pedidoDao =new PedidoWSClient();
                pedido = new pedido();
                if (double.TryParse(txtSaldo.Text, out saldo))
                {
                    pedido.saldo = saldo;
                }
                if (double.TryParse(txtTotal.Text, out total))
                {
                    pedido.total = total;
                }
                pedido.estado = estadoPedido.EN_PROCESO;
                DateTime fechaEmision;
                if (DateTime.TryParse(txtFechaEmision.Value, out fechaEmision))
                {
                    // Si la conversión es exitosa, ahora puedes usar 'fechaEmision'
                    pedido.fecha_Pedido = fechaEmision;
                }
                
                pedido.id_pedido = pedidoDao.insertarPedido(pedido);
            }
        }

        private void CrearDocumentoPDF()
        {
            // Define la carpeta donde se guardará el PDF
            string path = Server.MapPath("~\\Reportes\\");
            string filename = "Reporte" + DateTime.Now.ToString("yyyyMMddHHmmss") + ".pdf";
            string filePath = Path.Combine(path, filename);

            // Suponiendo que los datos vienen de campos de texto en tu formulario:
            string saldo = txtSaldo.Text; // Asegúrate de que txtSaldo es el ID correcto de tu TextBox
            string total = txtTotal.Text; // Asegúrate de que txtTotal es el ID correcto de tu TextBox
            string moneda = ddlMoneda.SelectedItem.Text; // Obtiene el texto del ítem seleccionado en el DropDownList

            // Crea un nuevo documento
            Document document = new Document(PageSize.A4, 25, 25, 30, 30);

            // Intenta escribir el documento
            try
            {
                PdfWriter writer = PdfWriter.GetInstance(document, new FileStream(filePath, FileMode.Create));

                // Abre el documento para escritura
                document.Open();

                // Añade contenido al documento
                document.Add(new Paragraph("Reporte de Documento de Compra"));
                document.Add(new Paragraph("Fecha: " + DateTime.Now.ToString("dd/MM/yyyy")));
                document.Add(new Paragraph("Saldo: " + saldo + " " + moneda));
                document.Add(new Paragraph("Total: " + total + " " + moneda));
                document.Add(new Paragraph("Este es un ejemplo de generación de PDF con iTextSharp."));

                // Cierra el documento
                document.Close();

                // Informa al usuario o realiza acciones adicionales, como mostrar un enlace al archivo
                Response.Write("Reporte generado con éxito en: " + filePath);
            }
            catch (Exception ex)
            {
                Response.Write("Error al generar el reporte: " + ex.Message);
            }
        }
  
        protected void btnGenerarPDF_Click(object sender, EventArgs e)
        {
            CrearDocumentoPDF();
        }
       
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarDocumentoDeCompra.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarDocumentoDeCompra.aspx");
        }
    }
}