using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class Cajero : System.Web.UI.Page
    {
        private ServicioWS.CajeroWSClient daoCajero;
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnRegresar_Click(object sender,EventArgs e) {
            Response.Redirect("GestionarEmpleados.aspx");
        }
        protected void btnRegistrar_Click(object sender,EventArgs e)
        {
            int resultado = 0;
            daoCajero = new ServicioWS.CajeroWSClient();
            cajero cajero = new cajero();
            cajero.nombre = txtNombre.Text;
            cajero.apellido_paterno = txtApellido_Paterno.Text;
            cajero.apellido_materno = txtApellido_Materno.Text;
            cajero.telefono = int.Parse(txtTelefono.Text);
            cajero.email = txtEmail.Text;
            if (rbDni.Checked)
                cajero.tipo_documento = tipoDocumento.DNI;
            else
                cajero.tipo_documento = tipoDocumento.CARNET_EXTRANJERIA;
            cajero.tipo_documentoSpecified = true;
            cajero.nro_documento = int.Parse(txtNumeroDocumento.Text);
            if (rbFemenino.Checked)
                cajero.sexo = 'F';
            else
                cajero.sexo = 'M';
            cajero.direccion = txtDireccion.Text;
            cajero.salario = Double.Parse(txtSalario.Text);
            cajero.fechaContratacion = DateTime.Parse(dtpFechaContratacion.Value);
            cajero.fechaContratacionSpecified = true;
            if (txtTurno.Text == "MAÑANA")
                cajero.horario = turnosHorario.MAÑANA;
            else
                cajero.horario = turnosHorario.NOCHE;
            cajero.horarioSpecified = true;
            if(txtContrato.Text == "TiempoParcial")
            {
                cajero.tipoContrato = tipoContrato.TiempoParcial;
            }
            else
            {
                if (txtContrato.Text == "TiempoCompleto")
                    cajero.tipoContrato = tipoContrato.TiempoCompleto;
                else
                    cajero.tipoContrato = tipoContrato.ContratoEspecial;
            }
            cajero.tipoContratoSpecified = true;
            area area_ = new area();
            area_.idArea = 1;
            cajero.area = area_;
            cajero.numeroCaja = 0;
            cajero.cantidadCaja = 0;
            supervisor superv = new supervisor();
            superv.idEmpleado = 1;
            cajero.supervisor = superv;
            resultado = daoCajero.insertarCajero(cajero);
            if(resultado != 0)
            {
                Response.Redirect("ListarEmpleados.aspx");
                Response.Write("Se ha registrado con exito...");
            }
        }
    }
}