using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        public struct Aluno
        {
            public string nome;
            public int matricula;
            public double nota;
        }

        static void Main(string[] args)
        {
            const int TAM = 5;
            Aluno[] alunos = new Aluno[TAM];

            Console.WriteLine("**** CADASTRANDO OS DADOS ****\n");
            for (int x = 0; x < TAM; x++)
            {
                Console.Write("\nNome do {0}º aluno: ", x + 1); alunos[x].nome = Console.ReadLine();
                Console.Write("Matrícula: "); alunos[x].matricula = int.Parse(Console.ReadLine());
                Console.Write("Nota: "); alunos[x].nota = double.Parse(Console.ReadLine());
            }

            Console.Clear();
            Console.WriteLine("**** EXIBINDO OS DADOS ****\n");
            for (int x = 0; x < TAM; x++)
            {
                Console.WriteLine("\nNome do {0}º aluno: {1}", x + 1, alunos[x].nome);
                Console.WriteLine("Matrícula: {0}", alunos[x].matricula);
                Console.WriteLine("Nota: {0:N1}", alunos[x].nota);
            }
            Console.ReadKey();
        }
    }
}
