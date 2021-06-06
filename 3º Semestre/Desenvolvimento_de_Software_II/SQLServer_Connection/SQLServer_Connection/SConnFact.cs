using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using System.Threading.Tasks;

namespace SQLServer_Connection
{
    class SConnFact
    {
        public static String connectionFactoryUeP(string ServerName, string DataBaseName, string UserName, string Secret){
            String conn;

            conn = "Data Source=" + ServerName + ";" +
                  "Initial Catalog=" + DataBaseName + ";" +
                  "User id=" + UserName + ";" +
                  "Password=" + Secret + ";";

            return conn;
        }

        public static String connectionFactory(string ServerName, string DataBaseName)
        {
            String conn;

            conn =        "Data Source=" + ServerName +";" +
                          "Initial Catalog=" + DataBaseName +";" +
                          "Integrated Security=SSPI;";
            return conn;
        }
    }
}
