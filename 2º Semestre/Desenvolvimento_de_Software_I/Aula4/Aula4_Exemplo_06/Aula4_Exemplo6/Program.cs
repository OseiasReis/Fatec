using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula4_Exemplo6
{
    class Program
    {
        static void Main(string[] args)
        {
            const int tam = 5;
            string[] cursos = new string[tam];

            Console.WriteLine("*** Cursos Técnicos ***\n");

            //Chamada para execução do método para cadastro de cursos
            cursos = cadastroCursos();

            Console.WriteLine("\n *** Cursos cadastrados no vetor ***\n");
            for (int x = 0; x < cursos.Length; x++)
                Console.WriteLine("{0}º Curso : {1}", x + 1, cursos[x]);

            Console.ReadKey();
        }

        static string[] cadastroCursos()
        {
            string[] vetorAuxiliar = new string[5];
            //Entrada dos dados no vetor
            for (int x = 0; x < 5; x++)
            {
                Console.Write("Digite o nome do {0}º Curso: ", x + 1);
                vetorAuxiliar[x] = Console.ReadLine();
            }
            return vetorAuxiliar;
        }
    }
}
