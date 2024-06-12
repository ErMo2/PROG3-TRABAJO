using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public class Sucursal
    {
        private int idSucursal;
        private string nombreSucursal;
        private double metrosCuadrados;

        public int IdSucursal { get => idSucursal; set => idSucursal = value; }
        public string NombreSucursal { get => nombreSucursal; set => nombreSucursal = value; }
        public double MetrosCuadrados { get => metrosCuadrados; set => metrosCuadrados = value; }
    }
}
