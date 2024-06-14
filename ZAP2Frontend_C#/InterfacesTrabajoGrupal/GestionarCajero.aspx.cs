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
        private CajeroWSClient daoCajero;
        private cajero empleado;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idEmpleadoArea;
                if (int.TryParse(Request.QueryString["id"], out idEmpleadoArea))
                {
                    cargarCajeros(idEmpleadoArea);
                }
            }
        }
        private void cargarCajeros(int idCajero)
        {
            daoCajero = new CajeroWSClient();

            empleado = daoCajero.buscarCajero(idCajero);

            if (empleado != null)
            {
                txtIdEmpleado.Text = empleado.idEmpleado.ToString();
                txtNombre.Text = empleado.nombre;
                txtApellido_Paterno.Text = empleado.apellido_paterno;
                txtApellido_Materno.Text = empleado.apellido_materno;
                txtTelefono.Text = empleado.telefono.ToString();
                txtEmail.Text = empleado.email;
                if (empleado.tipo_documento.ToString() == "DNI")
                    rbDni.Checked = true;
                else
                    rbCarnet_Extranjeria.Checked = true;
                txtNumeroDocumento.Text = empleado.nro_documento.ToString();
                if (empleado.sexo == 'F')
                    rbFemenino.Checked = true;
                else
                    rbMasculino.Checked = true;
                txtDireccion.Text = empleado.direccion.ToString();
                txtSalario.Text = empleado.salario.ToString();
                dtpFechaContratacion.Value = empleado.fechaContratacion.ToString("yyyy-MM-dd");
                if (empleado.horario.ToString() == "MAÑANA")
                    rbMañana.Checked = true;
                else
                    rbNoche.Checked = true;

                if (empleado.tipoContrato.ToString() == "TiempoCompleto")
                    rbTiempoCompleto.Checked = true;
                else
                {
                    if (empleado.tipoContrato.ToString() == "TiempoParcial")
                        rbTiempoParcial.Checked = true;
                    else
                        rbContratoEspecial.Checked = true;
                }
                txtIdSupervisor.Text = empleado.supervisor.id_Persona.ToString();
            }

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
            if (rbMañana.Checked == true)
                cajero.horario = turnosHorario.MAÑANA;
            else
                cajero.horario = turnosHorario.NOCHE;
            cajero.horarioSpecified = true;
            if (rbTiempoCompleto.Checked == true)
                cajero.tipoContrato = tipoContrato.TiempoCompleto;
            else
            {
                if (rbTiempoParcial.Checked == true)
                    cajero.tipoContrato = tipoContrato.TiempoParcial;
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
            cajero.supervisor.id_Persona = int.Parse(txtIdSupervisor.Text);
            resultado = daoCajero.insertarCajero(cajero);
            if(resultado != 0)
            {
                Response.Redirect("ListarEmpleados.aspx");
                Response.Write("Se ha registrado con exito...");
            }
        }
    }
}