using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio03
{
    class Program
    {
        public struct Carro
        {
            public int ano;
            public string modelo, cor;
        }

        static void Main(string[] args)
        {
            const int TAM = 500;
            Carro[] carros = new Carro[TAM];

            for (int x = 0; x < TAM; x++)
            {
                Console.WriteLine(".:Carros:.");
                Console.Write("\n\n1 - Cadastrar Carro");
                Console.Write("\n2 - Consultar Carro por Ano de Fabricação");
                Console.Write("\n3 - Consultar Carro por Modelo: ");
                Console.Write("\n4 - Consultar Carro por Cor"); 
                Console.Write("\n5 - Exibir os Carro Cadastrados");
                Console.Write("\n6 - Alterar Algum Dado de um Carro");
                Console.Write("\n7 - Excluir um Carro");
                Console.Write("\n0 - Sair");
            }

            Console.Clear();

            for (int x = 0; x < TAM; x++)
            {
                Console.WriteLine("\n\nDados informados: ");
            }

            Console.ReadKey();
        }
    }
}
