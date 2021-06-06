using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        public struct Pessoa
        {
            public string nome;
            public int idade;
            public double altura;
        }
        static void Main(string[] args)
        {
            Pessoa pessoa1, pessoa2;

            pessoa1.nome = "Fulana da Silva";
            pessoa2.nome = "Cicrano de Tal";

            pessoa1.idade = 30;
            pessoa2.idade = 65;

            pessoa1.altura = 1.51;
            pessoa2.altura = 1.84;

            Console.Write("\n\n{0} com {1} anos de idade e mede: {2:N2}m de altura \n\n", pessoa1.nome, pessoa1.idade, pessoa1.altura);
            Console.Write("\n\n{0} com {1} anos de idade e mede: {2:N2}m de altura \n\n", pessoa2.nome, pessoa2.idade, pessoa2.altura);

            Console.ReadKey();
        }
    }
}
