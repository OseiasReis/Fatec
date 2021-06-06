using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;


namespace SQLServer_Connection
{
    class Program
    {
        static void Main(string[] args)
        {
            string Con1 = SConnFact.connectionFactoryUeP("localhost", "ilibrary", "sa", "info211");
            string Con2 = SConnFact.connectionFactory("localhost", "ilibrary");

            Console.WriteLine(Con1);
            Console.WriteLine(Con2);

            string queryString =
            "SELECT * FROM funcionario";
            using (SqlConnection connection = new SqlConnection(
                   Con1))
            {
                SqlCommand command = new SqlCommand(
                    queryString, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                try
                {
                    while (reader.Read())
                    {
                        Console.WriteLine(String.Format("Id: {0},     Nome: {1},     Idade: {2}",
                            reader[0], reader[1], reader[2]));
                    }
                }
                finally
                {
                    reader.Close();
                }
                Console.ReadKey();
            }
        }
    }
}
