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
    public partial class EmpleadoArea : System.Web.UI.Page
    {
        private EmpleadoDeAreaWSClient daoEmpleado;
        private empleadoDeArea empleado;

        private AreaWSClient daoArea;
        private area area;
        private BindingList<area> listaAreaxSucursales;

        private SupervisorWSClient daoSupervisor;
        private supervisor supervisor;
        private BindingList<supervisor> listarSupervisoresXSucursal;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idEmpleadoArea;
                if (int.TryParse(Request.QueryString["id"], out idEmpleadoArea))
                {
                    CargarEmpleadoArea(idEmpleadoArea);
                }
                else
                {
                    cargarAreasXSucursales();
                    CargarSupervisoresXArea();
                }
            }
        }
        private void cargarAreasXSucursales()
        {
            daoArea = new AreaWSClient();
            area[] arregloAreas = daoArea.listarAreaConSucursales();
            listaAreaxSucursales = new BindingList<area>(arregloAreas);
            ddlAreaXSucursal.DataSource = listaAreaxSucursales;
            ddlAreaXSucursal.DataTextField = "nombre";
            ddlAreaXSucursal.DataValueField = "idArea";
            ddlAreaXSucursal.DataBind();
        }
        private void CargarEmpleadoArea(int idEmpleadoArea)
        {
            daoEmpleado = new EmpleadoDeAreaWSClient();

            empleado = daoEmpleado.buscarEmpleadoArea(idEmpleadoArea);

            if (empleado != null)
            {
                txtIdEmpleado.Text = empleado.id_Persona.ToString();
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
                if (empleado.horario.ToString() == "Empacador")
                    rbEmpacador.Checked = true;
                else
                    rbConsultor.Checked = true;
                
                BindingList<area> cargar_area = new BindingList<area>();
                cargar_area.Add(empleado.area);
                ddlAreaXSucursal.DataSource = cargar_area;
                ddlAreaXSucursal.DataTextField = "nombre";
                ddlAreaXSucursal.DataValueField = "idArea";
                ddlAreaXSucursal.DataBind();
                

                supervisor = new supervisor();
                daoSupervisor = new SupervisorWSClient();
                supervisor = daoSupervisor.buscarSupervisor(empleado.supervisor.id_Persona);
                BindingList<supervisor> cargar_supervisor = new BindingList<supervisor>();
                supervisor.nombre = supervisor.nombre + " " + supervisor.apellido_paterno + " " + supervisor.apellido_materno;
                cargar_supervisor.Add(supervisor);
                ddlSupervisor.DataSource = cargar_supervisor;
                ddlSupervisor.DataTextField = "nombre";
                ddlSupervisor.DataValueField = "id_Persona";
                ddlSupervisor.DataBind();
            }

        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarEmpleados.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            int resultado = 0;
            daoEmpleado = new EmpleadoDeAreaWSClient();
            empleadoDeArea empleado = new empleadoDeArea();
            if (!string.IsNullOrEmpty(txtIdEmpleado.Text))
            {
                empleado.id_Persona = int.Parse(txtIdEmpleado.Text);
            }
            empleado.nombre = txtNombre.Text;
            empleado.apellido_paterno = txtApellido_Paterno.Text;
            empleado.apellido_materno = txtApellido_Materno.Text;
            empleado.telefono = int.Parse(txtTelefono.Text);
            empleado.email = txtEmail.Text;
            if (rbDni.Checked)
                empleado.tipo_documento = tipoDocumento.DNI;
            else
                empleado.tipo_documento = tipoDocumento.CARNET_EXTRANJERIA;
            empleado.tipo_documentoSpecified = true;
            empleado.nro_documento = int.Parse(txtNumeroDocumento.Text);
            if (rbFemenino.Checked)
                empleado.sexo = 'F';
            else
                empleado.sexo = 'M';
            empleado.direccion = txtDireccion.Text;
            empleado.salario = Double.Parse(txtSalario.Text);
            empleado.fechaContratacion = DateTime.Parse(dtpFechaContratacion.Value);
            empleado.fechaContratacionSpecified = true;
            if (rbMañana.Checked == true)
                empleado.horario = turnosHorario.MAÑANA;
            else
                empleado.horario = turnosHorario.NOCHE;
            empleado.horarioSpecified = true;
            if (rbTiempoCompleto.Checked == true)
                empleado.tipoContrato = tipoContrato.TiempoCompleto;
            else
            {
                if (rbTiempoParcial.Checked == true)
                    empleado.tipoContrato = tipoContrato.TiempoParcial;
                else
                    empleado.tipoContrato = tipoContrato.ContratoEspecial;
            }
            empleado.tipoContratoSpecified = true;
            area area_ = new area();
            area_.idArea = int.Parse(ddlAreaXSucursal.SelectedValue);
            empleado.area = area_;
            if (rbEmpacador.Checked == true)
                empleado.puesto = tipoPuesto.Empacador;
            else
                empleado.puesto = tipoPuesto.Consultor;
            empleado.puestoSpecified = true;
            supervisor superv = new supervisor();
            superv.idEmpleado = int.Parse(ddlSupervisor.SelectedValue);
            superv.id_Persona = int.Parse(ddlSupervisor.SelectedValue);
            empleado.supervisor = superv;
            if (empleado.id_Persona > 0)
            {
                resultado = daoEmpleado.modificarEmpleadoDeArea(empleado);
            }
            else
            {
                resultado = daoEmpleado.insertarEmpleadoDeArea(empleado);
            }
            if (resultado != 0)
            {
                Response.Redirect("ListarEmpleados.aspx");
                Response.Write("Se ha registrado con exito...");
            }
        }
        protected void CargarSupervisoresXArea()
        {
            area = new area();
            daoArea = new AreaWSClient();
            int idArea = int.Parse(ddlAreaXSucursal.SelectedValue);
            area = daoArea.buscarArea(idArea);
            int idSucursal = area.sucursal.id_sucursal;
            daoSupervisor = new SupervisorWSClient();
            supervisor[] arregloSupervisores = daoSupervisor.listarSupervisoresDeUnaSucursal(idSucursal);

            ddlSupervisor.Items.Clear();

            if (arregloSupervisores != null)
            {
                listarSupervisoresXSucursal = new BindingList<supervisor>(arregloSupervisores);

                ddlSupervisor.DataSource = listarSupervisoresXSucursal;
                ddlSupervisor.DataTextField = "nombre";
                ddlSupervisor.DataValueField = "id_Persona";

                ddlSupervisor.DataBind();
            }
        }
        protected void ddlSupervisor_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarSupervisoresXArea();
        }
    }
}