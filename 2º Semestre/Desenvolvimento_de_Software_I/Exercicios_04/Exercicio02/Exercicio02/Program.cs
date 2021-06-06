using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio02
{
    class Program
    {
        public struct Dados
        {
            public float nota1, nota2, media;
            public string nome, situacao;
        }

        static void Main(string[] args)
        {
            const int TAM = 15;
            Dados[] alunos = new Dados[TAM];

            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine(".:NOTAS E MÉDIAS:.");
            for (int x = 0; x < TAM; x++)
            {
                Console.ForegroundColor = ConsoleColor.White;
                Console.Write("\n\nNome do {0}º aluno: ", x+1);   alunos[x].nome = Console.ReadLine();
                Console.Write("Nota 1: ");                      alunos[x].nota1 = float.Parse(Console.ReadLine());
                Console.Write("Nota 2: ");                      alunos[x].nota2 = float.Parse(Console.ReadLine());
                
                alunos[x].media = (alunos[x].nota1 + alunos[x].nota2) / 2;

                if (alunos[x].media < 7)
                {
                    alunos[x].situacao = "Reprovado";
                }else{
                    alunos[x].situacao = "Aprovado";
                }
            }

            Console.Clear();

            Console.WriteLine("\n\nDados informados: ");

            

                for (int x = 0; x < TAM; x++)
                {
                    Console.Write("\n\n\nNome: {0}", alunos[x].nome);
                    Console.Write("\t\tNota1: {0}", alunos[x].nota1);
                    Console.Write("\t\tNota2: {0}", alunos[x].nota2);
                    Console.Write("\nMédia: {0}", alunos[x].media);
                    Console.Write("\t\tSituação: {0}", alunos[x].situacao);
                    Console.WriteLine("\n\n\n--------------------------------------------------------------------");
                }
            Console.ReadKey();
        }
    }
}
