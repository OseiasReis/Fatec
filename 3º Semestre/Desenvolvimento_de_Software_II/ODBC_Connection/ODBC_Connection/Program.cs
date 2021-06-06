using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.Odbc;
using System.Data;

namespace ODBC_Connection
{
    class Program
    {
        static void Main(string[] args)
        {
            string Con1 = ("DSN=localhost;MutipeActivesultSets=True");

            string queryString = "SELECT * FROM aluno";
            OdbcCommand command = new OdbcCommand(queryString);
            try{ 

                using (OdbcConnection connection = new OdbcConnection(Con1))
                {
                    command.Connection = connection;
                    connection.Open();

                    OdbcDataReader reader = command.ExecuteReader();
                        while (reader.Read())
                        {
                            Console.WriteLine(String.Format("Id: {0},     Nome: {1},     Idade: {2}",
                                reader[0], reader[1], reader[2]));
                        }
                    Console.ReadKey();
                    command.ExecuteNonQuery();
                }
            }
            catch (Exception e){
                Console.WriteLine("Conexão ODBC não estabelecida");
                Console.WriteLine("Erro: " + e);
                Console.ReadKey();
            }
        }
    }
}
