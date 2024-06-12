using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public class Area
    {
        private int idArea;
        private string nombre;
        private string sucursal;
        private bool activo;

        public int IdArea { get => idArea; set => idArea = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Sucursal { get => sucursal; set => sucursal = value; }
        public bool Activo { get => activo; set => activo = value; }
    }
}
