using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRHHController.DAO
{
    public interface SucursalDAO
    {
        int insertar(Sucursal sucursal);
        int eliminar(int idSucursal);
        BindingList<Sucursal> listar();
    }
}
